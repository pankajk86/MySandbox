package microsoft;

public class BattleshipsInABoard {

	public static void main(String[] args) {
		char[][] a = {
				{'X', '.', '.', 'X'},
				{'.', '.', '.', 'X'},
				{'.', '.', '.', 'X'}
			};
		
		int result = countBattleships(a);
		System.out.println(result);
	}

	private static int countBattleships(char[][] a) {
		if(a == null || a.length == 0) return 0;
		int result = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] == '.'
				|| (i > 0 && a[i - 1][j] == 'X')
				|| (j > 0 && a[i][j - 1] == 'X'))
					continue;
				result++;
			}
		}
		return result;
	}

}
