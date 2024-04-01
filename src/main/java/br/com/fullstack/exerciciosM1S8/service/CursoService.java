// Exercício 4 - Service curso
package br.com.fullstack.exerciciosM1S8.service;

import br.com.fullstack.exerciciosM1S8.model.Aluno;
import br.com.fullstack.exerciciosM1S8.model.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

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

    //Exercicio 8 - método para encontrar curso por ID
    public Curso buscarPorId(Integer id) throws Exception {
        return Curso.buscarPorId(id);
    }

    // método para matricular aluno
    public Curso matricular(Integer id, Integer alunoId) throws Exception {
        Curso curso = buscarPorId(id);
        Aluno aluno = alunoService.buscarPorId(alunoId);
        Curso.matricular(curso, aluno);
        return curso;
    }

}
