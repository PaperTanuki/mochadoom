package net.sourceforge.mochadoom.gamelogic;

public class Ghoul extends Leecher{
	
	@Override
    public float getRegularDamageMultiplier() {
      return 0.75f;
    }
    
    @Override
    public float getNonRegularDamageMultiplier() {
      return 1.75f;
    }
    
    @Override
    public boolean canFly() {
      return false;
    }

}
