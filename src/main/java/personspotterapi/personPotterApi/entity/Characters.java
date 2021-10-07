package personspotterapi.personPotterApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/** Class responsible for defining the entity and database table in which the character object will be persisted
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/

@Entity
public class Characters {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String name;
	
	private String role;
	
	private String school;
	@NotNull @NotEmpty
	private String house;
	
	private String patronus;

	/** Method responsible for getting the character object id
	 * 
	 * @return Returns the id property of the character object 
	 */
	public Long getId() {
		return id;
	}

	/** Method responsible for setting the character object id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/** Method responsible for getting the character object name
	 * 
	 * @return Returns the name property of the character object
	 */
	public String getName() {
		return name;
	}

	/** Method responsible for setting the character object name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Method responsible for getting the character object role
	 * 
	 * @return Returns the role property of the character object
	 */
	public String getRole() {
		return role;
	}

	/** Method responsible for setting the character object role
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/** Method responsible for getting the character object school
	 * 
	 * @return Returns the school property of the character object
	 */
	public String getSchool() {
		return school;
	}

	/** Method responsible for setting the character object school
	 * 
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/** Method responsible for getting the character object house
	 * 
	 * @return Returns the house property of the character object
	 */
	public String getHouse() {
		return house;
	}

	/** Method responsible for setting the character object house
	 * 
	 * @param house
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/** Method responsible for getting the character object patronus
	 * 
	 * @return Returns the patronus property of the character object
	 */
	public String getPatronus() {
		return patronus;
	}

	/** Method responsible for setting the character object patronus
	 * 
	 * @param patronus
	 */
	public void setPatronus(String patronus) {
		this.patronus = patronus;
	}
	
	/** Default class builder, required for JPA integration
	 * 
	 */
	public Characters() {
		
	}
 
	/** Constructor of the class with its attributes
	 * 
	 * @param id
	 * @param name
	 * @param role
	 * @param school
	 * @param house
	 * @param patronus
	 */
	public Characters(Long id, String name, String role, String school, String house, String patronus) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.school = school;
		this.house = house;
		this.patronus = patronus;
	}
	
	

}
