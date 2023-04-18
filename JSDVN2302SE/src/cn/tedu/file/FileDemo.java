package cn.tedu.file;


import java.io.File;

/**
 * TODO File綁定指定文件
 */
public class FileDemo {
    public static void main(String[] args) {

        /**
         * 訪問當前項目下demo目錄的demo.txt文件
         * 1. 選中文件右鍵後選擇 copy path->Absolute path
         * C:\Users\dinni\OneDrive\桌面\Java\JSDVN2302SE\demo\demo.txt
         * 一般不太用絕對路徑
         * 2. 相對路徑
         * 用./表示當前項目的目錄
         * ./就等同於C:\Users\dinni\OneDrive\桌面\Java\
         */

        File file = new File("./demo/demo.txt");//文件路徑
        // TODO 獲取原始文件的名字
        String name = file.getName();
        System.out.println("name = " + name);// .soutv

        //TODO 獲取文件的長度 內容是字符
        long length = file.length();
        System.out.println("length = " + length+"個字節");

    }
}
