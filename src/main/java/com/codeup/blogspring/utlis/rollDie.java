package com.codeup.blogspring.utlis;

import java.util.ArrayList;
import java.util.List;

public class rollDie {

    public static int roll6(){
        return (int)((Math.random() * ((6 - 1) + 1)) + 1);
    }

    public static List<Integer> rollArr() {
        List<Integer> results = new ArrayList<>();
        int i = 0;
        while (i < 6) {
            results.add(roll6());
            i++;
        }

        return results;
    }
}
