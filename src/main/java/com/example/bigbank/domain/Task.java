package com.example.bigbank.domain;

public class Task {

    private String adId;
    private String message;
    private String reward;
    private Number expiresIn;
    private String probability;

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Number getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Number expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }
}
