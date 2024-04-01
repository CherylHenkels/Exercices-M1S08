// Exercício 4 - Service curso
package br.com.fullstack.exerciciosM1S8.service;

import br.com.fullstack.exerciciosM1S8.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    public Curso cadastrar(Curso curso) throws Exception {
        if (validar(curso)){
            return Curso.inserir(curso);
        }
        return null;
    }

    private boolean validar(Curso curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()){
            throw new Exception("Nome é obrigatório");
        }
        if (curso.getCargaHoraria() == null){
            throw new Exception("Carga horaria é obrigatória");
        }
        return true;
    }

    public List<Curso> consultarTodos() {
        return Curso.getCursosCadastrados();
    }


}
