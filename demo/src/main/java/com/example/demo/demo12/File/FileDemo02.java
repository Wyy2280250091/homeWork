package com.example.demo.demo12.File;

/**
 * getPath()
 *           将此抽象路径名转换为一个路径名字符串
 * length()
 *           返回由此抽象路径名表示的文件的长度。
 * getName()
 *           返回由此抽象路径名表示的文件或目录的名称。
 *  getAbsolutePath()
 *           返回此抽象路径名的绝对路径名字符串。
 *
 * isDirectory()
 *           测试此抽象路径名表示的文件是否是一个目录
 *isFile()
 *           测试此抽象路径名表示的文件是否是一个标准文件
 *
 * mkdir()
 *           创建此抽象路径名指定的目录。
 *delete()
 *           删除此抽象路径名表示的文件或目录。回收站没有 直接从硬盘删除
 *list()
 *           返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
 *
 *
 *
 *
 *
 */
public class FileDemo02 {
    public static void main(String[] args) {
        show01();
    }

    private static void show01() {
        File file = new File("");
    }
}
