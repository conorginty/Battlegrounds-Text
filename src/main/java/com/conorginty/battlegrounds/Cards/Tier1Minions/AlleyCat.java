package com.conorginty.battlegrounds.Cards.Tier1Minions;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.Minion;

public class AlleyCat extends Minion {
    public AlleyCat(boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        super("Alleycat", 1, 1, 1, "Beast", true, false, false, false, isTavernMinion, isOwnedMinion, isHandMinion, isPlayedMinion, cardCollection);
    }

    // If board is not full
    // - summon a 1/1 Cat token to the right
    // - return true
    // else
    // - return false
    @Override
    public boolean activateBattlecry() {
        if (!cardCollection.isFull()) {
            // Call the Factory Constructor to create a "Murloc Scout" Token
            Minion murlocScout = createMinion("Murloc Scout", 1, 1, 1, "Murloc", false, false, false, false, false, false, false, true, cardCollection);
            // Add the token to the end of the board
            cardCollection.addNewMinion(murlocScout);
        }
        return false;
    }
}