/**
 *  异常
ArrayIndexOutOfBoundsException对象
        
 */
class Demo{

    int getElement(int[] arr,int index)
    {
        /**
          Jvm出了问题,自己打包对象并输出.
          但是它所提供的信息不够给力,想要更清晰,需要自己写
          他的抛出不满足我们的要求,准备自己抛.
         */
        if (arr == null) {
            throw new NullPointerException("arr 指向的数据不存在");
        }
        if (index < 0 || index >= arr.length) {
            //该条件如果满足,功能已经无法继续运算,这时,就必须结束功能,并将问题告知给调用者.这时需要通过异常来解决
            //怎么用呢?
            //1.创建一个异常对象,封装一些提示信息(自定义)
            //2.需要将这个对象告知给调用者,怎么将这个对象传递到调用者处呢?通过关键字throw就可以完成. throw 异常对象
            //3.throw 用在函数内,抛出来异常对象并可以结束对象
            throw new ArrayIndexOutOfBoundsException("错误的角标, "+index+"索引在数组中不存在");
        }
        int element = arr[index];
        return element;
    }
}
class ExceptionDemo3 {
    public static void main(String[] args) {
        Demo d = new Demo();
        int[] arr = {34,97,74};
        int num = d.getElement(arr, 4);
        System.out.println("num = "+ num);
        System.out.println("over");
    }
}

