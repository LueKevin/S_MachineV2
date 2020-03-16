
// Program: Create a list of players and slot machines for the user to make new objects and have them interact
// Date: 03/01/19



public class Date {

	private int month;
	private int day;
	private int year;

	

	public Date(int month, int day, int year) {
		super();
		setMonth(month);
		setDay(day);
		setYear(year);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Birthday: " + month + "/" + day + "/" + year;
	}

}
