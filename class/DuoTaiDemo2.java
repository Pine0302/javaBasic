
/**
 * 编译的时候没有形成对象。运行的时候形成了对象
 * 多态中，成员调用的特点
 * 1.成员变量
        当子父类中出现同名的成员变量时。
            多态调用该变量时：
                编译时期：参考的是引用变量所属的类中是否有被调用的成员变量，没有，编译失败
                引用时期：也是调用引用变量所属的类中的成员变量
            简单记：编译和引用都参考等号左边的引用类型。    
 * 2.成员函数
        编译参考左边引用，如果没有，编译失败
        运行，参考右边对象所属的类
        对于成员函数是动态绑定到对象上
 * 3.静态函数
        编译和运行都访问左边
        对于静态函数，是静态的绑定到类上。
        注意：真正开发静态方法是不会被多态调用的，因为静态方法不属于对象，而是所属于类。
        正确的调用方式 Fu.method(); Zi.method();

    【结论】
    对于成员变量和静态函数，编译和运行都看左边
    对于成员函数，编译看左边，运行看右边
 */


class DuotaiDemo2  {
    public static void main(String[] args) {
        /*
        //测试成员变量的多态调用
        Fu f = new Zi();
        Zi z = new Zi();
        System.out.println(f.num);   //3
        System.out.println(z.num);   //5
        */

        //测试成员函数的多态调用
        /*
        Fu f = new Zi();
        Zi z = new Zi();
        f.show();    //zi show run
        z.show();    //zi show run
        */
        //测试静态函数的多态调用
        Fu f = new Zi(); 
        f.method();  //这个方法本身是静态的，没有形成对象，所以没有子类对象，调用了父类的method
    }
}

class Fu {
    int num = 3;
    void show()
    {
        System.out.println("fu show run..."+num); 
    }

    static void method()
    {
        System.out.println("fu static method run..."); 
    }
}

class Zi extends Fu {
    int num = 5;
    void show()
    {
        System.out.println("zi show run..."+num); 
    }
    static void method()
    {
        System.out.println("zi static method run..."); 
    }
}


