/**
 *  异常
ArrayIndexOutOfBoundsException对象
        
 */
class Demo{

    /**
     * 对给定的数组通过给定的角标获取元素
     * @param arr
     * @param index
     * @return
     */
    int getElement(int[] arr,int index)
    {
        int element = arr[index];
        return element;
    }
}
class ExceptionDemo2 {
    public static void main(String[] args) {
        Demo d = new Demo();
        int[] arr = {34,97,74};
        int num = d.getElement(arr, 4);
        System.out.println("num = "+ num);
        System.out.println("over");
    }
}
