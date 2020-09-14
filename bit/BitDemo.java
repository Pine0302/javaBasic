import java.lang.reflect.Array;

class BitDemo
{
    public static void main(String[] args){
        int number = 999;
        String hexString;
        hexString = decimalToHexadecimal(number);
        System.out.println(hexString);
    }

    //十进制转16进制
    public static String decimalToHexadecimal(int number)
    {
        int temp = 15;
        String s = "";
        char numChar ;
        for(int i=0;i<8;i++){
            int nu =  number & temp;
            if(nu>9){
                numChar = (char)(nu-10+'a');
            }else{
                numChar = (char)(nu+48);
            }
            s = String.valueOf(numChar) + s;
            number = number >>> 4;
        }
        return "0X"+s;
    }


}