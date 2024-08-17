package com.example.springgamesapi.controller;

import com.example.springgamesapi.service.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class GameController {
    private final GameCatalog gameCatalog;

    @Autowired
    public GameController(GameCatalog gameCatalog) {
        this.gameCatalog = gameCatalog;
    }

    @GetMapping("/gamesId")
    public Collection<String> getGameIdentifiers() {
        return gameCatalog.getGameIdentifiers();
    }
}
