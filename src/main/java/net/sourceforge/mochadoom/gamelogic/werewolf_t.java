package net.sourceforge.mochadoom.gamelogic;

/**
 * Created by Nicolas on 13-12-2016.
 */
public class werewolf_t extends SpecialMonster {

    @Override
    public boolean isWerewolf() {
        return true;
    }

    @Override
    public float getSilverDamageMultiplier() {
        return 2.0f;
    }

    @Override
    public float getRegularDamageMultiplier() {
        return 0.75f;
    }

    @Override
    public int getSpeedMult() {
        return super.getSpeedMult() * (getTimeAlive() / 1000);
    }
}
