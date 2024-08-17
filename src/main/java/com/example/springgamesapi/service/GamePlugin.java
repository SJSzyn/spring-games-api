package com.example.springgamesapi.service;

import java.util.Locale;

public interface GamePlugin {

    Object createGame(int playerCount, int boardSize);
    Object createGame();
    String getName(Locale locale);
}
