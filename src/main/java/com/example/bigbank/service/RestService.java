package com.example.bigbank.service;

import com.example.bigbank.domain.*;
import com.example.bigbank.enumeration.Probability;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestService {

    private final RestTemplate restTemplate;
    @Value("${apiBaseUrl}")
    private String apiBaseUrl;

    public RestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GameInfo startGame() {
        GameInfo gameInfo = restTemplate.postForObject(apiBaseUrl + "game/start", null, GameInfo.class);
        if (gameInfo == null) {
            throw new RuntimeException("Rest error");
        }
        return gameInfo;
    }

    public Reputation getReputation(String gameId) {
        Reputation reputation =
                restTemplate.postForObject(apiBaseUrl + gameId + "/investigate/reputation", null,
                        Reputation.class);
        if (reputation == null) {
            throw new RuntimeException("Rest error");
        }
        return reputation;
    }

    public List<Task> getTasks(String gameId) {
        Task[] tasks = restTemplate.getForObject(apiBaseUrl + gameId + "/messages", Task[].class);
        if (tasks == null) {
            throw new RuntimeException("Rest error");
        }
        System.out.println("------------------------------");
        return Arrays.stream(tasks)
                .peek(System.out::println)
//                .filter(task -> Probability.isValidProbability(task.getProbability()))
                .sorted(Comparator.comparing((Task task) -> Integer.parseInt(task.getReward())).reversed())
                .collect(Collectors.toList());
    }

    public TaskResponse solveTask(String gameId, String adId) {
        TaskResponse taskResponse = restTemplate.postForObject(apiBaseUrl + gameId + "/solve/" + adId, null,
                TaskResponse.class);
        if (taskResponse == null) {
            throw new RuntimeException("Rest error");
        }
        return taskResponse;
    }

    public List<Item> getShopItems(String gameId) {
        Item[] items = restTemplate.getForObject(apiBaseUrl + gameId + "/shop", Item[].class);
        if (items == null) {
            throw new RuntimeException("Rest error");
        }
        return new ArrayList<>(Arrays.asList(items));
    }

    public BuyItemResponse buyItem(String gameId, String itemId) {
        BuyItemResponse buyItemResponse = restTemplate.postForObject(apiBaseUrl + gameId + "/shop/buy/" + itemId,
                null, BuyItemResponse.class);
        if (buyItemResponse == null) {
            throw new RuntimeException("Rest error");
        }
        return buyItemResponse;
    }
}
