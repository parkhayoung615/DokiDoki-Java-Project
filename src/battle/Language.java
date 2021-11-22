package battle;

public class Language{
	
	private String name;
	private int id;
	private int hp;
	private int maxHp;
	private Skill[] skills = new Skill[4];
	
	public Language(String name, int id, int hp, int maxhp, Skill[] skills) {
		this.name = name;
		this.id = id;
		this.hp = hp;
		this.skills = skills;
		this.maxHp = maxhp;
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Language() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Skill[] getSkills() {
		return skills;
	}

	public void setSkills(Skill[] skills) {
		this.skills = skills;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	
	
}
