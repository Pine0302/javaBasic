import java.lang.reflect.Array;

class ArrayToString
{
    public static void main(String[] args){
        int[] arr = {2,51,451,544,852,45,71};
        String str = getStringFromArray(arr);
        System.out.println(str);
    }
    public static String getStringFromArray(int[] arr){
        String strFromArr = "[";
        for(int x=1;x<arr.length;x++){
            if(x!=arr.length-1){
                strFromArr = strFromArr + arr[x]+ ",";
            }else{
                strFromArr = strFromArr + arr[x];
            }
        }   
        strFromArr += "]";
        return strFromArr;
    } 



   
}