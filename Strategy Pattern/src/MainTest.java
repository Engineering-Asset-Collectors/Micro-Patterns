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
		// 모형오리가 날수 있게 수정 할 수 있다.
		modelDuck.setFlyBehavior(new FlyWithWings());
		modelDuck.performFly();
	}
}
