package br.ufrn.imd.ritallopes.consultorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping
	public ResponseEntity<String> addPaciente(@RequestBody Paciente paciente) {
		return ResponseEntity.ok(service.addPaciente(paciente));
	}
	
	@DeleteMapping("{cpf}")
	public ResponseEntity<String> deletePaciente(@PathVariable String cpf) {
		return ResponseEntity.ok(service.deletePaciente(cpf));
	}

}
