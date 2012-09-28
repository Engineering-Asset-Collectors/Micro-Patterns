
public class MiniDuck extends Duck {

	public MiniDuck(){
		iFlyBehavior = new FlyWithWings();
		iQuackBehavior = new Quack();
	}
	public void display() {
		System.out.println("작은 오리");
	}

}
