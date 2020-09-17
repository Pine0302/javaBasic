class Person {
    private String name;
    private int age;

    private Person(String name){
        this.name = name;
    }

    Person(String name, int age) {
        //name = name;
        this(name); //调用一个字符串参数的构造函数
        this.age = age;
    }

    public void speak() {
        System.out.println("name=" + name + ",age=" + age);
    }

    public boolean equalAge(Person pp){
        return pp.age == this.age;
    }
}

class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person("li Ming", 20);
        p.speak();
    }

}
