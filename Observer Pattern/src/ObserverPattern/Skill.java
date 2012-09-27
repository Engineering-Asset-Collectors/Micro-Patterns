package ObserverPattern;

import java.util.ArrayList;

public class Skill implements CharacterObserver {
	private WeponData weponData;
	private int level;
	private int hp;
	private int def;
	private int atk;
	private ArrayList<String> skillList;

	@Override
	public void update(int level, int hp, int def, int atk, WeponData weponData) {
		this.level = level;
		this.hp = hp;
		this.def = def;
		this.atk = atk;
		this.weponData = weponData;
		setSkillList(new ArrayList<String>());
		skillListSetting();
	}

	private void skillListSetting() {
		//각 무기별 타입에 맞는 스킬 세팅
	}

	public ArrayList<String> getSkillList() {
		return skillList;
	}

	public void setSkillList(ArrayList<String> skillList) {
		this.skillList = skillList;
	}

}
