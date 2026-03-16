package br.com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // construtor com nenhum argumento
@AllArgsConstructor // construtor com todos os argumentos
@Data // @Data substitui os getters e setters
@Table(name = "aluno")
@Entity
public class Aluno {

    // tem que ser o Id do jakarta
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;

}
