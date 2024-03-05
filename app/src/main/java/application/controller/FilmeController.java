package application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.model.Filme;
import application.repository.FilmeRepository;

@RestController
public class FilmeController {
    
    @Autowired
    private FilmeRepository filmeRepo;


    @GetMapping("/filmes")
    public List<Filme> getFilmes() {
        return (List<Filme>) filmeRepo.findAll();
    }

    @PostMapping("/filmes")
    public Filme postFilme(@RequestBody Filme filme) {
        return filmeRepo.save(filme);
    }

    @GetMapping("/filmes/{id}")
    public Filme getFilmeById(@PathVariable Long id) {
        return filmeRepo.findById(id).get();
    }

    @PutMapping("/filmes/{id}")
    public Filme updateFilme(@PathVariable Long id, @RequestBody Filme filme) {
        Filme resposta = filmeRepo.findById(id).get();

        resposta.setTitulo(filme.getTitulo());
        resposta.setSinopse(filme.getSinopse());

        return filmeRepo.save(resposta);
    }

    @DeleteMapping("/filmes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFilmes(@PathVariable Long id) {
        filmeRepo.deleteById(id);
    }
}
