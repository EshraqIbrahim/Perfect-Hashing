package hash;

import java.util.ArrayList;

public class FirstMethod {
	int[][] randomMatrix;
	MatrixMethod hashValue;
	int collision = 0;

	public int[] hashTableCreator(int hashLength, ArrayList<Integer> keys) {
		int[] hashTable = new int[keys.size() * keys.size()];
		boolean checkCollision = true;
		while (checkCollision) {
			RandomMatrixGenerator random = new RandomMatrixGenerator();
			randomMatrix = random.random(hashLength);
			hashValue = new MatrixMethod(randomMatrix);
			hashTable = new int[keys.size() * keys.size()];
			for (int i = 0; i < keys.size(); i++) {
				int index = hashValue.hashFunction(keys.get(i)) % hashTable.length;
				if (hashTable[index] == 0) {
					hashTable[index] = keys.get(i);
					if (i == keys.size() - 1) {
						checkCollision = false;
					}
				} else {
					checkCollision = true;
					collision++;
					break;
				}
			}
		}
		return hashTable;
	}

	public boolean find(int[] hashTable, int key) {
		// O(1)
		if (hashTable[hashValue.hashFunction(key) % hashTable.length] == key) {
			return true;
		}
		return false;
	}

	public int getCollisionNum() {
		return collision;
	}
}
