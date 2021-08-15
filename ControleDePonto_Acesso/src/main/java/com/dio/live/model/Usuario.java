package com.dio.live.model;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Usuario {
    @Id
    private Long id;

    @ManyToOne//Muitos usuários para 1 categoria
    private CategoriaUsuario categoriaDeUsuario;

    private String nome;

    @ManyToOne//Muitas usuários para 1 empresa
    private Empresa empresa;

    @ManyToOne//Muitos usuários para 1 nivelAcesso
    private NivelAcesso nivelDeAcesso;

    @ManyToOne//Muitos usuários para 1 jornadaTrabalho
    private  JornadaTrabalho jornadaDeTrabalho;

    private BigDecimal tolerancia;

    private LocalDateTime inicioJornada;

    private LocalDateTime finalJornada;
}
