package com.porto.salv.configs;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.porto.salv.model.exception.BadRequestException;
import com.porto.salv.model.exception.NotFoundException;
import com.porto.salv.model.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<InternalErrorType> handleException(Throwable ex) {
        return new ResponseEntity<>(new InternalErrorType(500, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BadRequestType> handleException(InvalidFormatException ex) {
        List<CriticaType> criticas = new ArrayList<>();
        for (JsonMappingException.Reference campo : ex.getPath()) {
            String valor = ex.getValue().toString();
            String mensagem = MensagemEnum.MSG_ERRO_ENTRADA_INVALIDA.getDescription();
            criticas.add(new CriticaType(campo.getFieldName(), valor, mensagem));
        }
        BadRequestType erro400 = new BadRequestType(400, MensagemEnum.MSG_VALIDACAO_CAMPOS.getDescription(), criticas);
        return new ResponseEntity<>(erro400, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<BadRequestType> handleException(HttpMediaTypeNotSupportedException ex) {
        BadRequestType erro400 = new BadRequestType(406, "Content-type não suportado: " + ex.getContentType().getType() + "/" + ex.getContentType().getSubtype());
        return new ResponseEntity<>(erro400, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<BadRequestType> handleException(HttpRequestMethodNotSupportedException ex) {
        BadRequestType erro400 = new BadRequestType(405, "Metodo não suportado: " + ex.getMethod());
        return new ResponseEntity<>(erro400, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleException(MethodArgumentTypeMismatchException ex) {

        String campo = ex.getName();
        String valor = ex.getValue().toString();
        String mensagem = ex.getName() + " é inválido.";

        List<CriticaType> criticas = new ArrayList<>();
        criticas.add(new CriticaType(campo, valor, mensagem));

        BadRequestType erro400 = new BadRequestType(400, MensagemEnum.MSG_VALIDACAO_CAMPOS.getDescription(), criticas);
        return new ResponseEntity<>(erro400, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<BadRequestType> handleException(MissingServletRequestParameterException ex) {
        BadRequestType erro400 = new BadRequestType(400, "Parametro " + ex.getParameterName() + " é obrigatório.");
        return new ResponseEntity<>(erro400, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestType> handleException(BadRequestException ex) {
        return new ResponseEntity<>(new BadRequestType(400, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundType> handleException(NotFoundException ex) {
        return new ResponseEntity<>(new NotFoundType(404, ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<BadRequestType> handleException(NumberFormatException ex) {
        return new ResponseEntity<>(new BadRequestType(400, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(produces = "application/json")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalErrorType> handleException(Exception ex) {
        return new ResponseEntity<>(new InternalErrorType(500, MensagemEnum.MSG_ERRO_GENERICO.getDescription()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}