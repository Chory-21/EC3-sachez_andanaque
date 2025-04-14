package com.example.EC3_sachez_andanaque.controller;

import com.example.EC3_sachez_andanaque.dto.MatriculaDTO;
import com.example.EC3_sachez_andanaque.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
@CrossOrigin(origins = {"*"}, methods = {RequestMethod.PUT, RequestMethod.POST})
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<String> crearMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        try {
            // Directly pass Date without converting to String first
            matriculaService.crearMatricula(
                    matriculaDTO.getNombre(),
                    matriculaDTO.getDateOfBirth(),  // Directly use the Date object
                    matriculaDTO.getEmail(),
                    matriculaDTO.getDocenteId(),
                    matriculaDTO.getSeccionId(),
                    matriculaDTO.getCourseId(),
                    matriculaDTO.getGradoId(),
                    matriculaDTO.getFechaMatricula()  // Directly use the Date object
            );
            return ResponseEntity.ok("Matrícula creada con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error interno del servidor: " + e.getMessage());
        }
    }

    @PreAuthorize("hasAnyRole('SUPERVISOR')")
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarMatricula(@RequestBody MatriculaDTO matriculaDTO, @RequestParam Integer matriculaId) {
        try {
            // Directly pass Date without converting to String first
            matriculaService.actualizarMatricula(
                    matriculaId,
                    matriculaDTO.getNombre(),
                    matriculaDTO.getDateOfBirth(),  // Directly use the Date object
                    matriculaDTO.getEmail(),
                    matriculaDTO.getDocenteId(),
                    matriculaDTO.getSeccionId(),
                    matriculaDTO.getCourseId(),
                    matriculaDTO.getGradoId(),
                    matriculaDTO.getFechaMatricula()  // Directly use the Date object
            );
            return ResponseEntity.ok("Matrícula actualizada con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error interno del servidor: " + e.getMessage());
        }
    }
}
