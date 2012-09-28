package ObserverPattern;


public class Status implements CharacterObserver {
	private CharacterSubject characterSubject;
	private int level;
	private int hp;
	private int def;
	private int atk;
	private WeponData weponData;

	@Override
	public void update(int level, int hp, int def, int atk, WeponData weponData) {
		this.setLevel(level);
		this.setHp(hp);
		this.setDef(def);
		this.setAtk(atk);
		this.setWeponData(weponData);
	}
	
	public Status(CharacterSubject characterSubject) {
		this.characterSubject = characterSubject;
		characterSubject.registerObserver(this);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public WeponData getWeponData() {
		return weponData;
	}

	public void setWeponData(WeponData weponType) {
		this.weponData = weponType;
	}

}
