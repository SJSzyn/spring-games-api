package com.example.springgamesapi.service;

import com.example.springgamesapi.dto.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private final Map<String, Object> games = new HashMap<>();

    private GameFactory getGameFactory(String gameType) {
        if ("tic-tac-toe".equalsIgnoreCase(gameType)) {
            return new TicTacToeGameFactory();
        }
        return null;
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