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
        private Action damage;

        

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

        public Action getDamage() {
            return damage;
        }

        public void setDamage(Action damage) {
            this.damage = damage;
        }

    }
    public static class Action extends rpg.objects.combat.Action{
            
    }

}