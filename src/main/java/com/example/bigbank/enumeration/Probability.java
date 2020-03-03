package com.example.bigbank.enumeration;

import java.util.Arrays;

public enum Probability {

    A("Piece of cake"),
    B("Sure thing"),
    C("Walk in the park"),
    D("Quite likely"),
    E("Gamble"),
    F("Risky"),
    G("Playing with fire"),
    H("Hmmm...."),
    I("Rather detrimental"),
    J("Suicide mission"),
    K("Impossible");

    String text;

    Probability(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public Probability getProbability(String text) {
        return Arrays.stream(Probability.values())
                .filter(probability -> probability.text.equalsIgnoreCase(text))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Enum error"));
    }

    public static boolean isValidProbability(String text) {
        return Arrays.stream(Probability.values())
                .anyMatch(probability -> probability.text.equalsIgnoreCase(text));
    }
}
