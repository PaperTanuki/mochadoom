package net.sourceforge.mochadoom.gamelogic;

/**
 * Created by Nicolas on 02-11-2016.
 */
public class monster_t extends mobj_t{



    // Ingenieria de software

    static public int RESISTANCE_TO_NORMAL_WP = 50;


    private boolean vampire;
    private boolean werewolf;
    private boolean ghoul;

    private int contaminatedFlags;

    /**
     * A monster can be contaminated by using the logic OR operation with any new flag.
     * A monster can be cleaned by using the logic AND with the CLEAN status.
     */
    public static final int CLEAN = 0b00;
    public static final int VAMPIRE = 0b01;
    public static final int WEREWOLF = 0b10;
    public static final int HYBRID = 0b11;


    private int timeAlive;


    public monster_t() {
        super();
    }
    public boolean isVampire(){
        return contaminatedFlags == VAMPIRE;
    }

    public boolean isWerewolf(){
        return contaminatedFlags == WEREWOLF;
    }

    public boolean isHybrid(){
        return contaminatedFlags == HYBRID;
    }

    public boolean isResistant(){
        return CLEAN != contaminatedFlags;
    }

    public boolean isGhoul(){
        return ghoul;
    }

    public void setVampireStatus(boolean vampireStatus){
        if(!isGhoul()) vampire = vampireStatus;
    }

    public void setWerewolfStatus(boolean werewolfStatus){
        if(!isGhoul()) werewolf = werewolfStatus;
    }

    public int getContaminatedType(){
        return contaminatedFlags;

    }
    public void contaminate(int newContamination){
        contaminatedFlags |= newContamination;
    }

    public int getTimeAlive(){
        return timeAlive;
    }

    /*public void setSpeed(int value){
        if(value >=0) speed = value;
    }*/

}
