package hash;

public class MatrixMethod {
	int hashValue;
	int[][] hashMatrix;
	String binaryRep;

	public MatrixMethod(int[][] matrix) {
		hashMatrix = matrix;
	}

	public int hashFunction(int x) {
		binaryRep = "";
		String binaryNum = Integer.toBinaryString(x);
		int sub = hashMatrix[0].length - binaryNum.length();
		if (sub > 0) {
			String small = binaryNum;
			binaryNum = "";
			for (int i = 0; i < sub; i++) {
				binaryNum += 0;
			}
			binaryNum += small;
		}
		int[] reqNumMatrix = new int[binaryNum.length()];
		int m = 0;
		for (int i = 0; i < binaryNum.length(); i++) {
			reqNumMatrix[i] = Character.getNumericValue(binaryNum.charAt(i));
		}
		for (int i = 0; i < hashMatrix.length; i++) {
			for (int j = 0; j < hashMatrix[0].length; j++) {
				m += hashMatrix[i][j] * reqNumMatrix[j];
			}
			binaryRep += m % 2;
			m = 0;
		}
		hashValue = Integer.parseInt(binaryRep, 2);
		return hashValue;
	}
}
