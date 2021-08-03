/**
 * @author Rita Lopes
 */
package br.ufrn.imd.ritallopes.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.ritallopes.consultorio.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, String>{

}
