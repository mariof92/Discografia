package com.mario.Github.Discografia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    public List<Album> listaAlbum() {
        return repository.findAll();
    }

    public Album aggiungi(Album album) {
        return repository.save(album);
    }

    public ResponseEntity<String> modifica(Long id, Album album) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(404).body("Album non trovato");
        }
        album.setId(id);
        repository.save(album);
        return ResponseEntity.ok("Lista album modificata");
    }

    public ResponseEntity<String> cancella(Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.status(404).body("Album non trovato");
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Album eliminato");
    }
}
