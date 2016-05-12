package com.goit.gojavaonline.core.projecteuler.p022namesscores;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\dmytro\\IdeaProjects\\goit\\gojavaonline2-core\\src\\main\\resources\\p022_names.txt");
        try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
        ){
            String line = br.readLine();
            String[] wordsInQuotes = line.split(",");

            List<String> words = new ArrayList<>();
            for (String wordInQuotes : wordsInQuotes) {
                String word = wordInQuotes.substring(1, wordInQuotes.length() - 1);
                words.add(word);
            }

            Collections.sort(words);

            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                System.out.println(i + ":\t" + word +"\t"+countScore(word));
            }

            long result = 0;
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                int score = countScore(word);
                result += score * (i+1);
            }

            System.out.println(result);
        }
    }

    private static int countScore(String word){
        int result = 0;
        for (char c : word.toCharArray()) {
            result += c - 'A'+1;
        }
        return result;
    }
}
