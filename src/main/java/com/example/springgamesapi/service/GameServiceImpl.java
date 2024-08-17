package com.example.springgamesapi.service;

import com.example.springgamesapi.dto.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, Object> games = new HashMap<>();
    private final List<GamePlugin> gamePlugins;

    @Autowired
    public GameServiceImpl(List<GamePlugin> gamePlugins) {
        this.gamePlugins = gamePlugins;
    }

    private GameFactory getGameFactory(String gameType) {
        if ("tic-tac-toe".equalsIgnoreCase(gameType)) {
            return new TicTacToeGameFactory();
        }
        return null;
    }

    private GamePlugin getPluginForGameType(String gameType) {
        return gamePlugins.stream()
                .filter(plugin -> plugin.getName(Locale.getDefault()).equalsIgnoreCase(gameType))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String createGame(GameCreationParams gameCreationParams) {
        String gameId = UUID.randomUUID().toString();
        GameFactory gameFactory = getGameFactory(gameCreationParams.getGameType());
        if (gameFactory != null) {
            Object game = gameFactory.createGame(gameCreationParams.getPlayerCount(), gameCreationParams.getBoardSize());
            games.put(gameId, game);
        }
        return gameId;
    }

    @Override
    public Object getGameState(String gameId) {
        Object game = games.get(gameId);
        if (game == null) {
            return "Game not found";
        }
        return game;
    }

}
