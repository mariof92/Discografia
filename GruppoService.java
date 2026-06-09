package com.mario.Github.Discografia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GruppoService {

    @Autowired
    private GruppoRepository repository;

    public List<Gruppo> listaGruppi() {
        return repository.findAll();
    }

    public Gruppo aggiungi(Gruppo gruppo) {
        return repository.save(gruppo);
    }

    public ResponseEntity<String> modifica(Long id, Gruppo gruppo) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(404).body("Gruppo non trovato");
        }
        gruppo.setId(id);
        repository.save(gruppo);
        return ResponseEntity.ok("Lista gruppi modificata");
    }

    public ResponseEntity<String> cancella(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(404).body("Gruppo non trovato");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Gruppo eliminato");
    }
}
