package com.example.bigbank.domain;

public class GameInfo {

    private String gameId;
    private Number lives;
    private Number gold;
    private Number level;
    private Number score;
    private Number highScore;
    private Number turn;

    public GameInfo() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Number getLives() {
        return lives;
    }

    public void setLives(Number lives) {
        this.lives = lives;
    }

    public Number getGold() {
        return gold;
    }

    public void setGold(Number gold) {
        this.gold = gold;
    }

    public Number getLevel() {
        return level;
    }

    public void setLevel(Number level) {
        this.level = level;
    }

    public Number getScore() {
        return score;
    }

    public void setScore(Number score) {
        this.score = score;
    }

    public Number getHighScore() {
        return highScore;
    }

    public void setHighScore(Number highScore) {
        this.highScore = highScore;
    }

    public Number getTurn() {
        return turn;
    }

    public void setTurn(Number turn) {
        this.turn = turn;
    }
}
