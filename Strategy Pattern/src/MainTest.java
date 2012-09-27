public class MainTest {

	public static void main(String args[]) {
		Duck miniDuck = new MiniDuck();
		miniDuck.display();
		miniDuck.performFly();
		miniDuck.performQuack();

		System.out.println();

		Duck modelDuck = new ModelDuck();
		modelDuck.display();
		modelDuck.performFly();
		modelDuck.performQuack();
		// ���������� ���� �ְ� ���� �� �� �ִ�.
		modelDuck.setFlyBehavior(new FlyWithWings());
		modelDuck.performFly();
	}
}
