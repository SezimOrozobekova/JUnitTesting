package org.example;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        StringProcessor st = new StringProcessor();
        System.out.println(st.isStrongPassword("Sezim%62"));
        System.out.println(st.calculateDigits("1234"));
        System.out.println(st.calculateWords("sezim     raheba aruuke amira"));
        System.out.println(st.calculateExpression("(1+2)-1"));
    }


}