package tanvn.java.recipes.chapter4;

public class Golfer {
	private String first;
	private String last;
	private int score;

	@Override
	public String toString() {
		return "Golfer [first=" + first + ", last=" + last + ", score=" + score + "]";
	}

	public Golfer(String first, String last, int score) {
		super();
		this.first = first;
		this.last = last;
		this.score = score;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public int getScore() {
		return score;
	}

}
