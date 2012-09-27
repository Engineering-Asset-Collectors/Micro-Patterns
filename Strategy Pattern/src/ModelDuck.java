
public class ModelDuck extends Duck {

	public ModelDuck(){
		iFlyBehavior = new NoFly();
		iQuackBehavior = new Quack();
	}
	public void display() {
		System.out.println("모형오리");
	}

}
