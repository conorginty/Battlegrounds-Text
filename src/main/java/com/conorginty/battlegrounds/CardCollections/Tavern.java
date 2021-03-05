package com.conorginty.battlegrounds.CardCollections;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.Minion;
import com.conorginty.battlegrounds.Cards.Tier1Minions.*;

import java.util.Random;

public class Tavern extends CardCollection {
    // === Instance Variables/ Fields ===
    private int currentSize;
    private int tavernTier;
    private boolean frozen;
    private boolean reRollCost;
    // Reference to the Board (so it can move the Minion from Hand -> Board)
    public Hand hand;
    public WaitingRoom waitingRoom = new WaitingRoom("Waiting Room", 10);

    // All the Minion Instances (in Array Lists for easy access)
    private Minion[] tier1Minions = {
            new MurlocTidehunter(waitingRoom),
            new AlleyCat(waitingRoom),
            new FiendishServant(waitingRoom)
    };

    // === Constructors ===
    public Tavern(Hand hand) {
        super("Tavern", 7);
        this.hand = hand;
        this.currentSize = 3;
        // Tavern Starts off with 3 Random Units
        addThreeRandomTier1Minions();
    }

    // === Getters ===

    // === Setters ===

    // === Extras ===
    private void addThreeRandomTier1Minions() {
        Random rand = new Random();

        for (int i=0; i < 3; i++) {
            // Generate a random index between 0-2
            int randomIndex = rand.nextInt(3);
            // Grab a random minion
            Minion randomMinion = tier1Minions[randomIndex];
            randomMinion.setCardCollection(this);
            addNewMinion(randomMinion);
        }
    }
}
