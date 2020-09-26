
/**
 * Object类中常用的方法
 * Object 类时所有类的根类，定义了所有对象都具备的功能。
 * API(应用接口)
 */


class Person extends Object  {
    private int age;
    Person(int age){
        this.age = age;
    }
    //判断是否是同龄人。这个方法也是在比较两个person对象是否相等。
    //注意：person类中是否有比较两个对象相等的方法？有的！因为继承Object，它本身就具备着equals方法
    //既然有，还需要定义compare方法吗？不需要。
    //但是，equals方法判断的是地址，不是我们需要的内容，咋办？
    //继续使用object的equals 方法，但是建立子类自己的内容。这就是重写
    /*
    public boolean compare(Person p){
        return this.age == p.age;
    }
    */
    //重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！,所以用Object
    //【记住。以后判断对象是否相同，就需要覆盖equals方法】
    public boolean equals(Object obj){  
        //建立person自己的判断相同的依据,判断年龄是否相同
        //return this.age = obj.age; //obj 所属类型Object Object中没有定义age，所以编译失败
        if(this == obj)
            return true;
        //age 是person类型的属性。既然要用到子类型的你日工，需要向下 转型
        if(!(obj instanceof Person))
            throw new ClassCastException("what fuck are you cast in?");
        Person p = (Person) obj;
        return this.age == p.age;
     }


     //覆盖toString方法，建立Person对象自己的字符串表现形式
     public String toString(){
        return "Person[age="+age+"]";
     }

}

class Dog{

}

class ObjectDemo  {
    public static void main(String[] args) {
        Person p1 = new Person(12);
        Person p2 = new Person(12);
        Dog d1 = new Dog();
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        //System.out.println(p1.equals(d1));

        //-------------------------------------
        System.out.println(p1); //Person@6ff3c5b5
        System.out.println(p1.toString()); //Person@6ff3c5b5
        System.out.println(p2); //Person@6ff3c5b5
        //想要定义自定义对象的
    }
}




