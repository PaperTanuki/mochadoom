package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.data.spritenum_t;
import net.sourceforge.mochadoom.data.state_t;
import net.sourceforge.mochadoom.daycycle.IDayPart;
import net.sourceforge.mochadoom.daycycle.Kronos;
import net.sourceforge.mochadoom.defines.StateNum;

import static net.sourceforge.mochadoom.data.info.states;

/**
 * Created by Nicolas on 02-11-2016.
 */
public class monster_t extends mobj_t implements IMonster{

    // Ingenieria de software

    static public int RESISTANCE_TO_NORMAL_WP = 50;
    // Health at which vampires turn into bats.
    static public int CRITICAL_HEALTH = 20;

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

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#isVampire()
     */
    @Override

    public boolean isVampire(){
        return false;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#isWerewolf()
     */
    @Override

    public boolean isWerewolf() {
            return false;
        }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#isHybrid()
     */
    @Override

    public boolean isHybrid(){
        return false;

    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#isResistant()
     */
    @Override

    public boolean isResistant(){
        return false;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#isGhoul()
     */
    @Override

    public boolean isGhoul(){
        return false;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#getContaminatedFlags()
     */
    @Override
    public int getContaminatedFlags() {
        return contaminatedFlags;

    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#isContaminated()
     */
    @Override
    public boolean isContaminated() {
        return contaminatedFlags > 0;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#contaminate(int)
     */
    @Override
    public void contaminate(int newContamination) {
        contaminatedFlags |= newContamination;
    }


    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#setStatusFlag(int)
     */
    public void setStatusFlag(int status){statusFlag = status & 1;}


    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#getTimeAlive()
     */
    @Override
    public int getTimeAlive() {
        return timeAlive;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#setSpeedMult(int)
     */
    @Override
    public void setSpeedMult(int value) {
        if(value >= 0) this.speedMult = value;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#getSpeedMult()
     */
    @Override
    public int getSpeedMult() {
        return speedMult;
    }

    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#getSpeedMultWithTime(net.sourceforge.mochadoom.daycycle.Kronos)
     */
    @Override
    public float getSpeedMultWithTime(Kronos kronos){

        return getSpeedMult();
    }

    //Mirar aqui si se puede cambiar la sprite del monster
    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.mobj_t#SetMobjState(net.sourceforge.mochadoom.defines.StateNum)
     */
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
    /* (non-Javadoc)
     * @see net.sourceforge.mochadoom.gamelogic.IMonster#getCriticalHealth()
     */
    public int getCriticalHealth() {
      return CRITICAL_HEALTH;
    }
    
    @Override
    public float getSilverDamageMultiplier() {

      return 1;
    }
    
    @Override
    public float getRegularDamageMultiplier() {

      return 1;
    }
    
    @Override
    public float getNonRegularDamageMultiplier() {

      return 1;
    }
    
    @Override
    public boolean canContaminate() {
      return false;
    }
    
    @Override
    public boolean canFly() {
      return false;
    }

}
