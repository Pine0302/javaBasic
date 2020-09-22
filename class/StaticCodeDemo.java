class StaticCodeDemo {
    public static void main(String[] args) {
       Demo.show();
       Demo.show();
    }
}

class Demo
{
    static int x = 9;  //静态变量有两次初始化，一次默认初始化（int=>0），一次显示初始化
    static             //静态代码块，在静态变量显示初始化之后执行
    {
        System.out.println("类一加载就执行的部分..."+x); 
    }
    static void show(){
        System.out.println("show run");
    }

}
