package com.mario.Github.Discografia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @GetMapping
    public List<Album> getAlbum() {
        return service.listaAlbum();
    }

    @PostMapping
    public Album aggiungi(@RequestBody Album album) {
        return service.aggiungi(album);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modifica(@PathVariable Long id, @RequestBody Album album) {
        return service.modifica(id, album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancella(@PathVariable Long id) {
        return service.cancella(id);
    }
}
