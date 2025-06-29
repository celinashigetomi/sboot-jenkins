package com.porto.salv.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

@Getter
@Validated
public class InternalErrorType {
    @JsonProperty("codigo")
    @Schema(example = "500", description = "Código de retorno")
    @Min(0)
    @Max(999)
    private Integer codigo;

    @JsonProperty("mensagem")
    @Schema(example = "Ocorreu uma instabilidade ao efetuar operação.", description = "Mensagem de retorno")
    @Valid
    @Size(max = 180)
    private String mensagem;

    public InternalErrorType(Integer codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }
}