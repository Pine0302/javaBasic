/**
 * 笔记本电脑 鼠标 键盘 USB
 * 笔记本电脑使用USB接口 兼容各种外设 
 * 鼠标键盘等外设实现USB接口 
 */

class DuotaiTest  {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Keybord keybord = new Keybord();
        NoteBook noteBookA = new NoteBook();
        noteBookA.useUsb(null);
        noteBookA.useUsb(mouse);
        noteBookA.useUsb(keybord);
    }
}

interface USB{
    public void open();
    public void run();
    public void close();
}
class NoteBook 
{
    public void run()
    {
        System.out.println("noteook run");
    }

    public void useUsb(USB usb)
    {
        if(usb!=null){
            usb.open();
            usb.run();
            usb.close();
        }else{
            System.out.println("no usb device dected");
        }
        
    }
}

class Mouse implements USB
{
    public void open()
    {
        System.out.println("mouse open");
    }

    public void run()
    {
        System.out.println("mouse run");
    }

    public void close()
    {
        System.out.println("mouse close");
    }
}



class Keybord implements USB
{
    public void open()
    {
        System.out.println("keybord open");
    }

    public void run()
    {
        System.out.println("keybord run");
    }

    public void close()
    {
        System.out.println("keybord close");
    }
}


