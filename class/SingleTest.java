class SingleTest {
    public static void main(String[] args) {
        //超人对象是唯一的。保证superman的唯一性，可以使用单例模式解决问题
        // Superman man = new Superman("kelake");
        Superman man1 = Superman.getInstance();
        Superman man2 = Superman.getInstance();
        man1.setName("hero"); //同一个人改名
        man2.fly();
    }
}

// 饿汉式单例模式
class Superman {

    private String name;
    private static Superman man = new Superman("kelake");
    public static Superman getInstance(){
        return man;
    }
    Superman(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void fly(){
        System.out.println(this.name + " fly ");
    }
   
}
