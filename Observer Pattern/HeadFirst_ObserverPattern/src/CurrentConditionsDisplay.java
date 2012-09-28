/*WeatherData 객체로부터 변경사항을 받기위해서 Observer를 구현합니다.
 API 구조상 모든 디스플레이 항목에서 DisplayElement를 구현하기로
 했기 때문에 이 인터페이스도 구현합니다.*/

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private Subject weatherData;
	private float temperature;
	private float humidity;

	/*생성자에 weatherData라는 주제 객체가 전달되며,
	 * 그 객체를 써서 디스플레이를 옵저버로 등록합니다,*/
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out.println("Current conditions : " + temperature
				+ " F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
}
