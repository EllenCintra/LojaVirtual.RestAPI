package config.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationError {
	
	private MessageSource messageSource;//Para pegar a mensagem de erro (vem em diferentes idiomas)
	
	public ValidationError(MessageSource ms) {
		this.messageSource = ms;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormDtoError> handle(MethodArgumentNotValidException exception) {
		List<FormDtoError> dto = new ArrayList<>();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

		fieldErrors.forEach(error -> {
			String menssage = this.messageSource.getMessage(error, LocaleContextHolder.getLocale());//pega mensagem de erro no idioma configurado pelo cliente
			FormDtoError errorDto = new FormDtoError (error.getField(), menssage);
			dto.add(errorDto);
		});

		return dto;
	}
}
