package com.goit.gojavaonline.core.codegym.breakline;

public class BreakLine {
    public String format(String input, int width) {


        String[] split = input.split("\\s");
        StringBuilder sb = new StringBuilder();
        int lastPartSize = 0;
        for(String word: split) {
            if (lastPartSize + word.length() + 1 > width) {
                sb.append("\n");
                sb.append(word);
                lastPartSize = word.length();
            } else {
                if(lastPartSize!=0)sb.append(" ");
                sb.append(word);
                lastPartSize += word.length() + 1;
            }
        }

        return sb.toString();


    }
}
