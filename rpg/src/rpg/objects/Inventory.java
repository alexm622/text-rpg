package rpg.objects;

 
public abstract class Inventory{
    //private class
    
    
    private GenericItem[] items;

    //getters

	/**
	 * @return the items
	 */
	public GenericItem[] getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(GenericItem[] items) {
		this.items = items;
    }
}