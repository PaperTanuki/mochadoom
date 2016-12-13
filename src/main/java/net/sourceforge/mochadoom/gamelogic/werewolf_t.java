package net.sourceforge.mochadoom.gamelogic;

/**
 * Created by Nicolas on 13-12-2016.
 */
<<<<<<< HEAD
public class werewolf_t extends monster_t {
=======
public class werewolf_t extends SpecialMonster {

>>>>>>> a2ad1a735a9ac5dffac7404272655e5aafe01818

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
<<<<<<< HEAD
        return super.getSpeedMult()*(getTimeAlive()/1000);
=======
        return super.getSpeedMult() * getTimeAlive() / 1000;
>>>>>>> a2ad1a735a9ac5dffac7404272655e5aafe01818
    }
}
