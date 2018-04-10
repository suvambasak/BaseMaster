package com.example.codebox.basemaster;

/**
 * Created by codebox on 7/2/17.
 */
public class Convert {

    //Decimal to all.
    public String decimalToBinary(String number){   return Integer.toBinaryString(Integer.parseInt(number));    }

    public String decimalToHexadecimal(String number){  return Integer.toHexString(Integer.parseInt(number));   }

    public String decimalToOctal(String number){    return Integer.toOctalString(Integer.parseInt(number)); }

    //Binary to all.
    public String binaryToOctal(String number){ return Integer.toOctalString(Integer.parseInt(number,2));   }

    public int binaryToDecimal(String number){  return Integer.parseInt(number,2);  }

    public String binaryToHexadecimal(String number){   return Integer.toHexString(Integer.parseInt(number,2)); }

    //Octal to all.
    public String octalToBinary(String number){ return Integer.toBinaryString(Integer.parseInt(number,8));  }

    public int octalToDecimal(String number){
        return Integer.parseInt(number,8);
    }

    public String octalToHexadecimal(String number){    return Integer.toHexString(Integer.parseInt(number,8)); }

    //Hexadecimal to all
    public String hexadecimalToBinary(String number){   return Integer.toBinaryString(Integer.parseInt(number,16)); }

    public String hexadecimalToOctal(String number){    return Integer.toOctalString(Integer.parseInt(number,16));  }

    public int hexadecimalToDecimal(String number){ return Integer.parseInt(number,16); }

}
