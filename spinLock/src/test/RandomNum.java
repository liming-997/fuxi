package test;

import java.util.Random;

public class RandomNum {
    public static void main(String[] args) {

        String str="0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }

    public void get() {

    }
}
