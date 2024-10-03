package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PacienteService {
    //metodos manuales CRUD
    @Autowired
    private PacienteRepository pacienteRepository;
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public void actualizarPaciente (Paciente paciente){
        pacienteRepository.save(paciente);
    }
    public String eliminarPaciente (Long id){
        if(pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            return "Paciente con id" + id +"eliminado";
        }
        return "Paciente con id" + id +"no existe";
    }
    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }
    public Optional<Paciente> buscarPorEmail(String email){
        return pacienteRepository.findByEmail(email);
    }

    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }

}
