package com.conorginty.battlegrounds.Cards.Tier1Minions;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.AbilityInterfaces.Battlecry;
import com.conorginty.battlegrounds.Cards.Minion;

public class AlleyCat extends Minion implements Battlecry {
    public AlleyCat(boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        super("Alleycat", 1, 1, 1, "Beast", true, false, false, false, isTavernMinion, isOwnedMinion, isHandMinion, isPlayedMinion, cardCollection);
    }

    public AlleyCat(CardCollection cardCollection) {
        super("Alleycat", 1, 1, 1, "Beast", true, false, false, false, true, false, false, false, cardCollection);
    }

    @Override
    public boolean play() {
        if (super.play()) {
            activateBattlecry();
            return true;
        }
        return false;
    }

    // If board is not full
    // - summon a 1/1 Cat token to the right
    // - return true
    // else
    // - return false
    @Override
    public boolean activateBattlecry() {
        if (!cardCollection.isFull()) {
            System.out.println("Activating Battlecry effect...");
            // Call the Factory Constructor to create a "Tabbycat" Token (which also adds it to the board)
            Minion tabbycat = createMinion("Tabbycat", 1, 1, 1, "Beast", false, false, false, false, false, false, false, true, cardCollection);
        }
        return false;
    }
}
