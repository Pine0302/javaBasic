class MainDemo {
    public static void main(String[] args) {
       System.out.println(args);//[Ljava.lang.String;@4dc63996  //说明jvm传递了一个字符串类型的数组实体
       System.out.println(args.length);//0 jvm 传递的是 new String[0];
       System.out.println(args[0]);//java.lang.ArrayIndexOutOfBoundsException:
       // java MainDemo pine jack ->args.length = 2 ;args[0] = pine

    }
}

