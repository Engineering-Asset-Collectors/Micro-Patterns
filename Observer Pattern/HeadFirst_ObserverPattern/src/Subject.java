
public interface Subject {
	public void registerObserver(Observer observer);	//옵저버를 등록합니다.
	public void removeObserver(Observer observer);		//옵저버를 제거합니다.
	/*주제 객체의 상태가 변경되었을 때,
	 * 모든 옵저버들한테 알리기 위해
	 * 호출되는 메소드입니다.*/
	public void notifyObservers();
}
