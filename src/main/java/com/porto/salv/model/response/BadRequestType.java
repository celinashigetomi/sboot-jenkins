package com.porto.salv.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Getter
@Validated
public class BadRequestType {
    @JsonProperty("codigo")
    @Schema(example = "400", description = "Código de retorno")
    @Min(0)
    @Max(999)
    private Integer codigo;

    @JsonProperty("mensagem")
    @Schema(example = "Ocorreu um erro na validação de campos.", description = "Mensagem de retorno")
    @Valid
    @Size(max = 180)
    private String mensagem;

    @JsonProperty("criticas")
    @Schema(description = "Lista de críticas")
    @Valid
    @Size(max = 99)
    private List<CriticaType> criticas = null;

    public BadRequestType(Integer codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public BadRequestType(Integer codigo, String mensagem, List<CriticaType> criticas) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.criticas = criticas;
    }
}
