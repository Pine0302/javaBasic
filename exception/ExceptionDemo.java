/**
 *  异常
    Java运行时期发生的问题就是异常
    Java中运行时发生的除了异常Exception，还有错误Error。
    异常：通常发生是可以有针对性的处理方式的。
    错误：通常发生后不会有针对性的处理方式。
        Error的发生往往都是系统级别的问题，由Jvm所在的系统发生并反馈给jvm的
        无法针对处理，只能修正代码
        
 */
class ExceptionDemo {
    public static void main(String[] args) {
        int[] arr = new int[];
        System.out.println(arr[0]);
        System.out.println(arr[3]); //该句运行时发生了ArrayIndexOutOfBoundsException，导致程序无法继续执行。程序结束
        System.out.println("over");
    }
}
