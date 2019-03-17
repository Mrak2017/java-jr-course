package io.github.bael.javacourse.knight.warriors;

import io.github.bael.javacourse.knight.chances.Chance;

/**
 * Варвар. при низком здоровье (20 %) сила умножается на 5.
 */
public class Barbarian extends Warrior {

    private static final double RAGE_HEALTH_EDGE = .2d;

    private Barbarian() {
        super();
    }

    public Barbarian(ActorState state) {
        super(state);
    }

    @Override
    protected int getDamageValue() {
        int damageMultiplier = state.getHPState() <= RAGE_HEALTH_EDGE ? 5 : 1;
        return state.getAttackLevel() + state.getStrength() * damageMultiplier;
    }
}
