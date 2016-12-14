package net.sourceforge.mochadoom.gamelogic;

public class Vampire extends Leecher {
  
    @Override
    public boolean isVampire() {
      return true;
    }
    
    @Override
    public float getRegularDamageMultiplier() {
      return 0.5f;
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
