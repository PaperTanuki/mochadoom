package net.sourceforge.mochadoom.gamelogic;

public class Hybrid extends SpecialMonster {
  
  @Override
  public boolean isHybrid() {
    return true;
  }
  
  @Override
  public boolean canFly() {
    return true;
  }
  
  @Override
  public float getSilverDamageMultiplier() {
    return 0f;
  }
  
  @Override
  public float getRegularDamageMultiplier() {
    return 0.5f;
  }
  
  @Override
  public float getNonRegularDamageMultiplier() {
    return 1.5f;
  }
  
  
  
}
