package br.ufrn.imd.ritallopes.consultorio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufrn.imd.ritallopes.consultorio.model.Consulta;
import br.ufrn.imd.ritallopes.consultorio.repository.ConsultaRepository;
import lombok.Getter;

@Getter
@Service
public class ConsultaService {
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public Optional<Consulta> getConsultaById(Integer id){
		return consultaRepository.findById(id);
	}
	
	public List<Consulta> getConsultas(){
		return (List<Consulta>) consultaRepository.findAll();
	}
	
	public ResponseEntity<Consulta> addConsulta(Consulta consulta){
		return ResponseEntity.ok().body(consultaRepository.save(consulta));
	}
	
	public ResponseEntity<Consulta> updateConsultas(Integer id, Consulta consultaAtualizado){
		Optional <Consulta> c = consultaRepository.findById(id);
		if(!c.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Consulta consulta  = c.get();
		consulta.setConcluida(consultaAtualizado.getConcluida());
		consulta.setCpfMedico(consultaAtualizado.getCpfMedico());
		consulta.setCpfPaciente(consultaAtualizado.getCpfPaciente());
		consulta.setFim(consultaAtualizado.getFim());
		consulta.setInicio(consultaAtualizado.getInicio());

		consultaRepository.save(consulta);
		return ResponseEntity.ok().body(getConsultaById(id).get());
	}
	
	public ResponseEntity<Void> deleteConsulta(Integer id){
		Optional<Consulta> l = consultaRepository.findById(id);
		if(!l.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		consultaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
