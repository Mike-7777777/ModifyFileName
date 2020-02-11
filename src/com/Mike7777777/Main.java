package com.Mike7777777;


import java.io.File;
import java.util.Scanner;

class Main{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please paste folder address here. " +
                "请输入文件夹地址");
        String address = sc.nextLine();
        File file = new java.io.File(address);
        File[] list = file.listFiles();
        System.out.println("Please choose the function you wanna use. " +
                "请选择你需要使用的模式");
        System.out.println("1. Delete all context after a customize key." +
                "删除一个自定义片段后的内容（用于解决大量文件下载99.99%后需要逐个改名的问题）\n" +
                "2. 删除一个自定义片段前的内容");
        String func = sc.nextLine();
        System.out.println("Enter the key here");
        String key = sc.nextLine();
        String freshName = "";

        assert list != null;
        for(int i = 0; i < list.length; i++){
            String name = list[i].getName();
            int type = name.indexOf(key);
            switch (func){
                case "1":
                    freshName = name.substring(0,type+4);
                    break;
                case "2":
                    int end = name.length() - 1;
                    freshName = name.substring(type+4,end);
            }

            File dest = new File(address+ "/" + freshName);
            if(list[i].exists()) {
                list[i].renameTo(dest);
            }else{
                System.out.println("Error");
            }

            System.out.println(dest.getName());
        }

    }
}