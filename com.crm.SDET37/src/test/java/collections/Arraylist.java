package collections;

import java.util.ArrayList;

public class Arraylist {
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(10);
		list.add('A');
		list.add("hello");
		list.add(null);
		list.add(null);
		list.add(2, "hi");
		//System.out.println(list);
		
		ArrayList<Object> list1 = new ArrayList<Object>();
		list1.add(10);
		list1.add('B');
		list1.add("bye");

		//System.out.println(list1);
		//list.retainAll(list1);//It will print common element
		//System.out.println(list);
		//list.removeAll(list1);//it will remove common
		//System.out.println(list);
		
		
	}

}
