package com.example.Tarefa.services;

import com.example.Tarefa.models.TarefaModel;
import com.example.Tarefa.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<TarefaModel> findAll(){
        return tarefaRepository.findAll();
    }

    public Optional<TarefaModel> findById(Long id){
        return tarefaRepository.findById(id);
    }

    public TarefaModel criarTarefa(TarefaModel tarefaModel){
        return tarefaRepository.save(tarefaModel);
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

}
