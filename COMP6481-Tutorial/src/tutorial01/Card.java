package tutorial01;

public class Card {
	private String recipient = "";
	private String occasion = "";

	public Card(String recipient, String occasion) {
		this.recipient = recipient;
		this.occasion = occasion;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public void greeting() {
		System.out.println("Happy " + occasion);
	}
}

class BirthDay extends Card {
	private int age;

	public BirthDay(String recipient, int age) {
		super(recipient, "Birthday");
		this.age = age;
	}

	@Override
	public void greeting() {
		System.out.print("Dear " + getRecipient() + " ");
		super.greeting();
		System.out.println("Happy " + age + "th Birthday\n\n");
	}
}

class Holiday extends Card {
	public Holiday(String recipient) {
		super(recipient, "Holiday");
	}

	@Override
	public void greeting() {
		System.out.println("Dear " + getRecipient());
		super.greeting();
	}
}

class Valentine extends Card {
	private int kisses;

	public Valentine(String r, int k) {
		super(r, "Valentine");
		kisses = k;
	}

	@Override
	public void greeting() {
		System.out.println("Dear " + super.getRecipient() + " ");
		super.greeting();
		System.out.println("Love and Kisses,\n");
		for (int j = 0; j < kisses; j++)
			System.out.print("X");
		System.out.println("\n\n");
	}
}
