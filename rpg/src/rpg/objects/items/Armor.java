package rpg.objects.items;

public class Armor {
	private Item[] items;

	public Item[] getItems() {
		return this.items;
	}

	public void setItem(Item[] items) {
		this.items = items;
	}

	public static class Item extends rpg.objects.Item {
		private int armorclass;
		private int armortype;
		private int maxdex;

		public int getArmorclass() {
			return this.armorclass;
		}

		public void setArmorclass(int armorclass) {
			this.armorclass = armorclass;
		}

		public int getArmortype() {
			return this.armortype;
		}

		public void setArmortype(int armortype) {
			this.armortype = armortype;
		}

		public int getMaxdex() {
			return this.maxdex;
		}

		public void setMaxdex(int maxdex) {
			this.maxdex = maxdex;
		}

	}
}
