package com.example.springgamesapi.controller;

import com.example.springgamesapi.dto.GameCreationParams;
import com.example.springgamesapi.service.GameCatalog;
import com.example.springgamesapi.service.GamePlugin;
import com.example.springgamesapi.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
public class GameController {

    private final GameCatalog gameCatalog;
    private final GameService gameService;
    private final List<GamePlugin> gamePlugins;

    @Autowired
    public GameController(GameCatalog gameCatalog, GameService gameService, List<GamePlugin> gamePlugins) {
        this.gameCatalog = gameCatalog;
        this.gameService = gameService;
        this.gamePlugins = gamePlugins;
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

    @GetMapping("/catalog")
    public List<String> getGameCatalog(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return gamePlugins.stream()
                .map(plugin -> plugin.getName(locale != null ? locale : Locale.getDefault()))
                .collect(Collectors.toList());
    }
}
