package com.farsousa.desafiolocadoraveiculoapi.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.farsousa.desafiolocadoraveiculoapi.dto.ResponseModel;
import com.farsousa.desafiolocadoraveiculoapi.exceptions.NaoEncontradoException;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ResponseModel<?>> handleException(Exception ex) {
    	ResponseModel<?> resposta = new ResponseModel<>();
    	resposta.setMensagem(ex.getMessage());
        return ResponseEntity.badRequest().body(resposta);
    }
}