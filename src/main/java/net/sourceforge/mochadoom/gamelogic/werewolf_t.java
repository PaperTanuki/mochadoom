package net.sourceforge.mochadoom.gamelogic;

/**
 * Created by Nicolas on 13-12-2016.
 */
public class werewolf_t extends monster_t {






    @Override
    public boolean isWerewolf(){
        return true;
    }
    @Override
    public float getSilverDamageMultiplier(){
        return 2.0f;

    }

    @Override
    public float getRegularDamageMultiplier() {
        return super.getRegularDamageMultiplier();
    }

    @Override
    public int getSpeedMult() {
        return super.getSpeedMult()*getTimeAlive()/1000;
    }
}
