package io.github.bael.javacourse.knight.warriors;

import io.github.bael.javacourse.knight.chances.Chance;

public abstract class Warrior implements Actor {

    public static final int CRITICAL_DAMAGE_THRESHOLD = 100;
    private static final int CRITICAL_DAMAGE_MULTIPLIER = 3;
    
    ActorState state;

    protected Warrior() {

    }

    public Warrior(ActorState actorState){
        this.state = actorState;
    }

    @Override
    public void attackEnemy(Chance chance, Actor warrior) {
        warrior.receiveAttack(new Damage(this.getDamageValue(), this.getIsCriticalStrike(chance)));
    }

    protected int getDamageValue() {
        return state.getAttackLevel() + state.getStrength();
    }
    protected boolean getIsCriticalStrike(Chance chance) {
        return chance.getProbability() + state.getLevel() > CRITICAL_DAMAGE_THRESHOLD;
    }

    @Override
    public void receiveAttack(Damage strike) {
        int damageValue = Math.max(0, strike.getValue() - state.getDefenceLevel());
        if (strike.getIsCritical()) {
            damageValue *= CRITICAL_DAMAGE_MULTIPLIER;
        }
        state = state.takeDamage(damageValue);
    }

    @Override
    public ActorState getState() {
        return state;
    }
}
