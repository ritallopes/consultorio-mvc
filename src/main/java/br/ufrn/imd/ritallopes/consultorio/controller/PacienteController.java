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

import br.ufrn.imd.ritallopes.consultorio.model.Paciente;
import br.ufrn.imd.ritallopes.consultorio.model.Paciente;
import br.ufrn.imd.ritallopes.consultorio.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteService service;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> getPacientes() {
		return ResponseEntity.ok(service.getPacientes());
	}
	@GetMapping("{cpf}")
	public ResponseEntity<Paciente> getPacienteByCpf(@PathVariable String cpf) {
		Optional <Paciente> p = service.getPacienteByCpf(cpf);
		if(p.isPresent()) {
			return ResponseEntity.ok().body(p.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Paciente> addPaciente(@RequestBody Paciente paciente) {
		return service.addPaciente(paciente);
	}
	
	@PutMapping("{cpf}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable String cpf, @RequestBody Paciente paciente) {
		return service.updatePacientes(cpf, paciente);
	}
	
	
	@DeleteMapping("{cpf}")
	public ResponseEntity<Void> deletePaciente(@PathVariable String cpf) {
		return service.deletePaciente(cpf);
	}
	
	

}
