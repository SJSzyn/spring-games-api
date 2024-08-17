package com.example.springgamesapi.controller;

import com.example.springgamesapi.dto.GameCreationParams;
import com.example.springgamesapi.service.GameCatalog;
import com.example.springgamesapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class GameController {

    private final GameCatalog gameCatalog;
    private final GameService gameService;

    @Autowired
    public GameController(GameCatalog gameCatalog, GameService gameService) {
        this.gameCatalog = gameCatalog;
        this.gameService = gameService;
    }

    @GetMapping("/gamesId")
    public Collection<String> getGameIdentifiers() {
        return gameCatalog.getGameIdentifiers();
    }

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams gameCreationParams) {
        return gameService.createGame(gameCreationParams);
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId) {
        return gameService.getGameState(gameId);
    }
}
