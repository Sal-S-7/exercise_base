package org.example.exerciceBaseJava;

import java.util.Arrays;

public class Exercise95 {
    public static void main(String[] args) {
        int[] tableauSource = {-5, 3, 24, -12, -10, 5, 100, -2, -71, 0};
        int[] tableauDestination = new int[tableauSource.length];

        for (int i = 0; i < tableauSource.length;i++){
            if(tableauSource[i] >= 0){
            tableauDestination[i] = tableauSource[i];
        }
        }
        System.out.println(Arrays.toString(tableauDestination));
    }

        }

