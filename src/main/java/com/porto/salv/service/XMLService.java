package com.porto.salv.service;

import com.porto.salv.converter.XMLConverter;
import com.porto.salv.entity.XMLEntity;
import com.porto.salv.model.XMLType;
import com.porto.salv.model.exception.BadRequestException;
import com.porto.salv.model.exception.NotFoundException;
import com.porto.salv.model.response.ResponseType;
import com.porto.salv.repository.XMLRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class XMLService {

    @Autowired
    private XMLConverter converter;

    @Autowired
    private XMLRepository repository;

    @Transactional
    public ResponseType cadastrar(XMLType XMLType) {

        try {

            log.info("[RegiaoService.cadastrar] inicio ");

            XMLEntity XMLEntity = converter.toXMLEntity(XMLType, new XMLEntity());
            repository.save(XMLEntity);

            log.info("[RegiaoService.cadastrar] fim ");
            return new ResponseType(0, "Registro cadastrado com sucesso.", XMLEntity.getId());

        } catch (Exception e) {
            log.error("[RegiaoService.cadastrar] exception: {}", e.getMessage());
            throw e;
        }
    }

    @Transactional
    public ResponseType alterar(XMLType request) throws Exception {

        try {

            log.info("[RegiaoService.alterar] inicio ");

            if (request.getId() == null) throw new BadRequestException("id é obrigatório.");

            XMLEntity entity = repository.findById(request.getId()).orElseThrow(() -> new NotFoundException("Registro não encontrado."));
            entity = converter.toXMLEntity(request, entity);
            repository.save(entity);

            log.info("[RegiaoService.alterar] fim ");
            return new ResponseType(0, "Registro alterado com sucesso.", entity.getId());

        } catch (Exception e) {
            log.error("[RegiaoService.alterar] exception: {}", e.getMessage());
            throw e;
        }
    }

    public List<XMLType> consultar() {

        try {

            log.info("[RegiaoService.consultar] inicio ");

            List<XMLType> regioesResponse = new ArrayList<>();
            List<XMLEntity> regioesEntity = repository.findAll();

            regioesEntity.forEach(XMLEntity -> {
                XMLType XMLType = converter.toXMLType(XMLEntity);
                regioesResponse.add(XMLType);
            });

            log.info("[RegiaoService.consultar] fim ");
            return regioesResponse;

        } catch (Exception e) {
            log.error("[RegiaoService.consultar] exception: {}", e.getMessage());
            throw e;
        }
    }

    @Transactional
    public ResponseType deletar(Integer id) throws Exception {

        try {

            log.info("[RegiaoService.deletar] inicio ");

            XMLEntity entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Registro não encontrado."));
            repository.delete(entity);

            log.info("[RegiaoService.deletar] fim ");
            return new ResponseType(0, "Registro deletado com sucesso.", entity.getId());

        } catch (Exception e) {
            log.error("[RegiaoService.deletar] exception: {}", e.getMessage());
            throw e;
        }
    }
}
