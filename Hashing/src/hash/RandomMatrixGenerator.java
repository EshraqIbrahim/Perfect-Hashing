package hash;

import java.util.Random;

public class RandomMatrixGenerator {
	public int[][] random(int m) { // m from the table size && n from max element
		Random R = new Random();
		int[][] randomMatrix = new int[m][32];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 32; j++) {
				randomMatrix[i][j] = R.nextInt(2);
			}
		}
		return randomMatrix;
	}
}