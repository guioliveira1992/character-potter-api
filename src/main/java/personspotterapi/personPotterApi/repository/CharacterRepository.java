package personspotterapi.personPotterApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import personspotterapi.personPotterApi.entity.Characters;

/** Interface responsible for integrating with JPARepository
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/
public interface CharacterRepository extends JpaRepository<Characters, Long>{
	
	/** Method responsible for searching character objects by the value of the house attribute
	 * 
	 * @param house
	 * @return Returns a list of character objects
	 */
	@Query("SELECT c FROM Characters c WHERE c.house = :house")
	List<Characters> findByCriteriaHouse(@Param("house") String house);

}
