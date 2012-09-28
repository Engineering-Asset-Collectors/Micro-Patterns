public class WeatherStation {
	public static void main(String[] args) {
		// 주제 객체 //
		WeatherData weatherData = new WeatherData();
		// 옵저버 객체 - 생성자를 통해 주제에 등록함 //
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);

		/*
		 * 주제가 가지고 있는 정보가 아래처럼 매번 변경된다고 가정하면,
		 * 옵저버들은 (이 예제에선 하나 뿐이지만)갱신된 값을 가지고
		 * 자신의 정보를 다시 다듬어 출력하게 된다.
		 */
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}

}
