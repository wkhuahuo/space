package com.algorithm.leetcode;

/**
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
////////////////////////////////
 We start with trimming.

 If we see [0-9] we reset the number flags.
 We can only see . if we didn't see e or ..
 We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
 We can only see + and - in the beginning and after an e
 any other character break the validation.
 At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

 So basically the number should match this regular expression:

 [-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?

 * Created by wkhuahuo on 2017/3/15.
 */
public class ValidNumber65 {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean eseen = false;
        boolean pseen = false;
        boolean numafterE = true;
        boolean numseen = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {//看到了0到9
                numseen = true;
                numafterE = true;
            } else if (s.charAt(i) == '.') {
                if (pseen || eseen) {
                    return false;
                }
                eseen = true;
            } else if (s.charAt(i) == 'e') {
                if (eseen || !numseen) {
                    return false;
                }
                numafterE = false;
                eseen = true;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 || (i > 0 && s.charAt(i - 1) != 'e')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numseen && numafterE;
    }
     public boolean isNumber2(String s){
         try

        {
            s = s.trim();
            int n = s.length();
            if (n == 0 || (s.charAt(n - 1) != '.' && (s.charAt(n - 1) - '0' < 0 || s.charAt(n - 1) - '0' > 9))) {
                return false;
            }
            double i = Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
