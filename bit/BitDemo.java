import java.lang.reflect.Array;

class BitDemo {
    public static void main(String[] args) {
        int number = 26;
        String hexString;
        String hexStringByArr;
        String binaryString;

        //单独处理
        hexString = decimalToHexadecimal(number);
        hexStringByArr = decimalToHexadecimalByArr(number);
        binaryString = decimalToBinary(number);
        System.out.println(hexString);
        System.out.println(hexStringByArr);
        System.out.println(binaryString);

         //统一处理
        String transHexString = transToHex(number);
        String transOctString = transToOct(number);
        String transBinaryString = transToBinary(number);
        System.out.println(transHexString);
        System.out.println(transOctString);
        System.out.println(transBinaryString);


        //函数法
        System.out.println(Integer.toBinaryString(number));
        System.out.println(Integer.toOctalString(number));
        System.out.println(Integer.toHexString(number));




    }

    // 十进制转16进制
    public static String decimalToHexadecimal(int number) {
        int temp = 15;
        char[] numChar = new char[8];
        int index = numChar.length;
        while (number != 0) {
            index--;
            int nu = number & temp;
            if (nu > 9) {
                numChar[index] = (char) (nu - 10 + 'a');
            } else {
                numChar[index] = (char) (nu + '0');
            }
            number = number >>> 4;
        }
        return "0X" + toString(numChar, index);
    }

    // 十进制转16进制 制表法
    public static String decimalToHexadecimalByArr(int number) {
        int temp = 15;
        char[] numHex = new char[] { 
            '0', '1', '2', '3', 
            '4', '5', '6', '7', 
            '8', '9', 'A', 'B', 
            'C', 'D', 'E', 'F' 
        };
        char[] numChar = new char[8];
        int index = numChar.length;
        while (number != 0) {
            index--;
            int nu = number & temp;
            number = number >>> 4;
            numChar[index] = numHex[nu];
        }
        return "0X" + toString(numChar, index);
    }

    // 十进制转2进制
    public static String decimalToBinary(int number) {
        int temp = 1;
        int[] numChar = new int[32];
        int index = numChar.length;
        while (number != 0) {
            index--;
            int nu = number & temp;
            numChar[index] = nu;
            number = number >>> 1;
        }
        return "0B" + toString(numChar, index);
    }

    public static String toString(char[] arr, int index) {
        String s = "";
        for (int i = index; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }

    public static String toString(int[] arr, int index) {
        String s = "";
        for (int i = index; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }

    public static String transToHex(int number) {
        String s = trans(number, 15, 4);
        return "0x" + s;
    }

    public static String transToBinary(int number) {
        String s = trans(number, 1, 1);
        return s;
    }

    public static String transToOct(int number) {
        String s = trans(number, 7, 3);
        return "oct" + s;
    }

    // 十进制转 2 8 16 进制通用方法
    /**
     * @param number 十进制数
     * @param base   与的基数
     * @param offset 偏移量
     * @return
     */
    public static String trans(int number, int base, int offset) {
        char[] numHex = new char[] { 
            '0', '1', '2', '3', 
            '4', '5', '6', '7', 
            '8', '9', 'A', 'B', 
            'C', 'D', 'E', 'F' 
        };
        char[] numChar = new char[32];
        int index = numChar.length;
        while (number != 0) {
            index--;
            int nu = number & base;
            number = number >>> offset;
            numChar[index] = numHex[nu];
        }
        return toString(numChar, index);
    }

}