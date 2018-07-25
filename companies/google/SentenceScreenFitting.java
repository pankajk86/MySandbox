package google;

public class SentenceScreenFitting {

	public static void main(String[] args) {
		int rows = 3, cols = 6;
		String[] sentence = {"a", "bcd", "e"};
		int result = wordTyping(sentence, rows, cols);
		System.out.println(result);
		
		String[] sentence2 = {"fvhw","hyxnbnzk","tflzhe","yutwrbzm","aupplxpwxe","swpqa","ejy","ozfidofd","qfsqlwr","sppfm"};
		long start = System.currentTimeMillis();
		result = wordTyping(sentence2, 6599, 880);
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(result);
	}
	
	private static int wordTyping(String[] sentence, int rows, int cols) {
		
		int i = 0, col = 0, current = 0, count = 0;
		
		while(current < (rows * cols)) {
			String word = sentence[i];
			if(word.length() <= (cols - col)) {
				col += word.length() + 1;
				i++;
				if(i == sentence.length) {
					i = 0; count++;
				}
				
				if(col >= cols) {
					current += cols; col = 0;
				}
			} else {
				current += cols; col = 0;
			}
		}
		
		return count;
	}

	@SuppressWarnings("unused")
	private static int wordTyping2(String[] sentence, int rows, int cols) {

		int i = 0, row = 0, col = 0, count = 0;
		
		for(row = 0; row < rows; row++) {
			for(col = 0; col < cols;) {
				String word = sentence[i];
				if(word.length() <= (cols - col)) {
					col += word.length() + 1;
					i++;
					if(i == sentence.length) {
						i = 0; count++;
					}
					
					if(col >= cols) {
						break;
					}
				} else {
					break;
				}
			}
		}
		
		return count;
	}

}
