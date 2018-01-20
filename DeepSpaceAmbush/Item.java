
public class Item {

	//the items name
	private String name;
	
	//item attributes
	//may be sent to child classes
	private int damage;
	private int armor;
	
	public Item(String name, int damage, int armor) {
		this.name = name;
		this.damage = damage;
		this.armor = armor;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getArmor() {
		return armor;
	}
}
