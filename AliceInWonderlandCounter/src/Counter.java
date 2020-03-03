
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Counter {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.gutenberg.org/files/11/11.txt");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        Scanner input = new Scanner(is);

        int words = 0;
        int c = 0;
        int cNS = 0;
        List<String> wordArray = new ArrayList<String>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            c += line.length();
            cNS += line.replace(" ", "").length();
            StringTokenizer tokens = new StringTokenizer(line);
            words += tokens.countTokens();
            String[] a = line.split(" ");
            int b = wordArray.size() + a.length;
                for(int ii = 0; ii < a.length; ii++ ){
                    wordArray.add(a[ii]);
                }
            }

        Map<String, Integer> wordMap = new HashMap<String, Integer>();
        for(String i: wordArray){
            Integer j = wordMap.get(i);
            wordMap.put(i,(j == null) ? 1 : j + 1);
            }

        for (Map.Entry<String, Integer> d : wordMap.entrySet()) {
            System.out.println("Word: " + "/" + d.getKey() + "/" + " " + "occurs:" + d.getValue() + " times");
        }
        System.out.println("With Space:" + c);
        System.out.println("No Space:" + cNS);
        System.out.println("Words:" + words);
     }
}

