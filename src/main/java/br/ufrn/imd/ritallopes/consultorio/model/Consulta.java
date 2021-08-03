package br.ufrn.imd.ritallopes.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rita Lopes
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false, nullable = false)
	private Integer id;
	private String cpfPaciente;
	private String cpfMedico;
	private String inicio;
	private String fim;
	private Boolean concluida;
	
	
	public String toString() {
		return "ID: "+this.id+", Inicio: "+this.inicio+", Fim: "+this.fim+" CPF do Paciente:\n\t"+this.cpfPaciente+"\n\t CPF do Médico:"+this.cpfMedico;
	}

}