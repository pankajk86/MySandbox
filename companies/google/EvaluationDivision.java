package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationDivision {

	public static void main(String[] args) {
		String[][] equations = {{"a","e"},{"b","e"}};
		double[] values = {4.0,3.0};
		String[][] queries = {{"a","b"},{"e","e"},{"x","x"}};
		
		double[] result = calcEquation(equations, values, queries);
		for(double d: result) {
			System.out.print(d + ", ");
		}
	}

	private static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		Set<String> variables = new HashSet<>();
		double[] result = new double[queries.length];
		
		for(int i = 0; i < equations.length; i++) {
			for(int j = 0; j < equations[0].length; j++) {
				variables.add(equations[i][j]);
			}
		}
		
		Map<String, List<Equation>> map = getEquationsMap(equations, values);

		for(int i = 0; i < queries.length; i++) {
			String qnum = queries[i][0], qden = queries[i][1];
			if(!variables.contains(qnum) || !variables.contains(qden)) {
				result[i] = -1D;
			} else if(qnum.equals(qden)) {
				result[i] = 1D;
			} else {
				double val = helper(map, qnum, qden, 1D);
				result[i] = val == -1D ? (1D)/helper(map, qden, qnum, 1D) : val;
			}
		}
		
		return result;
	}

	private static double helper(Map<String, List<Equation>> map, String qnum, String qden, double value) {

		List<Equation> eqnList = map.get(qnum);
		
		if(eqnList != null) {
			for(Equation e: eqnList) {
				if(e.variable.equals(qden)) {
					return e.multipler * value;
				} else {
					double result = helper(map, e.variable, qden, e.multipler * value);
					return result;
				}
			}
		}
		
		return -1D;
	}

	private static Map<String, List<Equation>> getEquationsMap(String[][] equations, double[] values) {

		Map<String, List<Equation>> map = new HashMap<>();
		
		for(int i = 0; i < equations.length; i++) {
			String num = equations[i][0], den = equations[i][1];
			
			List<Equation> denList = !map.containsKey(num) ? new ArrayList<>() : map.get(num);
			Equation e = new Equation(den, values[i]);
			denList.add(e);
			map.put(num, denList);
		}
		
		return map;
	}

}

class Equation {
	String variable;
	double multipler;
	
	Equation(String variable, double multipler) {
		this.variable = variable;
		this.multipler = multipler;
	}
}