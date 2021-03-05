package com.conorginty.battlegrounds.CardCollections;

import com.conorginty.battlegrounds.Cards.Minion;

public class Hand extends CardCollection {
    // === Instance Variables/ Fields ===
    // Reference to the Board (so it can move the Minion from Hand -> Board)
    public Board board;

    // === Constructors ===
    public Hand(Board board) {
        super("Hand", 10);
        this.board = board;
    }

    // === Getters ===

    // === Setters ===

    // === Extras ===
    public boolean playMinion(int index) {
        if (! validIndex(index)) {
            System.out.println("Invalid Index chosen. No minion played");
            return false;
        }

        // Identify and Remove the Minion from the hand
        Minion minionToPlay = popMinion(index);
        // Add the Minion to the board
        System.out.println("Minion we popped: " + minionToPlay.getName());
        board.addNewMinion(minionToPlay);

        // If the played Minion has a Battlecry effect, activate it
        if (minionToPlay.isHasBattlecry()) {
            System.out.println("Activating Battlecry effect...");
            minionToPlay.activateBattlecry();
        }
        return true;
    }
}
