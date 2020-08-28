package com.example.demo.demo12.File;

/**
 * 对文件点增删改查 遍历
 * file:文件
 * directory:文件夹、目录
 * path：路径
 *
 * 路径不区分大小写
 *
 */
public class File {


    public File(String s) {

    }

    public File(String parent, String child) {

    }

    public static void main(String[] args) {

        //file类的构造方法
        show01();
        show02("c","a.txt");
    }

    /**
     * 把文件分成俩部分
     * String parent:父路径
     * String child:子路径
     * @param parent
     * @param child
     */
    private static void show02(String parent, String child) {
        File file = new File(parent, child);
        System.out.println(file);
    }

    private static void show01() {
        File f = new File("C:\\Users\\zrfw\\Desktop\\repositorys\\testFile");
        System.out.println(f);//重写toString
    }
}

