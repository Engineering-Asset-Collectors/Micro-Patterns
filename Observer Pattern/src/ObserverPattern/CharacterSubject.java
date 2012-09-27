package ObserverPattern;

public interface CharacterSubject {
	public void registerObserver(CharacterObserver observer);
	public void removeObserver(CharacterObserver observer);
	public void notifyObservers();
}
