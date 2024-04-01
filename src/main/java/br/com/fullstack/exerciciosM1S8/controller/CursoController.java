//Exercicio 7 - Controller Curso
package br.com.fullstack.exerciciosM1S8.controller;

import br.com.fullstack.exerciciosM1S8.model.Aluno;
import br.com.fullstack.exerciciosM1S8.model.Curso;
import br.com.fullstack.exerciciosM1S8.service.CursoService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<Curso> get(){
        return cursoService.consultarTodos();
    }

    @PostMapping
    public Curso post(@RequestBody Curso curso) throws Exception {
        return cursoService.cadastrar(curso);
    }

    @PostMapping("{id}/add-aluno")
    public Curso post(@PathVariable Integer id, @RequestBody Aluno aluno) throws Exception {
        return cursoService.matricular(id, aluno.getId());
    }

}
