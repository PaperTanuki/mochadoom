package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.data.mobjtype_t;
import net.sourceforge.mochadoom.daycycle.FullMoon;
import net.sourceforge.mochadoom.daycycle.IMoonPhase;
import net.sourceforge.mochadoom.daycycle.Kronos;

import static net.sourceforge.mochadoom.data.info.mobjinfo;

/**
 * Created by Nicolas on 13-12-2016.
 */

public class werewolf_t extends SpecialMonster {
    boolean init = true;
    mobjtype_t originalType;
    boolean changed = false;
    @Override
    public boolean isWerewolf() {
        return true;
    }

    public werewolf_t(Actions A) {
        super(A);

        // A mobj_t is ALSO a thinker, as it always contains the struct.
        // Don't fall for C's trickery ;-)
        // this.thinker=new thinker_t();

    }

    @Override
    public float getSilverDamageMultiplier() {
        return 2.0f;
    }

    @Override
    public float getRegularDamageMultiplier() {
        IMoonPhase moon = kronos.currentMoonPhase();
        if(moon.isFull()) return 0.1f;
        else if(moon.isYoung()) return 0.2f;
        else if(moon.isOld()) return 0.3f;
        else return 0.4f;
    }

    @Override
    public int getSpeedMult() {
        IMoonPhase moon = kronos.currentMoonPhase();
        if(moon.isFull()) return 3;
        else if(moon.isYoung()) return 2;
        else if(moon.isOld()) return 2;
        else return 1;
    }

    @Override
    public void checkSkin(Kronos kronos){
        if(kronos.isNight() && !changed) {
            originalType = this.type;
            changed = true;
            System.out.println("noshe");
            this.type= mobjtype_t.MT_SERGEANT;

            changeSkin();
        }
        else if(kronos.isDay()){
            if(changed){
                changed = false;
                System.out.println("dia another");
                this.type=originalType;

                changeSkin();

            }

        }
    }


}
