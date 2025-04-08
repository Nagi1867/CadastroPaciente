package com.example.CadastroPaciente.services;

import com.example.CadastroPaciente.entities.Paciente;
import com.example.CadastroPaciente.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repository;

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente findById(Long id) {
        Optional<Paciente> obj = repository.findById(id);
        return obj.get();
    }

    public Paciente insert(Paciente obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Paciente update(Long id, Paciente obj) {
        Paciente entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Paciente entity, Paciente obj) {
        entity.setNome(obj.getNome());
        entity.setIdentificacao(obj.getIdentificacao());
        entity.setStatus(obj.getStatus());
    }
}
