package com.example.ClinicaOdontologicaC3.Service;


import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OdontologoService {

     //metodos manuales CRUD
     @Autowired
    private OdontologoRepository odontologoRepository;
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public void actualizarOdontologo (Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
    public String eliminarOdontologo (Long id){
        if(odontologoRepository.findById(id).isPresent()){
            odontologoRepository.deleteById(id);
            return "Odontologo con id" + id +"eliminado";
        }
        return "Odontologo con id" + id +"no existe";
    }
    public Optional<Odontologo> buscarPorId(Long id){
        return odontologoRepository.findById(id);
    }
    public Optional<Odontologo> buscarPorMatricula(String matricula){
        return odontologoRepository.findByMatricula(matricula);
    }

    public List<Odontologo> listarTodos(){
        return odontologoRepository.findAll();
    }


}
