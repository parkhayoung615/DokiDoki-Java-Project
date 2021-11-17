package battle;

public class Skill {
	private int id;
	private String name;
	private int dmg;
	public Skill(int id, String name, int dmg) {
		this.id = id;
		this.name = name;
		this.dmg = dmg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDmg() {
		return dmg;
	}
	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	
	
}
