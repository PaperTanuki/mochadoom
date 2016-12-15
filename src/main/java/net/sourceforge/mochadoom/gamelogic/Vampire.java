package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.daycycle.Kronos;

public class Vampire extends Leecher {
	
	public Vampire() {
        super();
        this.flags |= MF_NOGRAVITY | MF_FLOAT;
    }
    
    public Vampire(Actions A) {
        super(A);
        this.flags |= MF_NOGRAVITY | MF_FLOAT;
    }
  
    @Override
    public boolean isVampire() {
      return true;
    }

    @Override
    public float getSpeedMultWithTime(Kronos kronos) {
        this.flags |= MF_NOGRAVITY | MF_FLOAT;
        return super.getSpeedMultWithTime(kronos);
    }

    @Override
    public float getRegularDamageMultiplier() {
      return 0.1f;
    }
    
    @Override
    public float getNonRegularDamageMultiplier() {
      return 1.5f;
    }
    
    @Override
    public boolean canFly() {
      return true;
    }

}
