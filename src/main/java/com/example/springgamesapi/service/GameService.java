package com.example.springgamesapi.service;

import com.example.springgamesapi.dto.GameCreationParams;

public interface GameService {

    String createGame(GameCreationParams gameCreationParams);
    Object getGameState(String gameId);
}
