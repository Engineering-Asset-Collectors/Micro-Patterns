public class WeatherStation {
	public static void main(String[] args) {
		// ���� ��ü //
		WeatherData weatherData = new WeatherData();
		// ������ ��ü - �����ڸ� ���� ������ ����� //
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
				weatherData);

		/*
		 * ������ ������ �ִ� ������ �Ʒ�ó�� �Ź� ����ȴٰ� �����ϸ�,
		 * ���������� (�� �������� �ϳ� ��������)���ŵ� ���� ������
		 * �ڽ��� ������ �ٽ� �ٵ�� ����ϰ� �ȴ�.
		 */
		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}

}
