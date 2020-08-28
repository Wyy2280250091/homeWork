package com.example.demo.demo01;

public class DemoMain {

    public static void main(String[] args) {
        //创建笔记本电脑

        Computer computer = new Computer();

        computer.powerOn();
        //准备一个鼠标
        //Mouse mouse = new Mouse();
        //向上转型 左父右子
        USB usbMouse = new Mouse();
        //参数是USB类型 传递USB类型进入
        computer.useDevice(usbMouse);

        //创建一个USB键盘
        Keyboard keyboard = new Keyboard();//没有使用多态
        //方法参数是USB类型传递进去的是实现了对象
        //computer.useDevice(new Keyboard());
        computer.useDevice(keyboard);

        computer.powerOff();

        System.out.println("===========================");


        //都是正确写法 int-->double基本类型自动类型转换
        method(10.0);
        method(5);
        int a = 3;
        method(a);
    }

    public static void  method(double num){
        System.out.println(num);
    }


}
