// Kevin Luering
// 201920-COP-2800C-23135
// Program: Create a list of players and slot machines for the user to make new objects and have them interact
// Date: 03/01/19

public class SlotMachine {

	private String name;
	private double balance;
	private int jackIndex;
	private double jackPay;
	private int regIndex;
	private double regPay;
	private int plays;
	
	
	public SlotMachine(String name, double balance, int jackIndex, double jackPay, int regIndex, double regPay, int plays) {
		super();
		setName(name);
		setBalance(balance);
		setJackIndex(jackIndex);
		setJackPay(jackPay);
		setRegIndex(regIndex);
		setRegPay(regPay);
		setPlays(plays);
	}


	public int getPlays() {
		return plays;
	}


	public void setPlays(int plays) {
		this.plays = plays;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getJackIndex() {
		return jackIndex;
	}


	public void setJackIndex(int jackIndex) {
		this.jackIndex = jackIndex;
	}


	public double getJackPay() {
		return jackPay;
	}


	public void setJackPay(double jackPay) {
		this.jackPay = jackPay;
	}


	public int getRegIndex() {
		return regIndex;
	}


	public void setRegIndex(int regIndex) {
		this.regIndex = regIndex;
	}


	public double getRegPay() {
		return regPay;
	}


	public void setRegPay(double regPay) {
		this.regPay = regPay;
	}


	@Override
	public String toString() {
		return name + ":\n JACKPOT: $" + jackPay + "\n Regular Win: $" + regPay + "\n";
	}
	
	
	
	
}