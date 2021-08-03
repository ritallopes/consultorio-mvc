package br.ufrn.imd.ritallopes.consultorio.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.ufrn.imd.ritallopes.consultorio.model.Medico;
import br.ufrn.imd.ritallopes.consultorio.repository.MedicoRepository;
import lombok.Getter;

@Getter
@Service
public class MedicoService {
	@Autowired
	private MedicoRepository medicoRepository;
	
	public Optional<Medico> getMedicoByCpf(String cpf){
		return medicoRepository.findById(cpf);
	}
	
	public List<Medico> getMedicos(){
		return (List<Medico>) medicoRepository.findAll();
	}
	
	public ResponseEntity<Medico> addMedico(Medico medico){
		return ResponseEntity.ok().body(medicoRepository.save(medico));
	}
	
	public ResponseEntity<Medico> updateMedicos(String cpf, Medico medicoAtualizado){
		Optional <Medico> p = medicoRepository.findById(cpf);
		if(!p.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Medico medico  = p.get();
		medico.setDataContratacao(medicoAtualizado.getDataContratacao());
		medico.setEspecialidade(medicoAtualizado.getEspecialidade());
		medico.setNome(medicoAtualizado.getNome());
		medico.setCrm(medicoAtualizado.getCrm());
		medico.setTelefone(medicoAtualizado.getTelefone());
		medicoRepository.save(medico);
		return ResponseEntity.ok().body(getMedicoByCpf(cpf).get());
	}
	
	public ResponseEntity<Void> deleteMedico(String cpf){
		Optional<Medico> l = medicoRepository.findById(cpf);
		if(!l.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		medicoRepository.deleteById(cpf);
		return ResponseEntity.noContent().build();
	}

}
