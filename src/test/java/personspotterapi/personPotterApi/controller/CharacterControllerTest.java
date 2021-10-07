package personspotterapi.personPotterApi.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import personspotterapi.personPotterApi.entity.Characters;
import personspotterapi.personPotterApi.repository.CharacterRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CharacterControllerTest {

	@Autowired
	private MockMvc mocMvc;
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@Test
	void testarCadastroCharacterComSucesso() throws Exception {
		URI uri = new URI("/api/v1/characters");
		String json = "{\"name\": \"Harry Potter\",\"role\": \"student\",\"school\": \"Hogwarts School of Witchcraft and Wizardry\",\"house\": \"1760529f-6d51-4cb1-bcb1-25087fce5bde\",\"patronus\": \"stag\"}";
		 mocMvc.perform(MockMvcRequestBuilders
				.post(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(201));	
	}
	
	@Test
	void testarCadastroCharacterComHouseInvalida() throws Exception {
		URI uri = new URI("/api/v1/characters");
		String json = "{\"name\": \"Harry Potter\",\"role\": \"student\",\"school\": \"Hogwarts School of Witchcraft and Wizardry\",\"house\": \"1760529f-6d51-4cb1-bcb1-25087fce5bdf\",\"patronus\": \"stag\"}";
		 mocMvc.perform(MockMvcRequestBuilders
				.post(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));	
	}
	
	@Test
	void atualizarCharacterComSucesso() throws Exception {
		testarCadastroCharacterComSucesso();
		List<Characters> characters = characterRepository.findAll();
		assertTrue(characters.size() > 0);
		URI uri = new URI("/api/v1/characters/"+characters.get(0).getId());
		String json = "{\"name\": \"Ermione\",\"role\": \"student\",\"school\": \"Hogwarts School of Witchcraft and Wizardry\",\"house\": \"1760529f-6d51-4cb1-bcb1-25087fce5bde\",\"patronus\": \"stag\"}";
		mocMvc.perform(MockMvcRequestBuilders
				.put(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void atualizarCharacterComHouseInvalida() throws Exception {
		testarCadastroCharacterComSucesso();
		List<Characters> characters = characterRepository.findAll();
		assertTrue(characters.size() > 0);
		URI uri = new URI("/api/v1/characters/"+characters.get(0).getId());
		String json = "{\"name\": \"Ermione\",\"role\": \"student\",\"school\": \"Hogwarts School of Witchcraft and Wizardry\",\"house\": \"1760529f-6d51-4cb1-bcb1-25087fce5bdf\",\"patronus\": \"stag\"}";
		mocMvc.perform(MockMvcRequestBuilders
				.put(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(400));
	}
	
	@Test
	void consultarCharacterPorIdComSucesso() throws Exception {
		List<Characters> characters = characterRepository.findAll();
		assertTrue(characters.size() > 0);
		URI uri = new URI("/api/v1/characters/"+characters.get(0).getId());
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void consultarCharacterPorIdComIdInvalido() throws Exception {
		URI uri = new URI("/api/v1/characters/0");
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	void consultarTodosCharacter() throws Exception {
		URI uri = new URI("/api/v1/characters/");
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.get(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	@Test
	void deletarCharacter() throws Exception {
		List<Characters> characters = characterRepository.findAll();
		assertTrue(characters.size() > 0);
		URI uri = new URI("/api/v1/characters/"+characters.get(0).getId());
		String json = "{}";
		mocMvc.perform(MockMvcRequestBuilders
				.delete(uri).content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is(200));
	}
	
	
}
