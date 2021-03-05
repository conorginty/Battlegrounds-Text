package com.conorginty.battlegrounds.Cards.Tier1Minions;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.Minion;

public class MurlocTidehunter extends Minion {
    public MurlocTidehunter(boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        super("Murloc Tidehunter", 1, 2, 1, "Murloc", true, false, false, false, isTavernMinion, isOwnedMinion, isHandMinion, isPlayedMinion, cardCollection);
    }

    public MurlocTidehunter(CardCollection cardCollection) {
        super("Murloc Tidehunter", 1, 2, 1, "Murloc", true, false, false, false, true, false, false, false, cardCollection);
    }

    // If board is not full
    // - summon a 1/1 Murloc token to the right
    // - return true
    // else
    // - return false
    @Override
    public boolean activateBattlecry() {
        if (!cardCollection.isFull()) {
            // Call the Factory Constructor to create a "Murloc Scout" Token AND Add the token to the end of the board
            Minion murlocScout = createMinion("Murloc Scout", 1, 1, 1, "Murloc", false, false, false, false, false, false, false, true, cardCollection);
        }
        return false;
    }
}

// JSON file that creates a list of all the characters, their attributes, behaviours etc
// Annotate all class and methods (java-docs) - populate an API rendering of the java project, which we can then drag and drop