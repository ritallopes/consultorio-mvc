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
public class Medico{
	
	@Id
	@Column(length = 11, updatable = false)
	private String cpf;
	@Column(nullable=false, columnDefinition = "TEXT")
	private String nome;
	private String telefone;
	@Column(nullable=false)
	private String crm;
	private String especialidade;
	private String dataContratacao;
	
	public String toString() {
		return ("CPF:"+this.cpf+", Nome: "+this.nome+", Telefone:"+this.telefone+" Data Cadastro: "+this.dataContratacao+","+" CRM: "+this.crm+", Especialidade: "+this.especialidade);
	}
}