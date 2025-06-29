package com.porto.salv.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Getter
@NoArgsConstructor
@Validated
public class ResponseType {
    @JsonProperty("codigo")
    @Schema(example = "200", description = "Código de retorno")
    @Min(0)
    @Max(999)
    private Integer codigo = null;

    @JsonProperty("mensagem")
    @Schema(example = "Operação realizada com sucesso.", description = "Mensagem de retorno")
    @Valid
    @Size(max = 180)
    private String mensagem = null;

    @JsonProperty("id")
    @Schema(example = "140", description = "Id registro")
    @Min(0)
    @Max(1000000000)
    private Integer id = null;

    public ResponseType(Integer codigo, String mensagem, Integer id) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.id = id;
    }
}
