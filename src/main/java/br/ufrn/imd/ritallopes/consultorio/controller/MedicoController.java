package br.ufrn.imd.ritallopes.consultorio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufrn.imd.ritallopes.consultorio.model.Medico;
import br.ufrn.imd.ritallopes.consultorio.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService service;
	
	@GetMapping
	public ResponseEntity<List<Medico>> getMedicos() {
		return ResponseEntity.ok(service.getMedicos());
	}
	@GetMapping("{cpf}")
	public ResponseEntity<Medico> getMedicoByCpf(@PathVariable String cpf) {
		Optional <Medico> m = service.getMedicoByCpf(cpf);
		if(m.isPresent()) {
			return ResponseEntity.ok().body(m.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Medico> addMedico(@RequestBody Medico medico) {
		return service.addMedico(medico);
	}
	
	@PutMapping("{cpf}")
	public ResponseEntity<Medico> updateMedico(@PathVariable String cpf, @RequestBody Medico medico) {
		return service.updateMedicos(cpf, medico);
	}
	
	
	@DeleteMapping("{cpf}")
	public ResponseEntity<Void> deleteMedico(@PathVariable String cpf) {
		return service.deleteMedico(cpf);
	}
	
	

}