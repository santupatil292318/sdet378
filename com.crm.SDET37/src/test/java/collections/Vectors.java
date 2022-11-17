package collections;

import java.util.Vector;

public class Vectors {
public static void main(String[] args) {
	Vector<Object> vector = new Vector<Object>();
	vector.add("car");
	vector.add("bus");
	System.out.println("size is"+vector.size());
	System.out.println("capacity is"+vector.capacity());
	vector.add("train");
	System.out.println(vector);
	System.out.println(vector.get(2));
	if (vector.contains("car")) {
		System.out.println("vehicle car is present");
	}
	else {
		System.out.println("vehicle car is not present");
	}
	vector.add("ship");
	for (int i = 0; i < vector.size(); i++) {
		System.out.println(vector.get(i));
	}
}
}
