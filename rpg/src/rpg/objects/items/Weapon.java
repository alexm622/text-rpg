package rpg.objects.items;

import rpg.objects.combat.Action;

public interface Weapon {
        
	
        

    public String getWeapontype();

    public void setWeapontype(String weapontype);
    public String getWeaponskill();

    public void setWeaponskill(String weaponskill);
    public Action getDamage();

    public void setDamage(Action damage);

 

}