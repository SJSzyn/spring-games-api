package com.example.springgamesapi.service;

import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class ConnectFourPlugin implements GamePlugin {

    @Value("${game.connectfour.default-player-count}")
    private int defaultPlayerCount;

    @Value("${game.connectfour.default-board-size}")
    private int defaultBoardSize;

    private final MessageSource messageSource;

    @Autowired
    public ConnectFourPlugin(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public Object createGame(int playerCount, int boardSize) {
        ConnectFourGameFactory factory = new ConnectFourGameFactory();
        return factory.createGame(playerCount, boardSize);
    }

    @Override
    public Object createGame() {
        return createGame(defaultPlayerCount, defaultBoardSize);
    }

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("game.connectfour.name", null, locale);
    }
}