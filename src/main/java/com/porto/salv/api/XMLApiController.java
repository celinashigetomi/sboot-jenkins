package com.porto.salv.api;

import com.porto.salv.model.XMLType;
import com.porto.salv.model.response.ResponseType;
import com.porto.salv.service.XMLService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@Tag(name = "XML", description = "Recurso referente a xml")
public class XMLApiController implements XMLApi {

    @Autowired
    private XMLService service;

    public ResponseEntity<ResponseType> cadastrarXML(@Parameter(in = ParameterIn.DEFAULT, required = true, schema = @Schema()) @Valid @RequestBody XMLType body) {
        log.info("[XMLApiController.cadastrarXML] request: {}", body);
        return new ResponseEntity<>(service.cadastrar(body), HttpStatus.OK);
    }

    public ResponseEntity<ResponseType> alterarXML(@Parameter(in = ParameterIn.DEFAULT, required = true, schema = @Schema()) @Valid @RequestBody XMLType body) throws Exception {
        log.info("[XMLApiController.alterarXML] request: {}", body);
        return new ResponseEntity<>(service.alterar(body), HttpStatus.OK);
    }

    public ResponseEntity<List<XMLType>> consultarXML() {
        log.info("[XMLApiController.consultarXML]");
        return new ResponseEntity<>(service.consultar(), HttpStatus.OK);
    }

    public ResponseEntity<ResponseType> deletarXML(@Parameter(in = ParameterIn.PATH, required = true) @PathVariable("id") Integer id) throws Exception {
        log.info("[XMLApiController.deletarXML] request: {}", id);
        return new ResponseEntity<>(service.deletar(id), HttpStatus.OK);
    }

}
