package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.data.mobjtype_t;
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
        return 0.1f;
    }

    @Override
    public int getSpeedMult() {
        return super.getSpeedMult();
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
