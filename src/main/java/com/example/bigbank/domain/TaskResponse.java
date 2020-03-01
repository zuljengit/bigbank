package com.example.bigbank.domain;

public class TaskResponse {

    private Boolean success;
    private Number lives;
    private Number gold;
    private Number score;
    private Number highScore;
    private Number turn;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
