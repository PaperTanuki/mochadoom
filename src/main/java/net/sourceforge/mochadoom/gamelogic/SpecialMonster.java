package net.sourceforge.mochadoom.gamelogic;

public class SpecialMonster extends monster_t{
	
    @Override
    public boolean canContaminate() {
      return true;
    }

    @Override
    public boolean isResistant() {
        return true;
    }
}
