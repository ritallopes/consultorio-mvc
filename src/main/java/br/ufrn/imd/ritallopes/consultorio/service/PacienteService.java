package br.ufrn.imd.ritallopes.consultorio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufrn.imd.ritallopes.consultorio.model.Paciente;
import br.ufrn.imd.ritallopes.consultorio.repository.PacienteRepository;
import lombok.Getter;

@Getter
@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;
	public Optional<Paciente> getPacienteByCpf(String cpf){
		return pacienteRepository.findById(cpf);
	}
	
	public List<Paciente> getPacientes(){
		return (List<Paciente>) pacienteRepository.findAll();
	}
	
	public ResponseEntity<Paciente> addPaciente(Paciente paciente){
		return ResponseEntity.ok().body(pacienteRepository.save(paciente));
	}
	
	public ResponseEntity<Paciente> updatePacientes(String cpf, Paciente pacienteAtualizado){
		Optional <Paciente> p = pacienteRepository.findById(cpf);
		if(!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Paciente paciente  = p.get();
		paciente.setConvenio(pacienteAtualizado.getConvenio());
		paciente.setDataCadastro(pacienteAtualizado.getDataCadastro());
		paciente.setNome(pacienteAtualizado.getNome());
		paciente.setTelefone(pacienteAtualizado.getTelefone());
		pacienteRepository.save(paciente);
		return ResponseEntity.ok().body(getPacienteByCpf(cpf).get());
	}
	
	public ResponseEntity<Void> deletePaciente(String cpf){
		Optional<Paciente> l = pacienteRepository.findById(cpf);
		if(!l.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pacienteRepository.deleteById(cpf);
		return ResponseEntity.noContent().build();
	}

}
