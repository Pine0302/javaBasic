/**
 * 需求:公司中程序员有姓名，工号，薪水，工作内容
 * 项目经理除了有姓名，工号，薪水，还有奖金，工作内容
 * 对给出的需求进行数据建模
 * 
 * 发现员工的工作内容本身就不具体。应该是抽象的，有具体的子类来体现的
 */
abstract class Employee {
    private String name;
    private String id;
    private double salary;
    /**
     * 构造一个员工对象，一初始化就具有三个属性
     * @param name
     * @param id
     * @param salary
     */
    Employee(String name,String id,double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    /**
     * 工作行为
     */
    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

//程序员
class Programmer extends Employee {
    Programmer(String name,String id,double salary){
        super(name,id,salary);    
    }
    public void work(){
        System.out.println("code...");
    }
}

//经理
class Manager extends Employee {
    private double bonus;
    Manager(String name,String id,double salary,double bonus){
        super(name,id,salary);    
        this.bonus = bonus;
    }
    public void work(){
        System.out.println("manager...");
    }
}

class AbstractTest  {
   public static void main(String[] args) {
       System.out.println("hello world!");
   }
}