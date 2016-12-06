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
public class monster_t extends mobj_t{



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

    /**
     * Devuelve verdadero si el mounstro es Vampiro
     * @return
     */
    public boolean isVampire(){
        return (statusFlag & VAMPIRE) == VAMPIRE;
    }

    /**
     * Devuelve verdadero si es hombre lobo
     * @return
     */
    public boolean isWerewolf(){
        return (statusFlag & WEREWOLF) == WEREWOLF;
    }

    /**
     * Devuelve veraddero si es hybrido
     * @return
     */
    public boolean isHybrid(){
        return (statusFlag & HYBRID) == HYBRID;
    }

    /**
     * Devuelve verdadero si es resistente
     * @return
     */
    public boolean isResistant(){
        return CLEAN != statusFlag;
    }

    /**
     * Devuelve verdadero si es Ghoul
     * @return boolean
     */
    public boolean isGhoul(){
        return ghoul;
    }

    /**
     * Getter para los flags de contaminacion
     * @return flags de contaminacion
     */
    public int getContaminatedFlags(){
        return contaminatedFlags;

    }

    /**
     * Devuelve verdadero si el mounstro esta contaminado
     * @return boolean
     */
    public boolean isContaminated(){
        return contaminatedFlags >0;
    }

    /**
     * Contamina el mounstro con un tipo de contaminacion
     * @param newContamination
     */
    public void contaminate(int newContamination){
        contaminatedFlags |= newContamination;
    }


    /**
     * Setea el estado del mounstro
     * @param status
     */
    public void setStatusFlag(int status){statusFlag=status & 1;}


    /**
     * Devuelve el tiempo vivo del mounstro
     * @return tiempo vivo
     */
    public int getTimeAlive(){
        return timeAlive;
    }

    /**
     * Seter para el multiplicador del mounstro, mayor a 0
     * @param value
     */
    public void setSpeedMult(int value){
        if(value >=0) this.speedMult = value;
    }

    /**
     * Devuelve el multiplicador de velocidad del monster
     * @return multiplicador
     */
    public int getSpeedMult(){
        return speedMult;
    }

    /**
     * Calcula el multiplicador de la velocidad, dependiendo de la hora del dia
     * @param kronos
     * @return multiplicador
     */
    public float getSpeedMultWithTime(Kronos kronos){
        float finalSpeed = getSpeedMult();
        IDayPart dayPart = kronos.currentDayPart();

        if(dayPart.isNight() && (isVampire() || isWerewolf() || isWerewolf())){
            int nightTime =kronos.getPartTime();
            float mult = nightTime/600 + 1;
            finalSpeed = finalSpeed*mult;

        }
        else{
            //System.out.println(kronos.getPartTime());
        }
        return finalSpeed;
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
    public int getCriticalHealth() {
      return CRITICAL_HEALTH;
    }

}
