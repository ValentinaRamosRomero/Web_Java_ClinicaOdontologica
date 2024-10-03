package com.example.ClinicaOdontologicaC3.Repository;

import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByEmail(String correo);
}
