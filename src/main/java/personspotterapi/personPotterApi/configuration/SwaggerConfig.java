package personspotterapi.personPotterApi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/** Class responsible for implementing the creation of the api documentation
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/** Method responsible for creating the api documentation
	 * 
	 * @return Returns Docker object
	 */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build();
    }
}

