package rpg.objects.items;

import rpg.objects.Item;

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

        public static class Dmg {
            private int dieamt;
            private int dietype;
            private String die;

            public void setDie(String die) {
                this.die = die;
                SplitToDie(die);
            }

            private void SplitToDie(String die) {
                String s = die;
                String[] ss = s.split("d", 2);
                this.dieamt = Integer.parseInt(ss[0]);
                this.dietype = Integer.parseInt(ss[1]);
            }

            private String getDie() {
                return this.die;
            }

            public int getDieamt() {
                return dieamt;
            }

            public void setDieamt(int dieamt) {
                this.dieamt = dieamt;
            }

            public int getDietype() {
                return dietype;
            }

            public void setDietype(int dietype) {
                this.dietype = dietype;
            }
        }
    }

}