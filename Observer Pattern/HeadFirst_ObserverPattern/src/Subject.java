
public interface Subject {
	public void registerObserver(Observer observer);	//�������� ����մϴ�.
	public void removeObserver(Observer observer);		//�������� �����մϴ�.
	/*���� ��ü�� ���°� ����Ǿ��� ��,
	 * ��� ������������ �˸��� ����
	 * ȣ��Ǵ� �޼ҵ��Դϴ�.*/
	public void notifyObservers();
}
