package com.porto.salv.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@NoArgsConstructor
@Validated
public class XMLType {

    @Schema(example = "2246", description = "Id do registro")
    @Min(0)
    @Max(1000000000)
    private Integer id = null;

    @Schema(example = "/webapp/XMLHomologacao/01_PortoSeguroAutomovel/02_CartaVerde", description = "Path do xml")
    @Size(min = 200, max = 200)
    @NotNull
    @NotEmpty
    @Valid
    private String path = null;

    @Schema(example = "02_Calculo.xml", description = "Nome do arquivo xml")
    @Size(max = 100)
    @NotNull
    @NotEmpty
    @Valid
    private String arquivo = null;

    @Schema(example = "/webapp/XMLHomologacao/01_PortoSeguroAutomovel/02_CartaVerde_01012025000000", description = "Versão do xml")
    @Size(max = 200)
    @NotNull
    @NotEmpty
    @Valid
    private String versao = null;

    @Schema(example = "<response><codigo>200</codigo><descricao>OK</descricao></response>", description = "Conteúdo do xml")
    @Size(max = 200)
    @NotNull
    @NotEmpty
    @Valid
    private String conteudo = null;

    @Schema(example = "27/04/2023 10:00:00", description = "Data de publicação")
    private String dataPublicacao;

    @Schema(example = "27/04/2023 10:00:00", description = "Data de cadastro")
    private String dataCadastro;

    @Schema(example = "F4303085", description = "Usuário que fez cadastro")
    private String usuarioCadastro;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Schema(example = "27/04/2023 10:00:00", description = "Data última atualização")
    private String dataUltimaAtualizacao;

    @Schema(example = "F4303085", description = "Usuário que fez última atualização")
    private String usuarioUltimaAtualizacao;

}
