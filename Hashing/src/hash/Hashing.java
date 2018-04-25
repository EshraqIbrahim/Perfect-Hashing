package hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Hashing {
	ArrayList<Integer> elements = new ArrayList<>();
	int max;
	ONSpaceSolution on;
	FirstMethod f;
	int[] hash;

	public void load(File file) {
		Set<Integer> set = new LinkedHashSet<>();
		try {
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String s = scan.nextLine();
				String[] elementsString = s.split(",");
				for (int i = 0; i < elementsString.length; i++) {
					set.add(Integer.parseInt(elementsString[i]));
				}
			}
			elements.addAll(set);
			System.out.println("Num of elements without duplicates = " + elements.size());
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void insertON() {
		on = new ONSpaceSolution(elements);
		on.firstLevelHashing();
	}

	public void insertONs() {
		f = new FirstMethod();
		hash = f.hashTableCreator((int) Math.ceil(Math.log(elements.size()) / Math.log(2)), elements);
		System.out.println("Num of collicions = " + f.getCollisionNum());
		System.out.println("Total Space = " + hash.length);
	}

	public void findON(int key) {
		System.out.println(on.find(key));
	}

	public void finsONs(int key) {
		System.out.println(f.find(hash, key));
	}

}
