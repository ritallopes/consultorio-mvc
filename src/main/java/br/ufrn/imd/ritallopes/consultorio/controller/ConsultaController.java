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

import br.ufrn.imd.ritallopes.consultorio.model.Consulta;
import br.ufrn.imd.ritallopes.consultorio.service.ConsultaService;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService service;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> getConsultas() {
		return ResponseEntity.ok(service.getConsultas());
	}
	@GetMapping("{id}")
	public ResponseEntity<Consulta> getConsultaById(@PathVariable Integer id) {
		Optional <Consulta> m = service.getConsultaById(id);
		if(m.isPresent()) {
			return ResponseEntity.ok().body(m.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Consulta> addConsulta(@RequestBody Consulta consulta) {
		return service.addConsulta(consulta);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Consulta> updateConsulta(@PathVariable Integer id, @RequestBody Consulta consulta) {
		return service.updateConsultas(id, consulta);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteConsulta(@PathVariable Integer id) {
		return service.deleteConsulta(id);
	}
	
	

}
