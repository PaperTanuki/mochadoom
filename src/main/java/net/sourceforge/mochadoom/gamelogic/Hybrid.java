package net.sourceforge.mochadoom.gamelogic;

public class Hybrid extends SpecialMonster {
  
  /**
   * returns true because it is Hybrid
   */
  @Override
  public boolean isHybrid() {
    return true;
  }
  
  /**
   * returns true because it inherits from Vampire
   */
  @Override
  public boolean canFly() {
    return true;
  }
  
  /**
   * returns the same value as Vampires (it receives the same damage
   * from regular weapons)
   */
  @Override
  public float getRegularDamageMultiplier() {
    return 0.5f;
  }
  
  /**
   * returns the same value as Vampires (it receives the same damage
   * from non-regular weapons)
   */
  @Override
  public float getNonRegularDamageMultiplier() {
    return 1.5f;
  }
  
  /**
   * receives zero damage from silver bullets
   */
  @Override
  public float getSilverDamageMultiplier() {
    return 0f;
  }
  
}
