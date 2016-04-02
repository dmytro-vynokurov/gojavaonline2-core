package com.goit.gojavaonline.core.codegym.unixpath;

import java.util.Deque;
import java.util.LinkedList;

public class UnixPathSimplifier {
    public String simplify(String input) {
        String[] split = input.split("/");

        Deque<String> resultParts = new LinkedList<>();
        for (int i = 0; i < split.length; i++) {
            String part = split[i];
            if(part.equals("..")) resultParts.pollLast();
            else if(!(part.equals("")||part.equals("."))) resultParts.add(part);
        }

        StringBuilder sb = new StringBuilder();
        for (String s : resultParts) {
            sb.append("/");
            sb.append(s);
        }

        String result = sb.toString();
        return result.equals("") ? "/" : result;
    }
}
