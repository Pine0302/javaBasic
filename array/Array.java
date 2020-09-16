class Array {
    public static void main(String[] args) {
        int[][] arr = new int[3][2];
        System.out.println(arr);  //[[I@4dc63996   [[ : 二维数组   I：int  4dc63996：哈希值，记录二维数组的初始位置
        System.out.println(arr[0]);//[I@d716361
        System.out.println(arr[0][0]);

        int[][] arr1 = new int[3][];
        System.out.println(arr1);  //[[I@4dc63996  [[ : 二维数组   I：int  4dc63996：哈希值，记录二维数组的初始位置
        System.out.println(arr1[0]);//null  因为没有初始化二维数组中的一位数组的长度，所以为空
        System.out.println(arr1[0][0]);//java.lang.NullPointerException

        int[][] arr2 = {{13,11,14},{15,16,17,22},{25,27,29}};
    }


}