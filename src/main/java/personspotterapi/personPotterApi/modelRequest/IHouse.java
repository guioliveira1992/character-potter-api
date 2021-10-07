package personspotterapi.personPotterApi.modelRequest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Class responsible for defining the object template that will be returned from potterapi
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/

@JsonAutoDetect
public class IHouse {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("headOfHouse")
	private String headOfHouse;
	
	@JsonProperty("values")
	private List<String> values;
	
	@JsonProperty("colors")
	private List<String> colors;
	
	@JsonProperty("school")
	private String school;
	
	@JsonProperty("mascot")
	private String mascot;
	
	@JsonProperty("houseGhost")
	private String houseGhost;
	
	@JsonProperty("founder")
	private String founder;

	/** Method responsible for getting the IHouse object id
	 * 
	 * @return Returns the id property of the IHouse object 
	 */
	public String getId() {
		return id;
	}

	/** Method responsible for setting the IHouse object id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** Method responsible for getting the IHouse object name
	 * 
	 * @return Returns the name property of the IHouse object 
	 */
	public String getName() {
		return name;
	}

	/** Method responsible for setting the IHouse object name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Method responsible for getting the IHouse object headOfHouse
	 * 
	 * @return Returns the headOfHouse property of the IHouse object 
	 */
	public String getHeadOfHouse() {
		return headOfHouse;
	}

	/** Method responsible for setting the IHouse object headOfHouse
	 * 
	 * @param headOfHouse
	 */
	public void setHeadOfHouse(String headOfHouse) {
		this.headOfHouse = headOfHouse;
	}

	/** Method responsible for getting the IHouse object values
	 * 
	 * @return Returns the values property of the IHouse object 
	 */
	public List<String> getValues() {
		return values;
	}

	/** Method responsible for setting the IHouse object values
	 * 
	 * @param values
	 */
	public void setValues(List<String> values) {
		this.values = values;
	}

	/** Method responsible for getting the IHouse object colors
	 * 
	 * @return Returns the colors property of the IHouse object 
	 */
	public List<String> getColors() {
		return colors;
	}

	/** Method responsible for setting the IHouse object colors
	 * 
	 * @param colors
	 */
	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	/** Method responsible for getting the IHouse object school
	 * 
	 * @return Returns the school property of the IHouse object 
	 */
	public String getSchool() {
		return school;
	}

	/** Method responsible for setting the IHouse object school
	 * 
	 * @param school
	 */
	public void setSchool(String school) {
		this.school = school;
	}

	/** Method responsible for getting the IHouse object mascot
	 * 
	 * @return Returns the mascot property of the IHouse object 
	 */
	public String getMascot() {
		return mascot;
	}

	/** Method responsible for setting the IHouse object mascot
	 * 
	 * @param mascot
	 */
	public void setMascot(String mascot) {
		this.mascot = mascot;
	}

	/** Method responsible for getting the IHouse object houseGhost
	 * 
	 * @return Returns the houseGhost property of the IHouse object 
	 */
	public String getHouseGhost() {
		return houseGhost;
	}

	/** Method responsible for setting the IHouse object houseGhost
	 * 
	 * @param houseGhost
	 */
	public void setHouseGhost(String houseGhost) {
		this.houseGhost = houseGhost;
	}

	/** Method responsible for getting the IHouse object founder
	 * 
	 * @return Returns the founder property of the IHouse object 
	 */
	public String getFounder() {
		return founder;
	}

	/** Method responsible for setting the IHouse object founder
	 * 
	 * @param founder
	 */
	public void setFounder(String founder) {
		this.founder = founder;
	}
	
	

}
