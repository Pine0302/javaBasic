package mypack;//包名中的所有的字母都小写。

/*
对于多个类为了便于管理(类的同名情况),所以java提供了一个解决方案。
包机制：落实到操作系统上，就是文件夹。对Java的文件进行分文件夹管理。

包的作用：
	1，对类文件进行管理。
	2，给类文件提供了名称空间。

包的定义：使用关键字 package。

对带有package定义的java文件进行指定类文件位置的编译方式。
javac -d 目录 源文件

如果目录选择的不是当前目录。想要访问包中类。
windows: 通过设置classpath。  set classpath=包所在的父目录 
mac :  export CLASSPATH=/Volumes/Work/java_project/java_basic/runtime


-------------
包与包之间访问：
PackageDemo.java:25: 错误: 找不到符号
                DemoA d = new DemoA();
                ^
  符号:   类 DemoA
  位置: 类 PackageDemo
PackageDemo.java:25: 错误: 找不到符号
                DemoA d = new DemoA();
                              ^
  符号:   类 DemoA
  位置: 类 PackageDemo
2 个错误

原因：类名写错。有了包的类，类名：包名.类名，这才是类的全名称。
解决：使用DemoA，必须写packa.DemoA


==============
PackageDemo.java:46: 错误: 程序包packa不存在
                packa.DemoA d = new packa.DemoA();//
                     ^
PackageDemo.java:46: 错误: 程序包packa不存在
                packa.DemoA d = new packa.DemoA();//
                                         ^
2 个错误
原因；packa这个包没有找到，在当前目录下。
解决：应该告诉jvm这个程序包的位置。 set classpath。


===============
PackageDemo.java:55: 错误: DemoA在packa中不是公共的; 无法从外部程序包中对其进
访问
                packa.DemoA d = new packa.DemoA();//
                     ^
PackageDemo.java:55: 错误: DemoA在packa中不是公共的; 无法从外部程序包中对其进
访问
                packa.DemoA d = new packa.DemoA();//
                                         ^
2 个错误
原因：DemoA这个类在packa包中权限不够。
解决：提升DemoA权限。提升到public。


==============
PackageDemo.java:71: 错误: show()在DemoA中不是公共的; 无法从外部程序包中对其进
访问
                d.show();
                 ^
1 个错误

原因：show方法的权限不够。
解决：show用public修饰。


总结：
包与包之间的类在访问时，被访问的类以及成员都必须public修饰。

注意：被public修饰的类或者接口，所属的java文件名必须和类或者接口名称一致。

=========================================

包与包之间继承。父类可以给其他包中的子类提供一个特殊的权限 protected。只有继承为子类后，
就可以访问的权限。

			public	   protected      default       private
一个类中      ok			ok			ok				ok
一个包中      ok			ok			ok				
子类中        ok			ok          
不同包中	  ok

包与包之间访问只有两种权限可以用，public protected(该权限只能给不同包中的子类使用)。


================================================

包的出现，导致类的名称过长书写不方便，咋办？
可以通过指定的关键字解决：import ：导入。
import作用简化类名书写，省略包名。

特殊情况一：

packa\packaa\DemoAA.class
	 \DemoA.class
import packa.*;//明确类使用的类所属的包是packa。不会导入packa中子包中的类。
如果要使用DemoAA。
import packa.packaa.*;
new DemoAA();
特殊情况二：不同包中有了相同名称的类。使用该类时必须指定包名。

packa\Demo.class
packb\Demo.class

import packa.Demo;
import packb.Demo;

new packa.Demo();


*/
import packa.DemoA;//import packa.*;



class PackageDemo 
{
	public static void main(String[] args) 
	{
		//packa.DemoA d = new packa.DemoA();//
 		DemoA d = new DemoA();
		d.show();

		packf.DemoF d1 = new packf.DemoF();
		d1.showF();
		//d1.showPF();  packageDemo 没有继承DemoF，所以用不了这个protected方法
		System.out.println("Hello package!");
	}
}
