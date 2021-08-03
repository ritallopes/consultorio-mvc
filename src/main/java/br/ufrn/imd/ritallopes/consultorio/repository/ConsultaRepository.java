/**
 * @author Rita Lopes
 */
package br.ufrn.imd.ritallopes.consultorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.imd.ritallopes.consultorio.model.Consulta;
import br.ufrn.imd.ritallopes.consultorio.model.Medico;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

}
