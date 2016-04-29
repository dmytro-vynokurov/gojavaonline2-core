package com.goit.gojavaonline.core.codegym.addmod36;

import java.math.BigInteger;

public class Mod36Adder {

    public static final BigInteger C36 = BigInteger.valueOf(36);

    public String add(String a, String b) {
        BigInteger ad = toDecimal(a.toLowerCase());
        BigInteger bd = toDecimal(b.toLowerCase());
        BigInteger sum = ad.add(bd);
        return fromDecimal(sum);
    }

    public BigInteger toDecimal(String s){
        BigInteger result = new BigInteger("0");
        char[] chars = s.toCharArray();
        for(char c: chars){
            int diff = c>='0' && c<='9'
                    ? c-'0'
                    : c-'a'+10;
            result=result.multiply(C36).add(BigInteger.valueOf(diff));
        }
        return result;
    }

    public String fromDecimal(BigInteger i){
        StringBuilder sb = new StringBuilder();

        BigInteger n=i;
        while(n.compareTo(BigInteger.valueOf(0))>0){
            BigInteger modBI = n.mod(C36);
            int mod = modBI.intValue();
            char c = (char)(mod<=9
                    ? mod+'0'
                    : mod+'a'-10);
            sb.append(c);
            n=n.divide(C36);
        };

        return sb.reverse().toString();
    }
}
