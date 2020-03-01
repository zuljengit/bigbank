package com.example.bigbank.service;

import com.example.bigbank.domain.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;
    @Value("${baseUrl}")
    private String baseUrl;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GameInfo startGame() {
        GameInfo gameInfo = restTemplate.postForObject(baseUrl + "game/start", null, GameInfo.class);
        if (gameInfo == null) {
            throw new RuntimeException("Rest error");
        }
        return gameInfo;
    }

    public Reputation getReputation(String gameId) {
        Reputation reputation =
                restTemplate.postForObject(baseUrl + gameId + "/investigate/reputation", null,
                        Reputation.class);
        if (reputation == null) {
            throw new RuntimeException("Rest error");
        }
        return reputation;
    }

    public Task[] getTasks(String gameId) {
        Task[] tasks = restTemplate.getForObject(baseUrl + gameId + "/messages", Task[].class);
        if (tasks == null) {
            throw new RuntimeException("Rest error");
        }
        return tasks;
    }

    public TaskResponse solveTask(String gameId, String adId) {
        TaskResponse taskResponse = restTemplate.postForObject(baseUrl + gameId + "/solve/" + adId, null,
                TaskResponse.class);
        if (taskResponse == null) {
            throw new RuntimeException("Rest error");
        }
        return taskResponse;
    }

    public Item[] getShopItems(String gameId) {
        Item[] items = restTemplate.getForObject(baseUrl + gameId + "/shop", Item[].class);
        if (items == null) {
            throw new RuntimeException("Rest error");
        }
        return items;
    }

    public BuyItemResponse buyItem(String gameId, String itemId) {
        BuyItemResponse buyItemResponse = restTemplate.postForObject(baseUrl + gameId + "/shop/buy/" + itemId,
                null, BuyItemResponse.class);
        if (buyItemResponse == null) {
            throw new RuntimeException("Rest error");
        }
        return buyItemResponse;
    }
}
