package com.example.EC3_sachez_andanaque.Security;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroJWTAuthorization extends OncePerRequestFilter {

    private final String KEY = "@idat2025";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            if (validarUsoDeToken(request)) {
                Claims claims = validarToken(request);
                if (claims.get("Authorities") != null) {
                    cargarAutorizaciones(claims);
                } else
                    SecurityContextHolder.clearContext();
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException | UnsupportedJwtException
                 | MalformedJwtException ex) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(
                    HttpServletResponse.SC_FORBIDDEN,
                    ex.getMessage());
        }
    }

    private void cargarAutorizaciones(Claims claims) {
        List<String> autorizaciones = (List<String>)
                claims.get("Authorities");
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        claims.getSubject(),
                        null,
                        autorizaciones.stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList()));
        SecurityContextHolder.getContext().setAuthentication(
                authToken);
    }

    private Claims validarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization")
                .replace("Bearer ", "");
        return Jwts.parser().setSigningKey(KEY.getBytes())
                .parseClaimsJws(token).getBody();
    }

    private boolean validarUsoDeToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return false;
        }
        return true;
    }
}