package personspotterapi.personPotterApi.dto;

import java.util.List;
import java.util.stream.Collectors;



import personspotterapi.personPotterApi.entity.Characters;

/** Class responsible for defining a character object exposure template for application consumers
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/

public class CharacterDTO {
	
	private Long id;
	
	private String name;
	
	private String role;
	
	private String school;

	private String house;
	
	private String patronus;

	
	/** Method responsible for getting the CharacterDTO object id
	 * 
	 * @return Returns the id property of the CharacterDTO object 
	 */
	public Long getId() {
		return id;
	}


	/** Method responsible for setting the CharacterDTO object id
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/** Method responsible for getting the CharacterDTO object name
	 * 
	 * @return Returns the name property of the CharacterDTO object
	 */
	public String getName() {
		return name;
	}


	/** Method responsible for setting the CharacterDTO object name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/** Method responsible for getting the CharacterDTO object role
	 * 
	 * @return Returns the role property of the CharacterDTO object
	 */
	public String getRole() {
		return role;
	}


	/** Method responsible for setting the CharacterDTO object role
	 * 
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}


	/** Method responsible for getting the CharacterDTO object school
	 * 
	 * @return Returns the school property of the CharacterDTO object
	 */
	public String getSchool() {
		return school;
	}


	/** Method responsible for setting the CharacterDTO object school
	 * 
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}


	/** Method responsible for getting the CharacterDTO object house
	 * 
	 * @return Returns the house property of the CharacterDTO object
	 */
	public String getHouse() {
		return house;
	}


	/** Method responsible for setting the CharacterDTO object house
	 * 
	 * @param house
	 */
	public void setHouse(String house) {
		this.house = house;
	}


	/** Method responsible for getting the CharacterDTO object patronus
	 * 
	 * @return Returns the patronus property of the CharacterDTO object
	 */
	public String getPatronus() {
		return patronus;
	}


	/** Method responsible for setting the CharacterDTO object patronus
	 * 
	 * @param patronus
	 */
	public void setPatronus(String patronus) {
		this.patronus = patronus;
	}

	/** Constructor of the class responsible for converting a Characters object to CharacterDTO
	 * 
	 * @param character
	 */
	public CharacterDTO(Characters character) {
		this.id = character.getId();
		this.name = character.getName();
		this.school = character.getSchool();
		this.role = character.getRole();
		this.patronus = character.getPatronus();
		this.house = character.getHouse();
	}


	/** Method responsible for converting an array of Character objects to an array of CharacterDTO Objects
	 * 
	 * @param characters
	 * @return Returns an array of CharacterDTO objects
	 */
	public static List<CharacterDTO> converter(List<Characters> characters) {
		return characters.stream().map(CharacterDTO::new).collect(Collectors.toList()); 
	}

}
