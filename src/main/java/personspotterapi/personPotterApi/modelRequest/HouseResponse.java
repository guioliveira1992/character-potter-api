package personspotterapi.personPotterApi.modelRequest;

import java.util.List;

/** Class responsible for defining the array of objects returned from the integration with potterapi
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/
public class HouseResponse {
	
	private List<IHouse> houses;

	/** Method responsible for getting an IHouse object list
	 * 
	 * @return Return IHouse object list
	 */
	public List<IHouse> getHouses() {
		return houses;
	}

	/** Method responsible for setting an IHouse object list
	 * 
	 * @param houses
	 */
	public void setHouses(List<IHouse> houses) {
		this.houses = houses;
	}
	
	

}
