package com.example.CadastroPaciente.resources;

import com.example.CadastroPaciente.entities.Paciente;
import com.example.CadastroPaciente.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {
    @Autowired
    private PacienteService service;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        List<Paciente> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id) {
        Paciente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);git 
    }
}
