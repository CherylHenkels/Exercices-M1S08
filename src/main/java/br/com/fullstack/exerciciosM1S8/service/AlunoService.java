// Exercício 4 - Service aluno
package br.com.fullstack.exerciciosM1S8.service;

import br.com.fullstack.exerciciosM1S8.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    public Aluno cadastrar(Aluno aluno) throws Exception {
        if (validar(aluno)){
            return Aluno.inserir(aluno);
        }
        return null;
    }

    private boolean validar(Aluno aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()){
            throw new Exception("Nome é obrigatório");
        }
        if (aluno.getDataNascimento() == null){
            throw new Exception("Data de nascimento é obrigatória");
        }
        return true;
    }

    public List<Aluno> consultarTodos() {
        return Aluno.getAlunosCadastrados();
    }


}
