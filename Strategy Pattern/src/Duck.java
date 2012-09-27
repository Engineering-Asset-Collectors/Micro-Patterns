public abstract class Duck {
     
    IFlyBehavior iFlyBehavior;
    IQuackBehavior iQuackBehavior;
     
    public Duck(){
    }
     
    public abstract void display();
     
    public void performFly(){
        iFlyBehavior.fly();
    }
     
    public void performQuack(){
        iQuackBehavior.quack();
    }
     
    // ���� �ൿ ��ȭ
    public void setFlyBehavior(IFlyBehavior fb){
        iFlyBehavior = fb;
    }
     
    // �Ҹ� ��ȭ
    public void setQuackBehavior(IQuackBehavior fb){
        iQuackBehavior = fb;
    }
     
}