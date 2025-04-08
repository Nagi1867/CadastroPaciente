package com.example.CadastroPaciente.config;

import com.example.CadastroPaciente.entities.Paciente;
import com.example.CadastroPaciente.enums.Status;
import com.example.CadastroPaciente.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PacienteRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Paciente paciente = new Paciente(null, "Joseph", "0949043409", Status.ATIVO);

        repository.save(paciente);
    }
}
