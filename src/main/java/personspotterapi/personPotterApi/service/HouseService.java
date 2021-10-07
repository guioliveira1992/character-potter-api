package personspotterapi.personPotterApi.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import personspotterapi.personPotterApi.modelRequest.HouseResponse;
import personspotterapi.personPotterApi.modelRequest.IHouse;
import reactor.core.publisher.Mono;

/** Class responsible for implementing the integration service with potterapi
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/
@Service
public class HouseService {
	
	@Autowired
	private WebClientSwapiConfig webClientSwapiConfig;
	
	/** method responsible for making the request to potterapi and receiving the response data
	 * 
	 * @return Return IHouse object list
	 */
	public List<IHouse> getPersonsPotter() {
		Mono<HouseResponse> houseMono = webClientSwapiConfig.getWebClient().method(HttpMethod.GET)
				.retrieve().bodyToMono(HouseResponse.class);
		HouseResponse houseResponse = houseMono.block();
		return houseResponse.getHouses();
	}
	
}
