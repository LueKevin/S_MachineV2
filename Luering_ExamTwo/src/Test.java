
// Program: Create a list of players and slot machines for the user to make new objects and have them interact
// Date: 03/01/19



import java.text.DecimalFormat;
import java.util.*;

public class Test {

	public static void main(String[] args) {

		menu();

	}

	public static void menu() {
		DecimalFormat newFormat = new DecimalFormat("0.00");
		Scanner sc = new Scanner(System.in);
		int menuSelect = 0;
		int MAX_ALLOWED_PLAYERS = 50;
		int MAX_SLOT_MACHINES = 50;

		Date dateOne = new Date(3, 12, 1968);
		Name nameOne = new Name("Uncle", "Murphy", "Charlie");
		Player playerOne = new Player(nameOne, dateOne, 125);

		ArrayList<Player> playerList = new ArrayList<Player>(MAX_ALLOWED_PLAYERS);
		playerList.add(playerOne);

		ArrayList<SlotMachine> machineList = new ArrayList<SlotMachine>(MAX_SLOT_MACHINES);

		SlotMachine machineOne = new SlotMachine("Lucky 7", 5000, 10000, 5000, 10, 5, 0);
		machineList.add(machineOne);

		SlotMachine machineTwo = new SlotMachine("Lucky Lotto", 55000, 100000, 75000, 50, 25, 0);
		machineList.add(machineTwo);

		SlotMachine machineThree = new SlotMachine("Purple People Eater", 1000, 50, 40, 5, 2, 0);
		machineList.add(machineThree);

		do {
			System.out.println("1. Play slot machine.");
			System.out.println("2. Create new player.");
			System.out.println("3. Create new machine.");
			System.out.println("9. Exit");

			menuSelect = sc.nextInt();

			switch (menuSelect) {
			case 1:
				System.out.println("Select your player.");
				int counter = 0;
				for (Player p : playerList) {
					System.out.println(counter + " : " + p);
					counter++;
				}

				int playerIndex = sc.nextInt();
				if (playerIndex >= playerList.size() || playerList.get(playerIndex).getMoneyBalance() <= 0) {
					System.out.println("That player doesn't exist or has no more money. Try again.");
					break;
				} else {
					playerList.get(playerIndex).setMoneyBalance(playerList.get(playerIndex).getMoneyBalance() - 1);
				}

				System.out.println("Select your machine.");

				int machineCounter = 0;
				for (SlotMachine p : machineList) {
					System.out.println(machineCounter + " : " + p);
					machineCounter++;
				}

				int machineIndex = sc.nextInt();
				if (machineIndex >= machineList.size()) {
					System.out.println("That machine doesn't exist. Try again.");
					break;
				} else {
					play(machineList, playerList, machineIndex, playerIndex);
				}

				break;
			case 2:
				sc.nextLine();
				if (playerList.size() == MAX_ALLOWED_PLAYERS) {
					System.out.print("Player list is full.");
				} else {
					String firstName = readNamePart(sc, "first name");
					String middleName = readNamePart(sc, "middle name");
					String lastName = readNamePart(sc, "last name");
					Name NameNew = new Name(firstName, middleName, lastName);

					int year = -1;
					int BASE_YEAR = 1900;

					java.util.Date currentDate = new java.util.Date();

					int CURRENT_YEAR = currentDate.getYear() + 1900;
					int CURRENT_MONTH = currentDate.getMonth();
					int CURRENT_DAY = currentDate.getDay();

					System.out.println("Please enter the year of birth");
					do {
						year = sc.nextInt();
						if (year < BASE_YEAR || year > CURRENT_YEAR) {
							year = -1;
							System.out.println("Please enter a valid year");
						}
					} while (year < 0);

					int month = -1;
					System.out.println("Please enter the month of birth");
					do {
						month = sc.nextInt();
						if (year == CURRENT_YEAR) {
							if (month < 1 || month > CURRENT_MONTH) {
								month = -1;
								System.out.println("Please enter a valid month");
							}
						} else if (month < 1 || month > 12) {
							month = -1;
							System.out.println("Please enter a valid month");
						}
					} while (month < 0);

					int day = -1;
					System.out.println("Please enter the day of birth");
					do {
						day = sc.nextInt();
						switch (month) {
						case 1:
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:
						case 12:
							if (!isDateValidForNonFebDays(day, month, year, 31)) {
								day = -1;
								System.out.println("Please enter a valid date");
							}
							break;
						case 4:
						case 6:
						case 9:
						case 11:
							if (!isDateValidForNonFebDays(day, month, year, 30)) {
								day = -1;
								System.out.println("Please enter a valid date");
							}
							break;
						case 2:
							if (!isDateValidForFeb(day, month, year)) {
								day = -1;
								System.out.println("Please enter a valid date");
							}

						}

					} while (day < 0);

					Date DateNew = new Date(month, day, year);

					double money = readMoney(sc);

					Player PlayerNew = new Player(NameNew, DateNew, money);
					playerList.add(PlayerNew);
				}
				break;
			case 3:
				if (machineList.size() == MAX_SLOT_MACHINES) {
					System.out.print("Machine list is full.");
				} else {

					String machineName = readNamePart(sc, "Slot machine name");
					double balance = readMoney(sc);
					double regPay = readMoney(sc);
					double jackPay = readMoney(sc);

					int regIndex = readInts(sc);
					int jackIndex = readInts(sc);
					int plays = readInts(sc);

					SlotMachine MachineNew = new SlotMachine(machineName, balance, jackIndex, jackPay, regIndex, regPay,
							plays);
					machineList.add(MachineNew);
				}
				break;
			}
		} while (menuSelect != 9); // End playSlots (Method 1)
	}

