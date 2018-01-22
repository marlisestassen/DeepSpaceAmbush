
public class ActionItem extends Item {

	private int damage;
	private int stamina;
	private int luck;

	
	public ActionItem(String name, int damage, int stamina, int luck, int health) {
		super(name);
		this.damage = damage;
		this.stamina = stamina;
		this.luck = luck;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getStamina() {
		return stamina;
	}
	
	public int getLuck() {
		return luck;
	}
	
}
