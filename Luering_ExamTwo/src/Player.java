// Kevin Luering
// 201920-COP-2800C-23135
// Program: Create a list of players and slot machines for the user to make new objects and have them interact
// Date: 03/01/19

public class Player {
	
	private Name playerName;
	private Date birth;
	private double moneyBalance;
	
	public Player(Name playerName, Date birth, double moneyBalance) {
		super();
		setPlayerName(playerName);
		setBirth(birth);
		setMoneyBalance(moneyBalance);
	}

	public Name getPlayerName() {
		return playerName;
	}

	public void setPlayerName(Name playerName) {
		this.playerName = playerName;
	}

	public Date getBirth(){
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public double getMoneyBalance() {
		return moneyBalance;
	}

	public void setMoneyBalance(double moneyBalance) {
		this.moneyBalance = moneyBalance;
	}
	
	public void play() {
		
	}

	@Override
	public String toString() {
		return "Player: " + playerName + " " + birth + " Money: $" + moneyBalance;
	}
	
	
}