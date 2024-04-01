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
    private static List<Curso> cursosCadastrados = new ArrayList<>();

    private int id;
    @Setter private String nome;
    @Setter private String descricao;
    @Setter private Integer cargaHoraria;

    private static Integer getProximoId() {
        return proximoId++;
    }
    public static Curso controleID(Curso curso){
        cursosCadastrados.add(curso);
        curso.id = proximoId++;
        return curso;
    }



}
