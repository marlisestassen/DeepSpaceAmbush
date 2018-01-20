
public class Hero {
	
	//name
	private String name;
	
	//affiliation stat
	public enum affiliation{Crew, Pirate}
	private affiliation team;
	
	//hero's class
	//won't be instantiated until children classes
	public enum heroType{Brute, Medic, Sniper, Engineer}
	private heroType type;
	
	//power stats
	private int health, strength, stamina, luck;
	
	//items
	private Item actionItem;
	private Item defenseItem;
	
	public Hero(String name) {
		this.name = name;
	}
	
	public Hero(String name, int health, int strength, int stamina, int luck) {
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.stamina = stamina;
		this.luck = luck;
	}
	
	//Return the Hero's name
	public String getName() {
		return name;
	}
	
	//Return hero's type
	//not sure if higher levels of program will be able to access this enumerated type
	public heroType getType(){
		return type;
	}
	
	public String getTypeAsString() {
		if(type == heroType.Brute) return "Brute";
		else if (type == heroType.Medic) return "Medic";
		else if (type == heroType.Sniper) return "Sniper";
		else if (type == heroType.Engineer) return "Engineer";
		else return "Hero";
	}
	
	//Return the Hero's status (health, strength, stamina, luck)
	public int[] getStatus() {
		return new int[]{health, strength, stamina, luck};
	}
	
	//
	public void setActionItem(Item actionItem) {
		this.actionItem = actionItem;
	}
	
	public void setDefenseItem(Item defenseItem) {
		this.defenseItem = defenseItem;
	}
	
	public int attack(){
		stamina = stamina-(strength/2);
		if(actionItem != null) {
			return (strength*stamina)+actionItem.getDamage();
		}
		else return (strength*stamina);
	}
	
	public int defend(int dmg){
		if(defenseItem != null) {
			health = health - (dmg-defenseItem.getArmor());
		}
		else health = health - dmg;
		
		return health;
	}
	
}
