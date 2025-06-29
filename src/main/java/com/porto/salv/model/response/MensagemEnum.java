package com.porto.salv.model.response;

import lombok.Getter;

@Getter
public enum MensagemEnum {

    MSG_SISTEMA_INDISPONIVEL(1, "Sistema Indisponivel."),
    MSG_ERRO_INTEGRACAO(2, "Erro na integração."),
    MSG_VALIDACAO_CAMPOS(3, "Erro na validação de campos."),
    MSG_ERRO_ENTRADA_INVALIDA(4, "Valor informado é inválido."),
    MSG_REGISTRO_NAO_ENCONTRADO(5, "Registro não encontrado."),
    MSG_ERRO_GENERICO(6, "Não foi possível seguir com a operação.");

    private final int id;
    private final String description;

    MensagemEnum(final int id, final String description) {
        this.id = id;
        this.description = description;
    }

}
