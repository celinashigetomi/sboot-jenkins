package com.porto.salv.converter;

import com.porto.salv.constants.XMLConstants;
import com.porto.salv.entity.XMLEntity;
import com.porto.salv.model.XMLType;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class XMLConverter {

    public XMLEntity toXMLEntity(XMLType type, XMLEntity entity) {
        entity.setId(type.getId());
        entity.setPath(type.getPath());
        entity.setArquivo(type.getArquivo());
        entity.setVersao(type.getVersao());
        entity.setConteudo(type.getConteudo());
        entity.setDataPublicacao(new Timestamp(System.currentTimeMillis()));
        entity.setUsuarioCadastro("user");
        entity.setUsuarioUltimaAtualizacao("user");
        return entity;
    }

    public XMLType toXMLType(XMLEntity entity) {
        String dataPublicacao = XMLConstants.LOCALDATE_DD_MM_YYYY_HH_MM_SS.format(entity.getDataPublicacao().toLocalDateTime());
        String dataCadastro = XMLConstants.LOCALDATE_DD_MM_YYYY_HH_MM_SS.format(entity.getDataCadastro().toLocalDateTime());
        String dataAtualizacao = XMLConstants.LOCALDATE_DD_MM_YYYY_HH_MM_SS.format(entity.getDataUltimaAtualizacao().toLocalDateTime());

        XMLType type = new XMLType();
        type.setId(entity.getId());
        type.setPath(entity.getPath());
        type.setArquivo(entity.getArquivo());
        type.setVersao(entity.getVersao());
        type.setConteudo(entity.getConteudo());
        type.setDataPublicacao(dataPublicacao);
        type.setDataCadastro(dataCadastro);
        type.setUsuarioCadastro(entity.getUsuarioCadastro());
        type.setDataUltimaAtualizacao(dataAtualizacao);
        type.setUsuarioUltimaAtualizacao(entity.getUsuarioUltimaAtualizacao());
        return type;
    }
}
