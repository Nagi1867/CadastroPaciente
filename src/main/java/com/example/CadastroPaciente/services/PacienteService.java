package com.example.CadastroPaciente.services;

import com.example.CadastroPaciente.entities.Paciente;
import com.example.CadastroPaciente.repositories.PacienteRepository;
import com.example.CadastroPaciente.services.exceptions.DatabaseException;
import com.example.CadastroPaciente.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Paciente insert(Paciente obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Paciente update(Long id, Paciente obj) {
        try {
            Paciente entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Paciente entity, Paciente obj) {
        entity.setNome(obj.getNome());
        entity.setIdentificacao(obj.getIdentificacao());
        entity.setStatus(obj.getStatus());
    }
}
