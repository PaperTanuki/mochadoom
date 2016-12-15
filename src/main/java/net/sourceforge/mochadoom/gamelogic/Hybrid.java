package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.data.mobjtype_t;
import net.sourceforge.mochadoom.daycycle.IMoonPhase;
import net.sourceforge.mochadoom.daycycle.Kronos;

public class Hybrid extends SpecialMonster {
  boolean changed= false;
  mobjtype_t originalType;
  
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
  public Hybrid(Actions A) {

    super(A);
    // A mobj_t is ALSO a thinker, as it always contains the struct.
    // Don't fall for C's trickery ;-)
    // this.thinker=new thinker_t();

  }
  
  /**
   * returns the same value as Vampires (it receives the same damage
   * from regular weapons)
   */

  @Override
  public float getSpeedMultWithTime(Kronos kronos) {
    this.flags |= MF_NOGRAVITY | MF_FLOAT;
    return super.getSpeedMultWithTime(kronos);
  }
  @Override
  public float getRegularDamageMultiplier() {
    IMoonPhase moon = kronos.currentMoonPhase();
    if(moon.isFull()) return 0.1f;
    else if(moon.isYoung()) return 0.2f;
    else if(moon.isOld()) return 0.3f;
    else return 0.4f;
  }

  @Override
  public int getSpeedMult() {
    IMoonPhase moon = kronos.currentMoonPhase();
    if(moon.isFull()) return 3;
    else if(moon.isYoung()) return 2;
    else if(moon.isOld()) return 2;
    else return 1;
  }

  @Override
  public void checkSkin(Kronos kronos){

    if(kronos.isNight() && !changed) {
      originalType = this.type;
      changed = true;
      //System.out.println("noshe");
      this.type= mobjtype_t.MT_SERGEANT;

      changeSkin();
    }
    else if(kronos.isDay()){
      if(changed){
        changed = false;
        //mSystem.out.println("dia another");
        this.type=originalType;

        changeSkin();

      }

    }
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
