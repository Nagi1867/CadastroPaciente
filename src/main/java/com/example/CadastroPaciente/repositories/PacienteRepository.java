package com.example.CadastroPaciente.repositories;

import com.example.CadastroPaciente.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente ,Long> {
}
