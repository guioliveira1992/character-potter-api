package personspotterapi.personPotterApi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import personspotterapi.personPotterApi.dto.CharacterDTO;
import personspotterapi.personPotterApi.dto.ErroFormDTO;
import personspotterapi.personPotterApi.entity.Characters;
import personspotterapi.personPotterApi.modelRequest.IHouse;
import personspotterapi.personPotterApi.repository.CharacterRepository;
import personspotterapi.personPotterApi.service.HouseService;

/** Class controller characteres, route /api/v1/characters
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/

@RestController
@RequestMapping("/api/v1/characters")
public class CharacterController {

	
	@Autowired
	private HouseService houseService;

	@Autowired
	private CharacterRepository characterRepository;
	
	private static final String messageError = "Id house invalid";

	/** Route responsible for reading all characters registered in the database
	 *
	 * @return Returns an array of objects on success with HttpStatus 200 on success. On error will return HttpStatus 204.
	 */
	@GetMapping
	public ResponseEntity<?> read() {
		List<Characters> characters = characterRepository.findAll();
		if (characters != null && !characters.isEmpty()) {
			return ResponseEntity.ok(CharacterDTO.converter(characters));
		}
		return ResponseEntity.noContent().build();
	}

	/** Route responsible for creating a new character
	 * 
	 * @param character
	 * @param uri
	 * @return Returns the object registered with its id with the HttpStatus 201 on success. If the value of the house attribute is invalid, it will return the HttpStatus 400.
	 */
	@PostMapping
	@Transactional
	public ResponseEntity<?> created(@RequestBody @Valid Characters character, UriComponentsBuilder uri) {
		List<IHouse> houses = houseService.getPersonsPotter();
		boolean isHouseValid = false;
		for (IHouse iHoouse : houses) {
			if (iHoouse.getId().equals(character.getHouse())) {
				isHouseValid = true;
				break;
			}
		}
		if (isHouseValid) {
			characterRepository.save(character);
			URI uriPath = uri.path("/charactes/{id}").buildAndExpand(character.getId()).toUri();
			return ResponseEntity.created(uriPath).body(new CharacterDTO(character));
		}
		return new ResponseEntity<>(new ErroFormDTO(HttpStatus.BAD_REQUEST.value(), messageError),HttpStatus.BAD_REQUEST);
	}

	/** Route responsible for reading a character by its id
	 * 
	 * @param id
	 * @return Returns the character object and the HtppStatus 200 on success. If it is an invalid id it will return HtppStatus 404.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<CharacterDTO> readById(@PathVariable Long id) {
		Optional<Characters> character = characterRepository.findById(id);
		if (character.isPresent()) {
			return ResponseEntity.ok(new CharacterDTO(character.get()));
		}
		return ResponseEntity.notFound().build();
	}

	/** Route responsible for deleting a character by id
	 * 
	 * @param id
	 * @return Returns HtppStatus 200 on success. If it is an invalid id it will return HtppStatus 404.
	 */
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<CharacterDTO> delete(@PathVariable Long id) {
		Optional<Characters> character = characterRepository.findById(id);
		if (character.isPresent()) {
			characterRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	/** Route responsible for updating a character by id
	 * 
	 * @param id
	 * @param character
	 * @return Returns the HtppStatus 200 and character object on success. If the value of the house property is invalid it will return HttpStatus 400. If it is an invalid id it will return HtppStatus 404.
	 */
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> updated(@PathVariable Long id, @RequestBody @Valid Characters character) {
		Optional<Characters> characterOptional = characterRepository.findById(id);
		if (characterOptional.isPresent()) {
			List<IHouse> houses = houseService.getPersonsPotter();
			boolean isHouseValid = false;
			for (IHouse iHoouse : houses) {
				if (iHoouse.getId().equals(character.getHouse())) {
					isHouseValid = true;
					break;
				}
			}
			if (isHouseValid) {
				characterOptional.get().setHouse(character.getHouse());
				characterOptional.get().setName(character.getName());
				characterOptional.get().setPatronus(character.getPatronus());
				characterOptional.get().setRole(character.getRole());
				characterOptional.get().setSchool(character.getSchool());
				characterRepository.save(characterOptional.get());
				return ResponseEntity.ok(new CharacterDTO(characterOptional.get()));
			}else {
				return new ResponseEntity<>(new ErroFormDTO(HttpStatus.BAD_REQUEST.value(), messageError),HttpStatus.BAD_REQUEST);
			}
		}
		return ResponseEntity.notFound().build();
	}

	/** Route responsible for finding a character by the value of the house property
	 * 
	 * @param id
	 * @return Returns the HtppStatus 200 and the character object array on success. If the parameter value is invalid it will return HtppStatus 404.
	 */
	@GetMapping("/house")
	public ResponseEntity<?> filter(String id) {
		List<Characters> characters = characterRepository.findByCriteriaHouse(id);
		if (characters != null && !characters.isEmpty()) {
			return ResponseEntity.ok(CharacterDTO.converter(characters));
		}
		return ResponseEntity.noContent().build();
	}

}
