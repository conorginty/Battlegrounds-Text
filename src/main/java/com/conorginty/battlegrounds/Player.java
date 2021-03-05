package com.conorginty.battlegrounds;

import com.conorginty.battlegrounds.CardCollections.Board;
import com.conorginty.battlegrounds.CardCollections.Hand;
import com.conorginty.battlegrounds.CardCollections.Tavern;
import com.conorginty.battlegrounds.Cards.Minion;

public class Player {
    // === Instance Variables/ Fields ===
    private String username;
    // References to key game components
    private Board board;
    private Hand hand;
    private Tavern tavern;
    // Other fields
    private int gold;
    private int maxGold;

    // === Constructors ===
    public Player(String username, Board board, Hand hand, Tavern tavern) {
        this.username = username;
        // Player starts off with an empty board and hand (looked after in those classes)
        // Player needs a reference to these to interact with them
        this.board = board;
        this.hand = hand;
        this.tavern = tavern;
        // Player starts off with 3 gold. Max gold is 10
        this.gold = 3;
        this.maxGold = 10;
    }

    // === Getters ===
    public String getUsername() {
        return username;
    }

    public Board getBoard() {
        return board;
    }

    public Hand getHand() {
        return hand;
    }

    // === Setters ===

    // === Extras ===
    public boolean buyMinion(Minion minion) {
        if (gold < minion.getCost()) {
            System.out.println("Not enough money to buy the Minion");
            return false;
        }
        // Have enough money to buy it
        // BUY THE MINION (Remove it from the Tavern, and add it to your hand)
        // Deduct your Gold by the cost of the Minion
        return true;
    }
}
