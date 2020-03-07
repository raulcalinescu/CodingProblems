package Coding_Assesments.Amaz;

import DATA_STRUCTURES.HashTables.Solution;

import java.util.*;

public class Pb1 {

    public static ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
        {   ArrayList<String> topNToys = new ArrayList<>();
            if(numToys==0||numQuotes==0)    // data validation
                return topNToys;

            Map<String, Integer> toysMap = new HashMap<>();  // store the toys into a HashMap for future quick look-up
            for(String toy: toys) {                         // and occurrences count
                toysMap.put(toy, 0);
            }
            boolean differentQuote = false;
            for(String quote: quotes) {
                differentQuote = true;
                String[] list = quote.split(" ");   // create a reference into each string to split the sentence
                for(String word: list) {
                    if((word != null || word.length() > 0) && differentQuote) {
                        String lowerCaseWord = word.toLowerCase();
                        if(toysMap.containsKey(lowerCaseWord)) {   // increase number of occurrences if we find a match
                            toysMap.put(lowerCaseWord, toysMap.get(lowerCaseWord)+1);   // within the quotes
                            differentQuote = false;
                        }
                    }
                }
            }


            List<Map.Entry<String, Integer>> entryList= new ArrayList<>(toysMap.entrySet());

            Collections.sort(entryList, (a, b) -> (b.getValue() - a.getValue()) != 0 ? (b.getValue() - a.getValue()) :
                    a.getKey().compareTo(b.getKey())); // we sort the list from the most top common toy to the least top seen toy

           for(int i = 0; i < entryList.size() && topToys > 0; i++) {
                topToys--;                                      // keep track of how many toys we have left as we move them
                topNToys.add(entryList.get(i).getKey());        // add the String part of the Map entries to the ArrayList
            }                                                   // as required in the data type return definition of the method

            return topNToys;
        }

    public static void main(String[] args) {

    }
}