	private static double readMoney(Scanner sc) {
		double money;
		System.out.println("Please enter an amount");

		do {

			money = sc.nextDouble();
			if (money < 0) {
				System.out.println("Please enter valid amount");
				money = -1;
			}

		} while (money < 0);
		return money;
	}

	private static int readInts(Scanner sc) {
		int num;
		System.out.println("Please enter a number");

		do {

			num = sc.nextInt();
			if (num < 0) {
				System.out.println("Please enter valid number > 0");
				num = -1;
			}

		} while (num < 0);
		return num;
	}

	private static boolean isDateValidForFeb(int day, int month, int year) {
		java.util.Date currentDate = new java.util.Date();

		int CURRENT_YEAR = currentDate.getYear() + 1900;
		int CURRENT_MONTH = currentDate.getMonth();
		int CURRENT_DAY = currentDate.getDay();

		if (year == CURRENT_YEAR && month == CURRENT_MONTH && day > CURRENT_DAY) {
			return false;
		}

		boolean leap = false;
		if ((year % 100 == 0 && year % 400 == 0) || (year % 4 == 0)) {
			leap = true;
		}

		if (leap) {
			if (day < 1 || day > 29)
				return false;
		} else {
			if (day < 1 || day > 28)
				return false;
		}

		return true;
	}

	private static boolean isDateValidForNonFebDays(int day, int month, int year, int limit) {

		java.util.Date currentDate = new java.util.Date();

		int CURRENT_YEAR = currentDate.getYear() + 1900;
		int CURRENT_MONTH = currentDate.getMonth();
		int CURRENT_DAY = currentDate.getDay();

		if (year == CURRENT_YEAR && month == CURRENT_MONTH && day > CURRENT_DAY) {
			return false;
		}

		if (day < 1 || day > limit) {
			return false;
		}

		return true;
	}

	private static String readNamePart(Scanner sc, String msgString) {
		String name = null;
		System.out.println("Enter the " + msgString);
		do {
			name = sc.nextLine();
			if (name == null || name.trim().length() == 0 || name.contains(" ")
					|| !(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
				name = null;
				System.out.println("Please enter a valid " + msgString);
			}
		} while (name == null);
		return name;
	}

	public static void play(ArrayList<SlotMachine> machineList, ArrayList<Player> playerList, int machineIndex,
			int playerIndex) {

		SlotMachine slotMachine = machineList.get(machineIndex);
		slotMachine.setBalance(slotMachine.getBalance() + 1);
		slotMachine.setPlays(slotMachine.getPlays() + 1);
		Player player = playerList.get(playerIndex);
		
		if (slotMachine.getPlays() % slotMachine.getRegIndex() == 0) {
			player.setMoneyBalance(player.getMoneyBalance() + slotMachine.getRegPay());
			System.out.println("YOU'VE WON! $" + slotMachine.getRegPay() + "\n Your new balance is $" + player.getMoneyBalance());
		}

		if (slotMachine.getPlays() % slotMachine.getJackIndex()  == 0) {
			player.setMoneyBalance(player.getMoneyBalance() + slotMachine.getJackPay());
			System.out.println("YOU'VE WON! $" + slotMachine.getJackPay() + "\n Your new balance is $" + player.getMoneyBalance());
		}

		System.out.println("oo! You lost $1 "+  "\n Your new balance is $" + player.getMoneyBalance());
		

	}

}
