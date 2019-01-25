package rpg.objects.items;



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
        private Dmg damage;

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

        public Dmg getDamage() {
            return damage;
        }

        public void setDamage(Dmg damage) {
            this.damage = damage;
        }

        public static class Dmg extends rpg.objects.Attack{

        }
    }

}