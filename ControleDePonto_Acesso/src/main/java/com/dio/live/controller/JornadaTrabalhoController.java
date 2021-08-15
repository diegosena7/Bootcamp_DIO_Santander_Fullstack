package com.dio.live.controller;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import com.dio.live.service.JornadaService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @Autowired
    JornadaRepository jornadaRepository;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping
    public ResponseEntity<Page<JornadaTrabalho>> getJornadaList(Pageable pageable){
        Page<JornadaTrabalho> jornTrabalho = jornadaRepository.findAll(pageable);
        return ResponseEntity.ok().body(jornTrabalho);
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return  ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));
    }

    @PutMapping("/{idJornada}")
    public ResponseEntity updateJornada(@PathVariable("idJornada") Long idJornada, @RequestBody @Valid JornadaTrabalho jornada){
        return jornadaRepository.findById(idJornada).map(dados -> {
            dados.setDescricao(jornada.getDescricao());
            JornadaTrabalho jornadaTrabalho = jornadaRepository.save(dados);
            return ResponseEntity.ok().body(jornadaTrabalho);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
       try {
           jornadaService.deleteJornada(idJornada);
       }catch (Exception e){
           System.out.println(e.getMessage());
       }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}
