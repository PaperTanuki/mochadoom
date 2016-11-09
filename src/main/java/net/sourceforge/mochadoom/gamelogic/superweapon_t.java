package net.sourceforge.mochadoom.gamelogic;

import net.sourceforge.mochadoom.defines.AmmoType;

public class superweapon_t extends mobj_t{
	
	public int ammotype;
	
	public superweapon_t(){
		
		super();
	}
	
	public superweapon_t(Actions A){
		
		super(A);
	}
	
	public boolean isSilverBullet(){
		
		return this.ammotype == AmmoType.am_silver.ordinal();
	}
	
	public void doSiverBullet(){
		
	}
	
	
}
