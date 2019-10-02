package fr.move.in.med.exceptions;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.validation.UnexpectedTypeException;

import org.dozer.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.JsonMappingException;

import fr.move.in.med.constants.Message;
import fr.move.in.med.status.RestApiStatus;

/**
 * Classe permettant de capturer les différentes exceptions et de retourner un
 * statut et un message associé
 * 
 * @author sebastienternisien
 *
 */
@ControllerAdvice
public class HandlerException {

	@ExceptionHandler({ PersistenceException.class })
	public final ResponseEntity<RestApiStatus> handleHibernateException(Exception ex, WebRequest request) {
		return new ResponseEntity<RestApiStatus>(
				new RestApiStatus(HttpStatus.INTERNAL_SERVER_ERROR.name(), Message.HIBERNATE_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ MappingException.class })
	public final ResponseEntity<RestApiStatus> handleDozerMapperException(Exception ex, WebRequest request) {
		return new ResponseEntity<RestApiStatus>(
				new RestApiStatus(HttpStatus.INTERNAL_SERVER_ERROR.name(), Message.MAPPING_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ IllegalStateException.class, IntrospectionException.class, IllegalArgumentException.class, InvocationTargetException.class})
	public final ResponseEntity<RestApiStatus> handleIllegalException(Exception ex, WebRequest request) {
		return new ResponseEntity<RestApiStatus>(
				new RestApiStatus(HttpStatus.INTERNAL_SERVER_ERROR.name(), Message.JAVA_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({ MethodArgumentNotValidException.class, UnexpectedTypeException.class, JsonMappingException.class})
	public final ResponseEntity<RestApiStatus> handleValidationException(Exception ex,
			WebRequest request) {
		
		return new ResponseEntity<RestApiStatus>(new RestApiStatus(HttpStatus.BAD_REQUEST.name(), ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ NoResultException.class })
	public final ResponseEntity<RestApiStatus> handleIllegalException(NoResultException ex, WebRequest request) {
		return new ResponseEntity<RestApiStatus>(
				new RestApiStatus(HttpStatus.NOT_FOUND.name(), "Patient ou professionnel cherché inexistant"),
				HttpStatus.NOT_FOUND);
	}
}
