package microsoft;

public class DesignTicTacToe {

	public static void main(String[] args) {
		TicTacToe toe = new TicTacToe(3);
		System.out.println(toe.move(0, 0, 1));
		System.out.println(toe.move(0, 2, 2));
		System.out.println(toe.move(2, 2, 1));
		System.out.println(toe.move(1, 1, 2));
		System.out.println(toe.move(2, 0, 1));
		System.out.println(toe.move(1, 0, 2));
		System.out.println(toe.move(2, 1, 1));
	}

}

class TicTacToe {
	
	int[] rows;
	int[] cols;
	int diagonal, antiDiagonal, size;
	
	public TicTacToe(int n) {
		size = n;
		rows = new int[n];
		cols = new int[n];
	}
	
	public int move(int row, int col, int player) {
		int toAdd = player == 1 ? 1 : -1;
		
		rows[row] += toAdd; cols[col] += toAdd;
		if(row == col) diagonal += toAdd;
		if(col == size - row - 1) antiDiagonal += toAdd;
		
		if(Math.abs(rows[row]) == size
				|| Math.abs(cols[col]) == size
				|| Math.abs(diagonal) == size
				|| Math.abs(antiDiagonal) == size)
			return player;
		
		return 0;
	}
}