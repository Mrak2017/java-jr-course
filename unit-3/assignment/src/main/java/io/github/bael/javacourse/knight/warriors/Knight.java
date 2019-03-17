package io.github.bael.javacourse.knight.warriors;

import io.github.bael.javacourse.knight.chances.Chance;

/**
 * Рыцарь. наносит урон черному рыцарю с удвоенной силой.
 */
public class Knight extends Warrior {

    private static final int BLACK_KNIGHT_DAMAGE_MULTIPLIER = 2;

    private Knight() {
        super();
    }

    public Knight(ActorState state) {
        super(state);
    }


    /***
     * Удваиваем урон если противник черный рыцарь.
     * @param chance шанс критического удара
     * @param blackKnight тип противника - черный рыцарь
     */
    public void attackEnemy(Chance chance, BlackKnight blackKnight) {
        int damageValue = state.getAttackLevel() + state.getStrength() * BLACK_KNIGHT_DAMAGE_MULTIPLIER;
        blackKnight.receiveAttack(new Damage(damageValue, this.getIsCriticalStrike(chance)));
    }
}
