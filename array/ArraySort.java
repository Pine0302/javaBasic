import java.lang.reflect.Array;
import java.util.Arrays;

class ArraySort {
    public static void main(String[] args) {
        int[] arr = { 21, 51, 451, 544, 852, 4, 71, 1015, 14, 147, 1895,1 };
        //sortBySelect(arr);
        //sortByBubble(arr);
        Arrays.sort(arr);
        printArr(arr);
    }


    /**
     * 选择排序
     * 在程序中，调用方法并且把数组的名称作为参数传递到方法中。
        本质上是传递数组的地址值。
        既然传递的是数组的地址，那么方法就可以通过数组的地址改变内存中数组的内容。
        类似于C语言中调用函数传递数组的指针一样。可以在函数中通过指针改变数组的内容。
        所以在JAVA当中，数组为引用类型，可以把数组作为参数传递到方法中去改变数组。
     * @param arr
     * @return
     */
    public static void sortBySelect(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[j] > arr[i]) {
                    swap(arr,i,j);
                }
            }
        }
    }

    /**
     * 冒泡排序法
     * @param arr
     */
    public static void sortByBubble(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }

    public static void swap(int[] arr ,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}