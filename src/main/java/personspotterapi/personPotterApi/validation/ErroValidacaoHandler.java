package personspotterapi.personPotterApi.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import personspotterapi.personPotterApi.dto.ErroFormDTO;

/** Class responsible for intercepting and handling all validation errors of the character object creation and update route
 * @author Guilherme de Oliveira
 * @version 1.0
 * @since 1.0
*/

@RestControllerAdvice
public class ErroValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;

	/** Method responsible for receiving exception data
	 * 
	 * @param exception
	 * @return Returns an ErrorFormDTO object list
	 */
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormDTO> handle(MethodArgumentNotValidException exception) {
		List<ErroFormDTO> erroFormDTOs = new ArrayList<>();
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
		
		fieldErros.forEach(e->{
			String mensagem = "Campo '"+ e.getField() +"' "+ messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroFormDTO erroFormDTO = new ErroFormDTO(HttpStatus.BAD_REQUEST.value(), mensagem);
			erroFormDTOs.add(erroFormDTO);
		});
		return erroFormDTOs;
		
	}
}
