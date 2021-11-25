package com.edyoda.classroom;
import java.util.*;
public class OctalNumber {
    static void createMap(Map<String, Character> um)
    {
        um.put("000", '0');
        um.put("001", '1');
        um.put("010", '2');
        um.put("011", '3');
        um.put("100", '4');
        um.put("101", '5');
        um.put("110", '6');
        um.put("111", '7');
    }

    // Function to find octal equivalent of binary
    static String convertBinToOct(String bin)
    {
        int l = bin.length();
        int t = bin.indexOf('.');

        // Length of string before '.'
        int len_left = t != -1 ? t : l;

        // Add min 0's in the beginning to make
        // left substring length divisible by 3
        for(int i = 1;
            i <= (3 - len_left % 3) % 3;
            i++)
            bin = '0' + bin;

        // If decimal point exists
        if (t != -1)
        {

            // Length of string after '.'
            int len_right = l - len_left - 1;

            // add min 0's in the end to make right
            // substring length divisible by 3
            for(int i = 1;
                i <= (3 - len_right % 3) % 3;
                i++)
                bin = bin + '0';
        }

        // Create map between binary and its
        // equivalent octal code
        Map<String,
                Character> bin_oct_map = new HashMap<String,
                Character>();
        createMap(bin_oct_map);

        int i = 0;
        String octal = "";

        while (true)
        {

            // One by one extract from left, substring
            // of size 3 and add its octal code
            octal += bin_oct_map.get(
                    bin.substring(i, i + 3));
            i += 3;

            if (i == bin.length())
                break;

            // If '.' is encountered add it to result
            if (bin.charAt(i) == '.')
            {
                octal += '.';
                i++;
            }
        }

        // Required octal number
        return octal;
    }

    // Driver code
    public static void main(String[] args)
    {
        String bin = "1111001010010100001.010110110011011";
        System.out.println("Octal number = " +
                convertBinToOct(bin));
    }
}
