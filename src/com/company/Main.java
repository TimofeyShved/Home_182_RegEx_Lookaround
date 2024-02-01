package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //Pattern p1 = Pattern.compile("q(?=u)"); // нужна буква "u", найдет если будет Iraqu
        Pattern p1 = Pattern.compile("q(?!u)"); // не нужна буква "u", найдет если будет Iraq
        Matcher m1 = p1.matcher("Iraq");
        while (m1.find()){
            System.out.println(m1.start() +" "+ m1.group()+" ");
        }


        Pattern p2 = Pattern.compile("(?<!a)b"); // если любой символ перед "b", не "а"
        Matcher m2 = p1.matcher("cb");
        while (m2.find()){
            System.out.println(m2.start() +" "+ m2.group()+" ");
        }

        //Pattern p3 = Pattern.compile("\\b\\w+(?<!s)\\b"); //найдет слово "John" до символа "s"
        //Pattern p3 = Pattern.compile("\\b\\w+[^s]\\b"); //найдет слово "John'" до символа "s"
        Pattern p3 = Pattern.compile("\\b\\w*[^s\\w]\\b"); // тоже самое, но любой символ после, но только не "s"
        Matcher m3 = p3.matcher("John's");
        while (m3.find()){
            System.out.println(m3.start() +" "+ m3.group()+" ");
        }
    }
}
