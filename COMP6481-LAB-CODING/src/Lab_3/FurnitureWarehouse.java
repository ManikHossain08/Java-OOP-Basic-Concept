package Lab_3;

class Furniture {
	protected int length;
	protected int width;
	protected int height;

	public Furniture(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public Furniture(Furniture f) {
		this.length = f.length;
		this.width = f.width;
		this.height = f.height;
	}

	@Override
	public String toString() {
		return "Furniture with the following length, width, height: [" + length + ", " + width + ", " + height + "].";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Furniture other = (Furniture) obj;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public static boolean threeWayOfComparision(Object o1, Object o2, Object o3) {
		return o1.equals(o2) && o2.equals(o3) && o3.equals(o1);
	}

	public Furniture clone() {
		return new Furniture(this);
	}

}

class Carpet extends Furniture {

	protected enum ITEMS {
		sythetic, silk, wool
	};

	protected ITEMS material;

	public Carpet(int length, int width, int height, ITEMS m) {
		super(30, 50, 1);
		material = m;
	}

	public Carpet(Carpet c) {
		super(30, 50, 1);
		this.material = c.material;
	}

	@Override
	public String toString() {
		return "Carpet with the following length, width, height: [" + length + ", " + width + ", " + height + "].";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carpet other = (Carpet) obj;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		if (this.material != other.material)
			return false;
		return true;
	}

	public Furniture clone() {
		return new Carpet(this);
	}

}

class Chair extends Furniture {
	protected boolean backrest;

	public Chair(int length, int width, int height, boolean backrest) {
		super(10, 13, 20);
		this.backrest = backrest;
	}

	public Chair(Chair c) {
		super(10, 13, 20);
		this.backrest = c.backrest;
	}

	@Override
	public String toString() {
		return "Chair with the following length, width, height and backrest: [" + length + ", " + width + ", " + height
				+ ", " + backrest + "].";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chair other = (Chair) obj;
		if (backrest != other.backrest)
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public Furniture clone() {
		return new Chair(this);
	}

}

class Couch extends Furniture {
	protected int numberOfCushions;

	public Couch(int length, int width, int height, int numberOfCushions) {
		super(30, 20, 24);
		this.numberOfCushions = numberOfCushions;
	}

	public Couch(Couch co) {
		super(30, 20, 24);
		this.numberOfCushions = co.numberOfCushions;
	}

	@Override
	public String toString() {
		return "Chair with the following length, width, height, numberOfCushions: [" + length + ", " + width + ", "
				+ height + ", " + numberOfCushions + "].";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couch other = (Couch) obj;
		if (numberOfCushions != other.numberOfCushions)
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public Furniture clone() {
		return new Couch(this);
	}

}

class LoveSeat extends Couch {
	protected boolean recliner;

	public LoveSeat(int length, int width, int height, int numberOfCushions, boolean recliner) {
		super(15, 20, 24, numberOfCushions);
		this.recliner = recliner;
	}

	public LoveSeat(LoveSeat ss) {
		super(15, 20, 24, ss.numberOfCushions);
		this.recliner = ss.recliner;
	}

	@Override
	public String toString() {
		return "Chair with the following length, width, height and recliner: [" + length + ", " + width + ", " + height
				+ ", " + recliner + "].";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoveSeat other = (LoveSeat) obj;
		if (recliner != other.recliner)
			return false;
		if (numberOfCushions != other.numberOfCushions)
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	public Furniture clone() {
		return new LoveSeat(this);
	}

}

class AntiqueCarpet extends Carpet {
	protected int age;

	public AntiqueCarpet(int length, int width, int height, ITEMS m, int age) {
		super(20, 25, 2, m);
		this.age = age;
	}

	public AntiqueCarpet(AntiqueCarpet ac) {
		super(20, 25, 2, ac.material);
		this.age = ac.age;
	}

	@Override
	public String toString() {
		return "Chair with the following length, width, height, material and age: [" + length + ", " + width + ", "
				+ height + ", " + material + ", " + age + "].";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntiqueCarpet other = (AntiqueCarpet) obj;
		if (age != other.age)
			return false;
		if (height != other.height)
			return false;
		if (length != other.length)
			return false;
		if (width != other.width)
			return false;
		if (this.material != other.material)
			return false;
		return true;
	}

	public Furniture clone() {
		return new AntiqueCarpet(this);
	}

}

public class FurnitureWarehouse {

	public static void main(String[] args) {
		Furniture[][] furnitures = new Furniture[10][3];
		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[0][i] = new Carpet(10, 20, 30, Carpet.ITEMS.silk);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[1][i] = new Chair(10, 20, 30, false);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[2][i] = new Couch(10, 20, i * 10, 100);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[3][i] = new Couch(10, 20, 30, 100);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[4][i] = new AntiqueCarpet(10, 20, 30, Carpet.ITEMS.silk, 5);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[5][i] = new AntiqueCarpet(10, 20, 30 - i, Carpet.ITEMS.silk, 5);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[6][i] = new LoveSeat(10, 20, 30, 5, true);
		}

		for (int i = 0; i < furnitures[0].length; i++) {
			furnitures[7][i] = new Couch(i + 10, 20, 30, 100);
		}

		findEqualFurniture(furnitures);

		copyInventory(furnitures);

	}

	private static void findEqualFurniture(Furniture[][] furnitures) {
		System.out.println("*** FindingEqualRows(...)***");
		for (int i = 0; i < furnitures.length; i++) {
			if (furnitures[i][0] != null
					&& Furniture.threeWayOfComparision(furnitures[i][0], furnitures[i][1], furnitures[i][2]))
				System.out.println("Row " + i + " Was found to contains equal objects");

		}

	}

	private static Furniture[][] copyInventory(Furniture[][] furnitures) {
		Furniture[][] furnituresTemp = new Furniture[furnitures.length][furnitures[0].length];
		System.out.println("Displaying Original Inventory...");
		for (int i = 0; i < furnituresTemp.length; i++) {
			System.out.println("Content of row " + i);
			for (int j = 0; j < furnituresTemp[i].length; j++) {
				if (furnitures[i][j] != null) {
					System.out.println(furnitures[i][j]);
				}

			}
		}
		System.out.println("Displaying Copied Inventory...");
		for (int i = 0; i < furnituresTemp.length; i++) {
			System.out.println("Content of row " + i);
			for (int j = 0; j < furnituresTemp[i].length; j++) {
				if (furnitures[i][j] != null)
					furnituresTemp[i][j] = furnitures[i][j].clone();
				System.out.println(furnituresTemp[i][j]);
			}
		}

		return furnituresTemp;
	}

}
// polymorphism and late binding is same...
