/**
 *  异常
自己定义异常        
 */

 /**
  * 自定义异常,描述Persoon的年龄数值非法
  只要是本项目的Persoon的年龄出现非法值就会发生该异常
  */


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
    Person(String name ,int age){
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
class ExceptionDemo4 {
    public static void main(String[] args) {
        Person p = new Person("xiaoming", -20);
        System.out.println("qq");
    }
}

