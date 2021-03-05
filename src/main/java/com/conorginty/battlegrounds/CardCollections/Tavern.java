package com.conorginty.battlegrounds.CardCollections;

import com.conorginty.battlegrounds.CardCollections.CardCollection;

public class Tavern extends CardCollection {
    // === Instance Variables/ Fields ===
    private int tavernTier;
    private boolean frozen;
    private boolean reRollCost;
    // Reference to the Board (so it can move the Minion from Hand -> Board)
    public Hand hand;

    // === Constructors ===
    public Tavern(Hand hand) {
        super("Tavern", 7);
        this.hand = hand;
    }

    // === Getters ===

    // === Setters ===

    // === Extras ===
}
