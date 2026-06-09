package com.mario.Github.Discografia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gruppo")
public class GruppoController {

    @Autowired
    private GruppoService service;

    @GetMapping
    public List<Gruppo> getGruppi() {
        return service.listaGruppi();
    }

    @PostMapping
    public Gruppo aggiungi(@RequestBody Gruppo gruppo) {
        return service.aggiungi(gruppo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifica(@PathVariable Long id, @RequestBody Gruppo gruppo) {
        return service.modifica(id, gruppo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancella(@PathVariable Long id) {
        return service.cancella(id);
    }
}
