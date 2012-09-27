package ObserverPattern;

import java.util.ArrayList;

public class CharacterDataManager implements CharacterSubject {
	private ArrayList observers;
	private int level;
	private int hp;
	private int def;
	private int atk;
	private WeponData weponData;
	
	
	public CharacterDataManager() {
		observers = new ArrayList();
	}
	
	@Override
	public void registerObserver(CharacterObserver observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(CharacterObserver observer) {
		int rmIdx = observers.indexOf(observer);
		if(rmIdx >= 0) {
			observers.remove(rmIdx);
		}
	}

	@Override
	public void notifyObservers() {
		for(int i=0; i < observers.size(); i++) {
			((CharacterObserver)observers.get(i))
			.update(getLevel(), getHp(), getDef(), getAtk(), getWeponType());
		}
	}
	
	public void statusChanged() {
		notifyObservers();
	}
	
	public void setStatus(int level, int hp, int def, int atk, WeponData weponData) {
		this.setLevel(level);
		this.setHp(hp);
		this.setDef(def);
		this.setAtk(atk);
		this.setWeponData(weponData);
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

	public WeponData getWeponType() {
		return weponData;
	}

	public void setWeponData(WeponData weponData) {
		this.weponData = weponData;
	}

}
