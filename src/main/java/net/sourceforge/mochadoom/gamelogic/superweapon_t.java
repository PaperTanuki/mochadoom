package net.sourceforge.mochadoom.gamelogic;

import static net.sourceforge.mochadoom.doom.items.weaponinfo;

import net.sourceforge.mochadoom.doom.player_t;
import net.sourceforge.mochadoom.doom.weapontype_t;

public class superweapon_t extends mobj_t{

	public boolean isSilverBullet(player_t player){
		return player.getSilverAmmoCount()>0;
	}
	
	public boolean checkSilverBullet(player_t player){
		
		return player.ammo[weaponinfo[weapontype_t.wp_fist.ordinal()].ammo.ordinal()] >= 15;
	}

	
}
