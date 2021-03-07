package com.conorginty.battlegrounds.Cards.Tier1Minions;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.AbilityInterfaces.Battlecry;
import com.conorginty.battlegrounds.Cards.Minion;

public class MurlocTidehunter extends Minion implements Battlecry {
    public MurlocTidehunter(boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        super("Murloc Tidehunter", 1, 2, 1, "Murloc", true, false, false, false, isTavernMinion, isOwnedMinion, isHandMinion, isPlayedMinion, cardCollection);
    }

    public MurlocTidehunter(CardCollection cardCollection) {
        super("Murloc Tidehunter", 1, 2, 1, "Murloc", true, false, false, false, true, false, false, false, cardCollection);
    }

    @Override
    public boolean play() {
        if (super.play()) {
            activateBattlecry();
            return true;
        }
        return false;
    }

    @Override
    public boolean activateBattlecry() {
        if (!cardCollection.isFull()) {
            System.out.println("Activating Battlecry effect...");
            // Call the Factory Constructor to create a "Murloc Scout" Token (which also adds it to the board)
            Minion murlocScout = createMinion("Murloc Scout", 1, 1, 1, "Murloc", false, false, false, false, false, false, false, true, cardCollection);
        }
        return false;
    }
}