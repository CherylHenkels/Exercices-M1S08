// Exercicio 2 -> criação da classe AlunoAluno
package br.com.fullstack.exerciciosM1S8.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Aluno {

    private static Integer proximoId = 1;
    @Getter private static List<Aluno> alunosCadastrados = new ArrayList<>();

    private int id;
    @Setter private String nome;
    @Setter private LocalDate dataNascimento;

    private static Integer getProximoId() {
        return proximoId++;
    }

    public static Aluno inserir(Aluno aluno) {
        alunosCadastrados.add(aluno);
        aluno.id = getProximoId();
        return aluno;
    }


}
