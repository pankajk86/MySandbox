package goal.arithmetic;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class SolveEquations {

    public static void main(String args[]) {

        // 4x -5y = 2;
        // -2x + 7y = -1
        RealMatrix coefficients = new Array2DRowRealMatrix(new double[][] { { 4, -5 }, { -2, 7 } }, false);
        DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();

        RealVector constants = new ArrayRealVector(new double[] { 2, -1 }, false);
        RealVector solution = solver.solve(constants);

        System.out.println("x: " + solution.getEntry(0) + ", y: " + solution.getEntry(1));
    }
}
