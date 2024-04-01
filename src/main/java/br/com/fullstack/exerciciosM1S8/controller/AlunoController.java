//Exercicio 6 - Controller Aluno
package br.com.fullstack.exerciciosM1S8.controller;

import br.com.fullstack.exerciciosM1S8.model.Aluno;
import br.com.fullstack.exerciciosM1S8.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> get(){
        return alunoService.consultarTodos();
    }

    @PostMapping
    public Aluno post(@RequestBody Aluno aluno) throws Exception {
        return alunoService.cadastrar(aluno);
    }

}
