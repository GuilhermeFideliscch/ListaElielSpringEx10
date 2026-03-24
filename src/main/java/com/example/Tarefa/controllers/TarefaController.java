package com.example.Tarefa.controllers;

import com.example.Tarefa.models.TarefaModel;
import com.example.Tarefa.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaServices;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> findAll(){
        List<TarefaModel> tarefaModelList = tarefaServices.findAll();

        return ResponseEntity.ok().body(tarefaModelList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TarefaModel>> findById(@PathVariable Long id){
        Optional<TarefaModel> tarefaModelOptional = tarefaServices.findById(id);

        return ResponseEntity.ok().body(tarefaModelOptional);
    }

    @PostMapping
    public ResponseEntity<TarefaModel> criarTarefa(@RequestBody TarefaModel tarefaModel){
        TarefaModel novaTarefa = tarefaServices.criarTarefa(tarefaModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaTarefa.getId()).toUri();

        return ResponseEntity.created(uri).body(novaTarefa);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id){
        tarefaServices.deletarTarefa(id);

        return ResponseEntity.noContent().build();
    }

}
