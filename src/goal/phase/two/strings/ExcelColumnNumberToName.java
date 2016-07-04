package goal.phase.two.strings;

public class ExcelColumnNumberToName {

    public static void main(String[] args) {

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
