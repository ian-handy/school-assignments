
public class AgrefilLeld {

	public static boolean compliant(int matrix[][])
	{
		// Check if matrix is null or not a proper 2-dimensional array
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		
		// Check if any row is null
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] == null) {
				return false;
			}
		}
		
		// Check if array is ragged (jagged) - all rows must have the same length
		int columnCount = matrix[0].length;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != columnCount) {
				return false;
			}
		}
		
		// Check property 2: Sum of rows should not equal any value in that row
		for (int i = 0; i < matrix.length; i++) {
			int rowSum = 0;
			// Calculate row sum
			for (int j = 0; j < matrix[i].length; j++) {
				rowSum += matrix[i][j];
			}
			// Check if row sum equals any value in the row
			for (int j = 0; j < matrix[i].length; j++) {
				if (rowSum == matrix[i][j]) {
					return false;
				}
			}
		}
		
		// Check property 3: Sum of columns should not equal any value in that column
		for (int j = 0; j < columnCount; j++) {
			int colSum = 0;
			// Calculate column sum
			for (int i = 0; i < matrix.length; i++) {
				colSum += matrix[i][j];
			}
			// Check if column sum equals any value in the column
			for (int i = 0; i < matrix.length; i++) {
				if (colSum == matrix[i][j]) {
					return false;
				}
			}
		}
		
		// If all checks passed, the matrix is compliant with all three properties
		return true;
	}

}
