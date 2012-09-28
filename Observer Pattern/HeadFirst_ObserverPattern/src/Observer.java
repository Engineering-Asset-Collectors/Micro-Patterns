/*
Observer 인터페이스는 모든 옵저버 클래스에서 구현해야 합니다. 
따라서 모든 옵저버는 update() 메소드를 구현해야 합니다.
여기에서는 옵저버한테 측정한 값들을 전달합니다.*/

public interface Observer {
	public void update(float temperature, float humidity, float pressure);
}
