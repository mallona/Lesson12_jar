package com.company;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        InputStream getString = Main.class.getResourceAsStream("/InputText.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(getString));
        String randomText = reader.readLine();
        reader.close();

        System.out.println("Original text from InputText.txt: " + randomText);


        StringBuilder builder = new StringBuilder();
        boolean dot = true;

        for (int i = 0; i < randomText.length(); i++) {
            char ch = randomText.charAt(i);

            if (ch == '.') {
                dot = true;

            } else if (dot && Character.isAlphabetic(ch)) {
                ch = Character.toUpperCase(ch);
                dot = false;
            }
            builder.append(ch);
        }

        randomText = builder.toString();
        String noSpaces = randomText.replaceAll("\\pP", "");
        String[] words = noSpaces.split(" ");
        //System.out.println("Split text: " + Arrays.toString(words));

        String newText = String.join(" ", words);
        System.out.println("Modified sentence in OutputText.txt which placed by the same path as .jar: " + newText);

        OutputStream out = new FileOutputStream("OutputText.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        writer.write(newText);
        writer.close();
    }
        
}



