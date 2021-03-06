package br.ufrn.imd.ritallopes.consultorio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Paciente{
	
	@Id
	@Column(length = 11, updatable = false)
	private String cpf;
	@Column(nullable=false, columnDefinition = "TEXT")
	private String nome;
	private String telefone;	
	private String convenio;
	private String dataCadastro;
	
	public String toString() {
		return ("CPF:"+this.cpf+", Nome: "+this.nome+", Telefone:"+this.telefone+","+" Convenio: "+this.convenio+", data de Cadastro: "+this.dataCadastro);
	}
}