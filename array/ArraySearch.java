class ArraySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 14, 21, 51, 71, 147, 451, 544, 852, 1015,1085 };
        int num = 852;
        int numKey = binarySearch(arr, num);
        System.out.println(numKey);
    }

    /**
     * 二分法查找，适合已排序的数组
     * @param arr
     * @param num
     */
    public static int binarySearch(int[] arr, int num) {
        int min = 0;
        int max = arr.length - 1;
        int mid;
        while(max >= min){
            mid = (max+min) >> 1;
            if(arr[mid]==num){
                return mid;
            }else{
                if(arr[mid]>num){
                    max = mid-1;
                }else{
                    min = mid+1;    
                }
            }
        }
        return -1;
    }

}