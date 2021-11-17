package battle;

public class Language{
	
	private int id;
	private int hp;
	private Skill[] skills = new Skill[4];
	
	public Language(int id, int hp, Skill[] skills) {
		this.id = id;
		this.hp = hp;
		this.skills = skills;
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
	
	
}
