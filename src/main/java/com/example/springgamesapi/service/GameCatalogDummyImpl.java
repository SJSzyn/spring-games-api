package com.example.springgamesapi.service;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class GameCatalogDummyImpl implements GameCatalog {
    @Override
    public Collection<String> getGameIdentifiers() {
        TicTacToeGameFactory factory = new TicTacToeGameFactory();
        return Collections.singletonList(factory.getGameFactoryId());
    }
}
