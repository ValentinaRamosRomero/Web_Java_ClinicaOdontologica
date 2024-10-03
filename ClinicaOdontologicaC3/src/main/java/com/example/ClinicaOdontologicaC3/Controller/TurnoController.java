package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaC3.Service.OdontologoService;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import com.example.ClinicaOdontologicaC3.Service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private TurnoService turnoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    public TurnoController(){
        turnoService = new TurnoService();
        pacienteService = new PacienteService();
        odontologoService = new OdontologoService();
    }
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno) throws BadRequestException {
        //Filtro para validar la existencia del paciente
        Optional<Paciente> pacienteBuscado = pacienteService.buscarPorId(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBuscado = odontologoService.buscarPorId(turno.getOdontologo().getId());
        if(pacienteBuscado!=null && odontologoBuscado!=null){
            return ResponseEntity.ok(turnoService.registrarTurno(turno));
        }if(pacienteBuscado!=null && odontologoBuscado == null){
            throw new BadRequestException("No hay registro de odontologo");
        }
        throw new BadRequestException("No hay registro de paciente");
    }
    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos(){
        return ResponseEntity.ok(turnoService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Turno>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    @DeleteMapping("/turno/delete/{id}")
    public ResponseEntity<String> eliminarTurno(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.eliminarTurno(id));
    }
}
