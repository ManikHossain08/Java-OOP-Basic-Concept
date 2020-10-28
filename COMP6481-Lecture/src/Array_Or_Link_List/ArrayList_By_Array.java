package Array_Or_Link_List;


public class ArrayList_By_Array {

	private Object[] myStore;
	private int actSize = 0;

	public ArrayList_By_Array() {
		myStore = new Object[10];
	}

	public Object get(int index) {
		if (index < actSize) {
			return myStore[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void add(Object obj) {
		if (actSize > myStore.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		myStore[actSize++] = obj;
	}

	public Object remove(int index) {
		if (index < actSize || index > myStore.length) {
			Object obj = myStore[index];
			myStore[index] = null;
			int tmp = index;
			while (tmp < actSize) {
				myStore[tmp] = myStore[tmp + 1];
				myStore[tmp + 1] = null;
				tmp++;
			}
			actSize--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	public int size() {
		return actSize;
	}
	
	public boolean isEmpty() {
		return actSize == 0;
	}
	
	public void set(int index, int val) {
		myStore[index] = val;
	}


	public static void main(String a[]) {
		ArrayList_By_Array mal = new ArrayList_By_Array();
		System.out.println(mal.isEmpty());
		mal.add(2);
		mal.add(5);
		mal.add(1);
		mal.add(23);
		mal.add(14);
		for (int i = 0; i < mal.size(); i++) {
			System.out.print(mal.get(i) + " ");
		}
		mal.add(29);
		mal.remove(3);
		System.out.println("Element at Index 2:" + mal.get(2));
		System.out.println("List size: " + mal.size());
		System.out.println("Removing element at index 2: " + mal.remove(2));
		mal.set(2, 30);
		for (int i = 0; i < mal.size(); i++) {
			System.out.print(mal.get(i) + " ");
		}
		System.out.println(mal.isEmpty());
		
//		List<Integer> aa = new ArrayList<Integer>();
//		aa.rem();
	}
}