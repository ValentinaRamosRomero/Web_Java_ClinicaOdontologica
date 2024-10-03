package com.example.ClinicaOdontologicaC3.service;


import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;
    @Test
    @Order(1)
    public void guardarOdontologo(){
        Odontologo odontologo = new Odontologo("102030","Javier","Neira");
        Odontologo odontologoGuardado = odontologoService.guardarOdontologo(odontologo);
        assertEquals(1L, odontologoGuardado.getId());
    }

    @Test

    @Order(2)
    public void buscarOdontologo(){
        Long id = 1L;
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(id);
        assertNotNull(odontologoBuscado.get());
    }

    @Test
    @Order(3)
    public void actualizarOdontologo(){
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(1L);
        if(odontologoBuscado.isPresent()){
            odontologoBuscado.get().setApellido("Neira");
        }
        odontologoService.actualizarOdontologo(odontologoBuscado.get());
        assertEquals("Neira", odontologoBuscado.get().getApellido());
    }

    @Test
    @Order(4)
    public void BuscarTodos(){
        List<Odontologo> odontologos = odontologoService.listarTodos();
        assertEquals(1,odontologos.size());
    }

    @Test
    @Order(5)
    public void eliminarOdontologo(){
        odontologoService.eliminarOdontologo(1L);
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(1L);
        assertFalse(odontologoBuscado.isPresent());
    }
}

