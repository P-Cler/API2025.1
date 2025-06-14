package org.serratec.backend.exception; 

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // Handler para a sua exceção customizada de 'Não Encontrado'
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        
        ErroResposta erroResposta = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                LocalDateTime.now(),
                Collections.singletonList(ex.getMessage()) // Cria uma lista com um único erro
        );

        return new ResponseEntity<>(erroResposta, HttpStatus.NOT_FOUND);
    }

    // Handler para os erros de validação do @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<String> erros = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErroResposta erroResposta = new ErroResposta(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de Validação",
                LocalDateTime.now(),
                erros
        );

        return new ResponseEntity<>(erroResposta, HttpStatus.BAD_REQUEST);
    }
}