package com.porto.salv.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class CriticaType {
    @JsonProperty("campo")
    @Schema(example = "descricao", description = "Campo que apresenta erro")
    @Valid
    @Size(max = 40)
    String campo;

    @JsonProperty("critica")
    @Schema(example = "descricao nao pode ser null", description = "Crítica do erro")
    @Valid
    @Size(max = 180)
    private String critica;

    @JsonProperty("valor")
    @Schema(example = "null", description = "Valor do campo que apresenta erro")
    @Valid
    @Size(max = 180)
    private String valor;

    public CriticaType(String campo, String critica, String valor) {
        this.campo = campo;
        this.critica = critica;
        this.valor = valor;
    }

}
