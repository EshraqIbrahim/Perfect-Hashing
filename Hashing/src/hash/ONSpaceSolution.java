package hash;

import java.util.ArrayList;

public class ONSpaceSolution {
	int[][] mainMatrix;
	FirstMethod[] hashTable;
	int[][] subHashTable;
	ArrayList<Integer> set;
	MatrixMethod mm;
	int sum = 0;

	public ONSpaceSolution(ArrayList<Integer> elements) {
		set = elements;
		hashTable = new FirstMethod[elements.size()];
		int m = (int) Math.ceil(Math.log(elements.size()) / Math.log(2));
		RandomMatrixGenerator mg = new RandomMatrixGenerator(); // matrixGenerator
		mainMatrix = mg.random(m);
	}

	@SuppressWarnings("unchecked")
	public void firstLevelHashing() {
		mm = new MatrixMethod(mainMatrix);
		@SuppressWarnings("rawtypes")
		ArrayList[] first = new ArrayList[set.size()];
		for (int i = 0; i < set.size(); i++) {
			int value = mm.hashFunction(set.get(i)) % first.length;
			if (first[value] == null) {
				first[value] = new ArrayList<>();
			}
			first[value].add(set.get(i));
		}
		for (int i = 0; i < first.length; i++) {
			if (first[i] != null) {
				sum += (first[i].size() * first[i].size());
			}
		}
		secondLevelHashing(first);
		System.out.println("Total Spaca = " + sum);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void secondLevelHashing(ArrayList[] first) {
		subHashTable = new int[hashTable.length][];
		for (int i = 0; i < hashTable.length; i++) {
			if (first[i] != null && first[i].size() != 0) {
				FirstMethod subTable = new FirstMethod();
				int hashLength = 1;
				if (first[i].size() != 1) {
					hashLength = (int) Math.ceil(Math.log(first[i].size()) / Math.log(2));
				}
				subHashTable[i] = subTable.hashTableCreator(hashLength, first[i]);
				// System.out.println(subTable.getCollisionNum());
				hashTable[i] = subTable;
			}
		}
	}

	public boolean find(int key) {
		int index = mm.hashFunction(key) % hashTable.length;
		if (hashTable[index] != null) {
			return (hashTable[index].find(subHashTable[index], key));
		}
		return false;
	}
}
