package com.example.ClinicaOdontologicaC3.Service;


import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService  {
    @Autowired
    private TurnoRepository turnoRepository;
    public Turno registrarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public Optional<Turno> buscarPorId(Long id){
        return turnoRepository.findById(id);
    }
    public List<Turno> listarTodos(){
        return turnoRepository.findAll();
    }
    public String eliminarTurno (Long id){
        if(turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            return "Turno con id" + id +"eliminado";
        }
        return "Turno con id" + id +"no existe";
    }

}
