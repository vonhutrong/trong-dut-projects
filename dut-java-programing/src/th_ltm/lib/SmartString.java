package th_ltm.lib;

import trong.net.IStringProcessing;

public class SmartString implements IStringProcessing {

	@Override
	public String process(String string) {
		if (string == null)
			return null;
		String uppercaseString = string.toUpperCase();
		String lowercaseString = string.toLowerCase();
		int numOfWords = SmartString.countWords(string);
		return uppercaseString + "\n" + lowercaseString + "\n" + numOfWords;
	}

	public static int countWords(String s){
	
	    int wordCount = 0;
	
	    boolean word = false;
	    int endOfLine = s.length() - 1;
	
	    for (int i = 0; i < s.length(); i++) {
	        // if the char is a letter, word = true.
	        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
	            word = true;
	            // if char isn't a letter and there have been letters before,
	            // counter goes up.
	        } else if (!Character.isLetter(s.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	            // last word of String; if it doesn't end with a non letter, it
	            // wouldn't count without this.
	        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
	    return wordCount;
	}

}
