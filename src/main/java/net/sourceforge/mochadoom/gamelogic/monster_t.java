package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.data.spritenum_t;
import net.sourceforge.mochadoom.data.state_t;
import net.sourceforge.mochadoom.defines.StateNum;

import static net.sourceforge.mochadoom.data.info.states;

/**
 * Created by Nicolas on 02-11-2016.
 */
public class monster_t extends mobj_t{



    // Ingenieria de software

    static public int RESISTANCE_TO_NORMAL_WP = 50;

    private boolean ghoul;

    private int contaminatedFlags;
    private int statusFlag = CLEAN;

    /**
     * A monster can be contaminated by using the logic OR operation with any new flag.
     * A monster can be cleaned by using the logic AND with the CLEAN status.
     */
    public static final int CLEAN = 0b00;
    public static final int VAMPIRE = 0b01;
    public static final int WEREWOLF = 0b10;
    public static final int HYBRID = 0b11;


    private int timeAlive;
    private int speedMult;


    public monster_t() {
        super();
    }
    public monster_t(Actions A) {
        super(A);
        speedMult = 1;
        // A mobj_t is ALSO a thinker, as it always contains the struct.
        // Don't fall for C's trickery ;-)
        // this.thinker=new thinker_t();

    }
    public boolean isVampire(){
        return (statusFlag & VAMPIRE) == VAMPIRE;
    }

    public boolean isWerewolf(){
        return (statusFlag & WEREWOLF) == WEREWOLF;
    }

    public boolean isHybrid(){
        return (statusFlag & HYBRID) == HYBRID;
    }

    public boolean isResistant(){
        return CLEAN != statusFlag;
    }

    public boolean isGhoul(){
        return ghoul;
    }

    public int getContaminatedFlags(){
        return contaminatedFlags;

    }
    public boolean isContaminated(){
        return contaminatedFlags >0;
    }
    public void contaminate(int newContamination){
        contaminatedFlags |= newContamination;
    }

    public void setStatusFlag(int status){statusFlag=status & 1;}

    public int getTimeAlive(){
        return timeAlive;
    }

    public void setSpeedMult(int value){
        if(value >=0) this.speedMult = value;
    }
    public int getSpeedMult(){
        return speedMult;
    }

    //Mirar aqui si se puede cambiar la sprite del monstro
    @Override
    public boolean SetMobjState(StateNum state) {
        state_t st;

        do {
            if (state == StateNum.S_NULL) {
                state = null;
                // MAES/_D_: uncommented this as it should work by now (?).
                A.RemoveMobj(this);
                return false;
            }

            st = states[state.ordinal()];
            this.state = st;
            tics = st.tics;
            sprite = st.sprite;
            frame = (int) st.frame;

            // Modified handling.
            // Call action functions when the state is set

            if (st.acp1 != null) {
                st.acp1.invoke(this);
            }

            state = st.nextstate;
        } while (tics == 0);

        return true;
    }

}
