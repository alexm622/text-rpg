package rpg.objects.items;

import rpg.objects.Attack;

public class Weapon {
    private Item[] items;

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public static class Item extends rpg.objects.Item {
        private String weapontype;
        private String weaponskill;
        private Attack damage;

        public String getWeapontype() {
            return weapontype;
        }

        public void setWeapontype(String weapontype) {
            this.weapontype = weapontype;
        }

        public String getWeaponskill() {
            return weaponskill;
        }

        public void setWeaponskill(String weaponskill) {
            this.weaponskill = weaponskill;
        }

        public Attack getDamage() {
            return damage;
        }

        public void setDamage(Attack damage) {
            this.damage = damage;
        }
        
    }
    

}