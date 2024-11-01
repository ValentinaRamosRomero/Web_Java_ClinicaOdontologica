package com.example.ClinicaOdontologicaC3.service;

import com.example.ClinicaOdontologicaC3.Entity.Domicilio;
import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Test
    @Order(1)
    public void guardarPaciente(){
        Paciente paciente = new Paciente("Valentina","Ramos","22222", LocalDate.of(2024,9,9), new Domicilio("Villa Javier", 123, "Springfield","BOG"),"valen.ramos@digitalhouse.com");
        Paciente pacienteGuardado = pacienteService.guardarPaciente(paciente);
        assertEquals(1L, pacienteGuardado.getId());
    }

    @Test
    @Order(2)
    public void buscarPaciente(){
        Long id = 1L;
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(id);
        assertNotNull(pacienteBuscado.get());
    }

    @Test
    @Order(3)
    public void actualizarPaciente(){
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(1L);
        if(pacienteBuscado.isPresent()){
            pacienteBuscado.get().setApellido("Ramos");
        }
        pacienteService.actualizarPaciente(pacienteBuscado.get());
        assertEquals("Ramos", pacienteBuscado.get().getApellido());
    }

    @Test
    @Order(4)
    public void BuscarTodos(){
        List<Paciente> pacientes = pacienteService.listarTodos();
        assertEquals(1,pacientes.size());
    }

    @Test
    @Order(5)
    public void eliminarPaciente(){
        pacienteService.eliminarPaciente(1L);
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(1L);
        assertFalse(pacienteBuscado.isPresent());
    }
}
