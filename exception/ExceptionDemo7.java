class NoAgeException extends RuntimeException{

    NoAgeException(){
        super();
    }
    NoAgeException(String message){
        super(message); //如果自定义异常需要异常信息,可以通过调用父类的带有字符串参数的构造函数即可
    }
}
class Person{

    private String name;
    private int age;
    /**
     * 构造函数到底抛出的这个 NoAgeException 到底是继承Exception 还是继承RuntimeException
      1、继承Exception，必须要throws声明。一声明就告知调用者进行捕获，一旦问题处理了调用者的程序就会继续执行
      但是如果使用到了Person对象的数据，代码都是失败的
      2、继承RuntimeException，不需要throws声明的，这时调用是不可能编写捕获代码的，因为调用者根本就不知道有问题，一旦发生noAgeException
    调用者程序会停掉，并由Jvm将信息显示到屏幕，让调用者看到问题，修正代码。
     * @param name
     * @param age
     */
    Person(String name ,int age) 
    {
        if(age<0||age>200){
            throw new NoAgeException(age+",年龄数值非法");
        }
        this.name = name;
        this.age = age;
    }
   
    @Override
    public String toString(){
        return "Person[name="+name+",age="+age+"]";
    }
}
class ExceptionDemo7 {
    public static void main(String[] args) {
        Person p = new Person("xiaoming", -20);
        System.out.println(p);
  
        System.out.println("over");
    }
}

