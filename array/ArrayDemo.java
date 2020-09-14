import java.lang.reflect.Array;

class ArrayDemo
{
    public static void main(String[] args){
        /**
         * 数组定义方式
         * 元素类型[] 数组名 = new 元素类型[元素个数/数组长度]
         * 好处：存储多个数据，可以对数据进行编号 从0开始，操作元素可以通过编号（索引）完成
         */
        int[] arr = new int[3]; //通过new 关键词创建了一个长度为3，元素类型为int 的数组实体
        int arrSame[] = new int[3]; //通过new 关键词创建了一个长度为3，元素类型为int 的数组实体
        //System.out.println(arr[3]); //访问到了数组不存在的索引时，会发生脚标越界异常
        //arr = null;
        //System.out.println(arr[0]);//当使用没有任何实体指向的引用变量操作实体时，运行会发生该异常
        System.out.println(arrSame[2]);

        //数组的定义格式2
        int[] arr2 = new int[]{1,2,3};
        int[] arr3 = {1,2,3};
        System.out.println(arr2[2]);
        System.out.println(arr3[2]);
        for(int x=0;x<arr.length;x++){
            System.out.println("arr2["+x+"]:"+arr2[x]);
        }  

        System.out.println("arr2的和是："+add(arr2));
    }

    //获取多个数的和的功能
    public static int add(int[] arr)
    {
        int total = 0;
        for(int x=0;x<arr.length;x++){
            total += arr[x];
        }   
        return total;
    }
}