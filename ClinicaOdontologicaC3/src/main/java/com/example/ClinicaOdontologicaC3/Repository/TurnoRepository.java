package com.example.ClinicaOdontologicaC3.Repository;

import com.example.ClinicaOdontologicaC3.Entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

}
