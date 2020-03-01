package com.example.bigbank.controller;

import com.example.bigbank.domain.*;
import com.example.bigbank.service.RestService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class GameRestController {

    private final RestService restService;

    public GameRestController(RestService restService) {
        this.restService = restService;
    }

    @PostMapping(value = "/start", produces = MediaType.APPLICATION_JSON_VALUE)
    public GameInfo startGame() {
        return restService.startGame();
    }

    @PostMapping(value = "/reputation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reputation getReputation(@NotNull @RequestParam String gameId) {
        return restService.getReputation(gameId);
    }

    @GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task[] getTasks(@NotNull @RequestParam String gameId) {
        return restService.getTasks(gameId);
    }

    @PostMapping(value = "/solve", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskResponse solveTask(@NotNull @RequestParam String gameId, @NotNull @RequestParam String adId) {
        return restService.solveTask(gameId, adId);
    }

    @GetMapping(value = "/shop", produces = MediaType.APPLICATION_JSON_VALUE)
    public Item[] getShopItems(@NotNull @RequestParam String gameId) {
        return restService.getShopItems(gameId);
    }

    @PostMapping(value = "/shop/buy", produces = MediaType.APPLICATION_JSON_VALUE)
    public BuyItemResponse buyItem(@NotNull @RequestParam String gameId, @NotNull @RequestParam String itemId) {
        return restService.buyItem(gameId, itemId);
    }
}
