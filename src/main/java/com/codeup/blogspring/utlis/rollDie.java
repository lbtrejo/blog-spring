package com.codeup.blogspring.utlis;

public class rollDie {

    public static int roll6(){
        return (int)((Math.random() * ((6 - 1) + 1)) + 1);
    }
}
