package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "disciplina")
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    /* @ManyToOne
    relacionamento muitos para um
    Many -> disciplinas One -> Professor
    um professor pode ensinar várias disciplinas
     @JoinColumn -> juntar colunas
     o atributo professor_id será a chave estrangeira da tabela disciplina
     e vai se conectar com a tabela professor pelo id (chave primária)
      o Spring identifica que a PK de professor está sendo chamada em disciplina
      */
}
