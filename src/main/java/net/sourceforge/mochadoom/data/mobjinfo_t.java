package net.sourceforge.mochadoom.data;

import net.sourceforge.mochadoom.data.sounds.sfxenum_t;
import net.sourceforge.mochadoom.defines.StateNum;

public class mobjinfo_t {
    //TODO ING: Aqui se pueden agregar atributo a las cosas (Ej: Vampiros, Ghoul)
    public int doomednum;
    public StateNum spawnstate;
    public int spawnhealth;
    public StateNum seestate;
    public sfxenum_t seesound;
    public int reactiontime;
    public sfxenum_t attacksound;
    public StateNum painstate;
    public int painchance;
    public sfxenum_t painsound;
    public StateNum meleestate;
    public StateNum missilestate;
    public StateNum deathstate;
    public StateNum xdeathstate;
    public sfxenum_t deathsound;
    public int speed;
    public int radius;
    public int height;
    public int mass;
    public int damage;
    public sfxenum_t activesound;
    public int flags;
    public StateNum raisestate;


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

    public mobjinfo_t(int doomednum, StateNum spawnstate, int spawnhealth,
                      StateNum seestate, sfxenum_t seesound, int reactiontime,
                      sfxenum_t attacksound, StateNum painstate,
                      int painchance, sfxenum_t painsound,
                      StateNum meleestate, StateNum missilestate,
                      StateNum deathstate, StateNum xdeathstate,
                      sfxenum_t deathsound, int speed, int radius, int height,
                      int mass, int damage, sfxenum_t activesound, int flags,
                      StateNum raisestate) {
        super();
        this.doomednum = doomednum;
        this.spawnstate = spawnstate;
        this.spawnhealth = spawnhealth;
        this.seestate = seestate;
        this.seesound = seesound;
        this.reactiontime = reactiontime;
        this.attacksound = attacksound;
        this.painstate = painstate;
        this.painchance = painchance;
        this.painsound = painsound;
        this.meleestate = meleestate;
        this.missilestate = missilestate;
        this.deathstate = deathstate;
        this.xdeathstate = xdeathstate;
        this.deathsound = deathsound;
        this.speed = speed;
        this.radius = radius;
        this.height = height;
        this.mass = mass;
        this.damage = damage;
        this.activesound = activesound;
        this.flags = flags;
        this.raisestate = raisestate;
    }
    
    public boolean isVampire(){
        return vampire && !isWerewolf();
    }
    
    public boolean isWerewolf(){
        return werewolf && !isVampire();
    }
    
    public boolean isHybrid(){
        return isVampire() && isWerewolf();
    }
    
    public boolean isResistant(){
        return isVampire() || isWerewolf();
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
    public boolean isContaminated(){
        return contaminatedFlags != CLEAN;
    }
    
    public void contaminate(int newContamination){
        contaminatedFlags |= newContamination;
    }
    
    public int getTimeAlive(){
        return timeAlive;
    }
    
    public void setSpeed(int value){
        if(value >=0) speed = value;
    }

}
