package ObserverPattern;

public interface CharacterObserver {
	public void update(int level, int hp, int def, int atk, WeponData weponData);
}
