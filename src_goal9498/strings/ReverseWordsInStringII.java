package strings;

public class ReverseWordsInStringII {

	public static void main(String[] args) {
		char[] sentence = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		reverseWords(sentence);
		System.out.println(sentence);
	}

	private static void reverseWords(char[] sentence) {
		swap(sentence, 0, sentence.length - 1);
		int i = 0;
		
		for(int j = 0; j < sentence.length; ) {
			while(sentence[j] != ' ') {
				j++;
				if(j == sentence.length)
					break;
			}
			swap(sentence, i, j  - 1);
			i = j + 1; j++;
		}
	}
	
	private static void swap(char[] sentence, int start, int end) {
		for(int i = start, j = end; i < j; i++, j--) {
			char temp = sentence[i];
			sentence[i] = sentence[j];
			sentence[j] = temp;
		}
	}

}
