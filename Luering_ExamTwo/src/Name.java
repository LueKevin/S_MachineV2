
// Program: Create a list of players and slot machines for the user to make new objects and have them interact
// Date: 03/01/19

public class Name {

	private String first;
	private String mid;
	private String last;
	
	
	public Name(String first, String mid, String last) {
		super();
		setFirst(first);
		setMid(mid);
		setLast(last);
	}


	public String getFirst() {
		return first;
	}


	public void setFirst(String first) {
		this.first = first;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getLast() {
		return last;
	}


	public void setLast(String last) {
		this.last = last;
	}


	
	public String toString() {
		return first + " " + mid + " " + last;
	}
	
}
