import java.util.Random;

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
	private ActionItem actionItem;
	private DefenseItem defenseItem;
	
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
	
	//Return hero's type
	//not sure if higher levels of program will be able to access this enumerated type
	public affiliation getTeam(){
		return team;
	}
	
	public String getTeamAsString() {
		if(team == affiliation.Crew) return "Crew";
		else if (team == affiliation.Pirate) return "Pirate";
		else return "Unknown";
	}
	
	//Return the Hero's status (health, strength, stamina, luck)
	public int[] getStatus() {
		return new int[]{health, strength, stamina, luck};
	}
	
	//
	public void setActionItem(ActionItem actionItem) {
		this.actionItem = actionItem;
	}
	
	public void setDefenseItem(DefenseItem defenseItem) {
		this.defenseItem = defenseItem;
	}
	
	public int attack(){
		int crit = 1; //crit represent critical hit
		stamina = stamina-(strength/2); //degrade stamina on hit
		if(actionItem != null) {
			if (new Random().nextInt(10) <= (luck+actionItem.getLuck())-1 & type != heroType.Sniper) crit = 2; //luck of 1 has 1/10 to be true
			return ((strength*(stamina/2))+actionItem.getDamage())*crit; //attack strength is function of stamina, 
																	//strength, item, and critical chance
		}
		else {
			if (new Random().nextInt(10) <= luck-1) crit = 2; //luck of 1 has 1/10 to be true
			return ((strength*(stamina/2))*crit);
		}
	}
	
	public int defend(int dmg){
		int crit = 1; 
		if(defenseItem != null) {
			if (new Random().nextInt(10) <= (luck+actionItem.getLuck())-1 & type != heroType.Engineer) crit = 2; //luck of 1 has 1/10 to be true
			health = health - ((dmg-defenseItem.getArmor())/crit);
		}
		else {
			if (new Random().nextInt(10) <= (luck+actionItem.getLuck())-1 & type != heroType.Engineer) crit = 2; //luck of 1 has 1/10 to be true
			health = health - dmg;
		}
		
		return health;
	}
	
	public int heal(){
		int crit = 1; //crit represent critical hit
		int critLuck = 0;
		if(actionItem != null) critLuck = actionItem.getLuck();
		stamina = stamina-(strength/2); //degrade stamina on hit
		if(defenseItem != null) {
			if (new Random().nextInt(10) <= (luck+critLuck)-1 & type != heroType.Sniper) crit = 2; //luck of 1 has 1/10 to be true
			return (((strength*(stamina/2))+defenseItem.getHealth())*crit); //attack strength is function of stamina, 
																	//strength, item, and critical chance
		}
		else {
			if (new Random().nextInt(10) <= (luck=critLuck)-1) crit = 2; //luck of 1 has 1/10 to be true
			return ((strength*(stamina/2))*crit);
		}
	}
	
	public void restoreStamina() {
		if(actionItem != null) {
			stamina = stamina + (health/2)+actionItem.getStamina();
		}
		else stamina = stamina + (health/2);
	}
	
	public void restoreHealth() {
		if(defenseItem != null) {
			health = health+defenseItem.getHealth();
		}
	}
		
}
