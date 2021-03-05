package com.conorginty.battlegrounds.Cards.Tier1Minions;

import com.conorginty.battlegrounds.CardCollections.CardCollection;
import com.conorginty.battlegrounds.Cards.Minion;

public class FiendishServant extends Minion {
    public FiendishServant(boolean isTavernMinion, boolean isOwnedMinion, boolean isHandMinion, boolean isPlayedMinion, CardCollection cardCollection) {
        super("Fiendish Servant", 1, 2, 1, "Demon", false, true, false, false, isTavernMinion, isOwnedMinion, isHandMinion, isPlayedMinion, cardCollection);
    }

    public FiendishServant(CardCollection cardCollection) {
        super("Fiendish Servant", 1, 2, 1, "Demon", false, true, false, false, true, false, false, false, cardCollection);
    }

    // if the board isn't empty after this Minion dies
    // - increase the attack of a random friendly minion by the attack of this minion
    // - return true
    // else
    // - return false
    @Override
    protected boolean activateDeathrattle() {
        if (!cardCollection.isEmpty()) {
            // Get Random Minion from the board
            Minion random = cardCollection.getRandomMinion();
            // Increase the randomly-chosen minion's attack by the attack of Fiendish Servant
            random.gainAttack(getAttack());
            return true;
        }
        return false;
    }
}
