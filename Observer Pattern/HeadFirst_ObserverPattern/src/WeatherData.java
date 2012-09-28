import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {
		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		/*
		 * ���¿� ���ؼ� ��� ������������ �˷��ִ� �κ��Դϴ�. ��� 
		 * Observer �������̽��� �����ϴ�, �� update()
		 * �޼ҵ尡 �ִ� ��ü���̹Ƿ� �ս��� �˷��� �� �ֽ��ϴ�.
		 */
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

}
