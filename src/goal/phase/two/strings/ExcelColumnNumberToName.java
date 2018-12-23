package goal.phase.two.strings;

public class ExcelColumnNumberToName {

    public static void main(String[] args) {
    	columnNumberToColumnName();
    	columnNameToColumnNumber();
    }

	private static void columnNameToColumnNumber() {
		String s = "AAZ";
		int len = s.length(), result = 0;
        
        for(int i = 0, pow = len - 1; i < len; i++, pow--) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, pow);
        }
        System.out.println(result);
	}

	private static void columnNumberToColumnName() {
		int colNum = 1500;
        int dividend = colNum;
        String colName = "";
        int modulo;

        while (dividend > 0) {
            modulo = (dividend - 1) % 26;
            colName = Character.toString((char) ('A' + modulo)) + colName;
            dividend = (int) ((dividend - modulo) / 26);
        }

        System.out.println("Number: " + colNum + ", ColumnName: " + colName);		
	}

}
