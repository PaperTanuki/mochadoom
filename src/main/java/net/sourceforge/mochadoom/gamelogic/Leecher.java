package net.sourceforge.mochadoom.gamelogic;

public class Leecher extends SpecialMonster{
	
	public Leecher() {
        super();
    }
    
    public Leecher(Actions A) {
        super(A);
    }
	
	@Override
	public boolean isLeecher() {
		return true;
	}

}
