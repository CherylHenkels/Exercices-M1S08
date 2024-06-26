// Exercicio 3 -> criação da classe Curso
package br.com.fullstack.exerciciosM1S8.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Curso {

    private static Integer proximoId = 1;
    @Getter private static List<Curso> cursosCadastrados = new ArrayList<>();

    private Integer id;
    @Setter private String nome;
    @Setter private String descricao;
    @Setter private Integer cargaHoraria;
    @Setter private List<Aluno> alunosMatriculados = new ArrayList<>();


    private static Integer getProximoId() {
        return proximoId++;
    }
    public static Curso inserir(Curso curso){
        cursosCadastrados.add(curso);
        curso.id = proximoId++;
        return curso;
    }

    //Exercicio 8 - método para encontrar curso por ID
    public static Curso buscarPorId(Integer id) throws Exception {
        for (Curso curso : cursosCadastrados) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado");
    }

    public static void matricular(Curso curso, Aluno aluno){
        curso.getAlunosMatriculados().add(aluno);
    }

}
