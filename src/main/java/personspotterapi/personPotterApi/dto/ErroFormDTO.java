package personspotterapi.personPotterApi.dto;

/** Class responsible for defining a pattern of application error messages
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/
public class ErroFormDTO {

	private int status_code;
	private String mesage;
	
	/** Constructor of the class with its attributes 
	 * 
	 * @param status_code
	 * @param mesage
	 */
	public ErroFormDTO(int status_code, String mesage) {
		this.status_code = status_code;
		this.mesage = mesage;
	}

	/** Method responsible for getting the ErroFormDTO object status_code
	 * 
	 * @return Returns the status_code property of the character object 
	 */
	public int getStatus_code() {
		return status_code;
	}

	/** Method responsible for getting the ErroFormDTO object mesage
	 * 
	 * @return Returns the message property of the character object 
	 */
	public String getMesage() {
		return mesage;
	}

	
	
}
