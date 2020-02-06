package us.mattgreen;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        String line;
        String[] words;
        int usedOnce = 0;

        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]","")
                    .toLowerCase().trim();
           
            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }
            
            // Split string over one or more spaces
            words = line.split(" +");
            
            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                }
                else {
                    // Increment count using word as key
                    map.put(word, map.get(word) + 1);
                }

            }

            // Loop over entries in the map, getting each key/value pair

            //System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                usedOnce += 1;
            }
            if(entry.getValue() > 600){
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
        System.out.println("There are " + usedOnce + " used once.");
    }
    
}