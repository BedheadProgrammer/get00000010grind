package guess_Word;


	import java.util.*;
// Do not question the implementation of Master, master.guess is a given object whose API will provided.
// This code; however, is complete
	class Solution {
	    public void findSecretWord(String[] words, Master master) {
	        int allowedGuesses = 10; // Adjust this value as needed
	        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
	        
	        for (int attempt = 0; attempt < allowedGuesses; attempt++) {
	            String guessWord = pickGuessWord(wordSet); // Pick a word from the remaining candidates
	            int matches = master.guess(guessWord); // Call the Master's guess method
	            if (matches == 6) { // If the guess is correct
	                System.out.println("You guessed the secret word correctly.");
	                return;
	            }
	            filterWords(guessWord, matches, wordSet); // Eliminate words based on matches
	        }
	        
	        // If the allowed guesses are exhausted
	        System.out.println("Either you took too many guesses, or you did not find the secret word.");
	    }
	    
	    
	    private String pickGuessWord(Set<String> wordSet) {
	        // Using QuickSort to pick the first word for simplicity
	        String[] wordsArray = wordSet.toArray(new String[0]);
	        quickSort(wordsArray, 0, wordsArray.length - 1);
	        return wordsArray[0];
	    }
	    
	    // QuickSort implementation
	    private void quickSort(String[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }
	    
	    // Partition function for QuickSort
	    private int partition(String[] arr, int low, int high) {
	        String pivot = arr[high];
	        int i = low - 1;
	        for (int j = low; j < high; j++) {
	            if (arr[j].compareTo(pivot) < 0) {
	                i++;
	                String temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        String temp = arr[i + 1];
	        arr[i + 1] = arr[high];
	        arr[high] = temp;
	        return i + 1;
	    }
	    
	    // Eliminate words based on matches
	    private void filterWords(String guessWord, int matches, Set<String> wordSet) {
	        if (matches == 0) {
	            System.out.println("Words that do not match:");
	            for (String word : wordSet) {
	                if (countMatches(guessWord, word) == 0) {
	                    System.out.println(word);
	                }
	            }
	        }
	        
	        Iterator<String> iterator = wordSet.iterator();
	        while (iterator.hasNext()) {
	            String word = iterator.next();
	            if (countMatches(guessWord, word) != matches) {
	                iterator.remove(); 
	            }
	        }
	    }
	    
	    // Count the number of matching characters between two words
	    private int countMatches(String word1, String word2) {
	        int count = 0;
	        for (int i = 0; i < word1.length(); i++) {
	            if (word1.charAt(i) == word2.charAt(i)) {
	                count++;
	            }
	        }
	        return count;
	    }
	}

	public class googleqs {
	    public static void main(String[] args) {
	        Solution solution = new Solution(); 
	        solution.findSecretWord(new String[]{"cbazz", "acckzz", "eiowzz", "abcczz", "ddddd"}, null);
	    }
	}

}
