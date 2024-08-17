# Spring Games API

## 1-2 |  Conception d’une API REST

API (Application Programming Interface)

URL (Uniform Resource Locator)

Example : `http://localhost:8080/games/1/moves?player=X`

- Base URL : `http://localhost:8080/`
- Endpoints : `/games/{gameId}`
- Query Parameters : `?status=active`

---

HTTP Methods

- GET : Retrieve data
- POST : Create new data
- PUT : Update existing data
- DELETE : Remove data

---

Entites / Resoruces

- Game instance
- Move of within the game

---

US (User Stories)

- As a User, I would like to create a game of TicTacToe
- As a User, I would like to retrieve the current state of a game
- As a User, I would like to be able to submit moves
- As a User, I would like to be able to see the possible moves