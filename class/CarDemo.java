class CarDemo {
    public static void main(String[] args) {
        Car c = new Car();
        c.color="red";
        c.num = 4;
        c.run();

        Car c1 = new Car();
        c1.color = "black";
        c1.num = 6;
        c1.run();
    }
}

class Car
{
    String color; //车子颜色
    int num;     // 轮胎数量
    void run()
    {
        System.out.println("the car is running, it's color is "+color+" and is has "+num+" tyre");
    }

}
