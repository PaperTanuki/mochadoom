package net.sourceforge.mochadoom.gamelogic;

public class SpecialMonster extends monster_t{
	
	public SpecialMonster() {
        super();
    }
    
    public SpecialMonster(Actions A) {
        super(A);
    }
    
    @Override
    public boolean canContaminate() {
      return true;
    }

    @Override
    public void contaminate(int newContamination) {
        return;
    }

    @Override
    public boolean isResistant() {
        return true;
    }

}