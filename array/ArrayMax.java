import java.lang.reflect.Array;

class ArrayMax
{
    public static void main(String[] args){
        int[] arr = {2,51,451,544,852,45,71};
        int max = getMax(arr);
        int max2 = getMax_2(arr);
        System.out.println(max);
        System.out.println(max2);

    }

    //获取多个整数的最大值
    /**
     * 思路：
     * 1.数据对哦了为了便于操作，先存储起来，需要容器，用数组
     * 2.多个数据需要进行比较，每次都有较大的书，需要记录下来和下一个数比较
     * 3.将数组中的元素都比一遍，最后，就有了最大值
     * 步骤
     * 1.需要数组
     * 2.定义一个变量记录住较大的数。
     * 3.对数组进行遍历，让元素和较大的值进行比较，如果元素大于较大的数，用变量记录该元素
     * 4.遍历完成后，变量中记录就是最大值
     */
    public static int getMax(int[] arr)
    {
        //1.定义变量
        int max = arr[0]; 
        for(int x=1;x<arr.length;x++){
            if(arr[x]>max){
                max = arr[x];
            }
        }   
        return max;
    }

    public static int getMax_2(int[] arr){
        int max = 0;
        for(int x=1;x<arr.length;x++){
            if(arr[x]>arr[max]){
                max = x;
            }
        }   
        return arr[max];
    }
}