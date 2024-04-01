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

    private Integer id;
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

    //Exercicio 8 - método para encontrar aluno por ID
    public static Aluno buscarPorId(Integer id) throws Exception {
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado");
    }


}
