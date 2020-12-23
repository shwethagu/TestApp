package com.demo.testapp.Activity;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.demo.testapp.R;

import java.util.Arrays;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String input = "#EvenionS02Or@eve03";

        int result[];

        result = count(input);

        System.out.println(Arrays.toString(result));

    }

    public int[] count(String input) {

        int[] arr = new int[4];

        char[] charArray = input.toCharArray();

        for(int i=0; i < charArray.length; i++){
            if(Character.isUpperCase(charArray[i])){
                arr[0]++;
            }else if(Character.isLowerCase(charArray[i])){
                arr[1]++;
            }else if(Character.isDigit(charArray[i])){
                arr[2]++;
            }else{
                arr[3]++;
            }
        }

        return arr;
    }


}