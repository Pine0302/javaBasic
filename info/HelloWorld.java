import jdk.dynalink.beans.StaticClass;

public class HelloWorld{
    public static void main(String[] args){
        System.out.println("\"你好，世界！\"");
        int c = add(3,4);
        System.out.println(c);
    }

    public static int add(int a,int b)
    {
        return a+b;
    }

    public static int add(int a,int b,int c)
    {
        return a+b+c;
    }
}

