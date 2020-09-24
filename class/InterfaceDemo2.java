class InterfaceDemo2  {
    public static void main(String[] args) {
        C c = new C();
        c.show();
    }
}
/**
 * 抽象类中是否可以不定义抽象方法
 * 可以的，原因仅是不让该类创建对象
 */

/**
 * 为了使用接口中的部分方法，而覆盖了全部方法，而且每一个子类都要这么做，复用性差
 * 将不用的方法都抽取到一个独立的类中，让这个类去实现接口，并覆盖接口中的所有方法
 * 这个类指导这些方法的具体实现内容吗？不知道。
 * 所以只能为了后期子类创建对象方便，而进行空实现。
 * 而这时，这个类创建对象有意义吗？没有意义。所以将这个类抽象化
 * 这就是没有抽象方法的抽象类
 */

interface Inter
{
    public void show1();
    public void show2();
    public void show3();
    public void show4();
}

abstract class InterImp implements Inter
{
    public void show1(){}
    public void show2(){}
    public void show3(){}
    public void show4(){}
}

class InterImp1 extends InterImp
{
    public void show1(){
        System.out.println("show 1");
    }
}

class InterImp2 extends InterImp
{
    public void show2(){
        System.out.println("show 2");
    }
}
