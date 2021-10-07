package personspotterapi.personPotterApi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

/** Class responsible for implementing a client web service
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/
@Service
public class WebClientSwapiConfig {
	
	@Value("${endpoint.potterapi}")
	private String endpointPotterApi;
	
	@Value("${api.key}")
	private String apiKey;
	
	/** Method responsible for creating a web client
	 * 
	 * @return Returns a WebClient object
	 */
	public WebClient getWebClient(){
		return WebClient.builder()
				  .baseUrl(endpointPotterApi)
				  .defaultHeader("apikey", apiKey)
				  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				  .build();
	}

	
}
