package com.porto.salv.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "xml")
public class XMLEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 200)
    @Column(name = "path", length = 200)
    private String path;

    @Size(max = 100)
    @Column(name = "arquivo", length = 100)
    private String arquivo;

    @Size(max = 200)
    @NotNull
    @Column(name = "versao", nullable = false, length = 200)
    private String versao;

    @Size(max = 5000)
    @NotNull
    @Column(name = "conteudo", nullable = false, length = 5000)
    private String conteudo;

    @Column(name = "dataPublicacao", nullable = false)
    private Timestamp dataPublicacao;

    @CreationTimestamp
    @Column(name = "dataCadastro", nullable = false)
    private Timestamp dataCadastro;

    @Size(max = 20)
    @Column(name = "usuarioCadastro", nullable = false, length = 20)
    private String usuarioCadastro;

    @UpdateTimestamp
    @Column(name = "dataUltimaAtualizacao", nullable = false)
    private Timestamp dataUltimaAtualizacao;

    @Size(max = 20)
    @Column(name = "usuarioUltimaAtualizacao", nullable = false, length = 20)
    private String usuarioUltimaAtualizacao;

}