package com.dio.live.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

        @AllArgsConstructor
        @NoArgsConstructor
        @EqualsAndHashCode
        @Embeddable//Usando relacionamento com chave composta com o Embeddable e Serialiando os objetos
        public  class  MovimentacaoId implements Serializable{
            private long idMovimento;
            private long idUsuario;
        }

        @Id
        @EmbeddedId//Referencia o id composto da classe MovimentacaoId
        private MovimentacaoId movimentacaoId;

        private LocalDateTime dataEntrada;

        private LocalDateTime dataSaida;

        private BigDecimal periodo;

        @ManyToOne
        private Ocorrencia ocorrencia;
        @ManyToOne
        private Calendario calendario;
}
