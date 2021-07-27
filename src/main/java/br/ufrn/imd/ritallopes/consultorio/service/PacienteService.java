package br.ufrn.imd.ritallopes.consultorio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufrn.imd.ritallopes.consultorio.model.Paciente;
import lombok.Getter;

@Getter
@Service
public class PacienteService {
	
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	public String addPaciente(Paciente paciente) {
		pacientes.add(paciente);		
		return "Paciente [" +paciente.toString()+"] adicionado";		
	}

	public String deletePaciente(String cpf) {
		for (Paciente p: pacientes) {
			if(p.getCpf().equals(cpf)) {
				pacientes.remove(p);
				return "Paciente removido!";
			}
		}
		return "Paciente não encontrado!";
		
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}
}
