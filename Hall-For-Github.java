//This code was made in June of 2019 by Michael Morel.
//code edited for Github on Jan 14 2020.
import java.util.Random;

public class Hall {

	public static int RNG(int maxRNG) 
	{
		Random ran = new Random();
		int rng = ran.nextInt(maxRNG);
		return rng;
	}

	public static void main(String[] args) 
	{
		long WinCounter = 0L;
		long PlayAmount = 100000L;
		//Modify PlayAmount to change the amount of games that happen.
		for (long i=0L; i < PlayAmount; i++) 
		{
			int option1 = 0;
			int option2 = 0;
			int option3 = 0;
			while (option1 == option2 || option2 == option3 || option1 == option3) 
			{
				option1 = RNG(3);
				option2 = RNG(3);
				option3 = RNG(3);
			}
			int ChosenOne = RNG(3);
			if (ChosenOne == 0) {
				ChosenOne = option1;
			} 
			else if (ChosenOne == 1) 
			{
				ChosenOne = option2;
			} 
			else if (ChosenOne == 2) 
			{
				ChosenOne = option3;
			}
			//The program is looking for a "door" that is not chosen one by the player and is also not the prize "door" (prize door == 0) to take out.
			if (option1 >= 1 && option1 != ChosenOne) 
			{
				option1 = -1;//The number that is not chosen by the program's player and is bigger than the correct number which is 0, is replaced with -1.
			} 
			else if (option2 >= 1 && option2 != ChosenOne) 
			{
				option2 = -1;
			} 
			else if (option3 >= 1 && option3 != ChosenOne) 
			{
				option3 = -1;
			}
			//now one Door is replaced with -1, taking it out the option pool.
			if (ChosenOne == option1 && option2 != -1) {//For this group of if and following if else statements, the program determines which of the doors is left and switches to the door it is not.
				ChosenOne = option2;
			} 
			else if (ChosenOne == option1 && option3 != -1) 
			{
				ChosenOne = option3;
			} 
			else if (ChosenOne == option2 && option1 != -1) 
			{
				ChosenOne = option1;
			} 
			else if (ChosenOne == option2 && option3 != -1) 
			{
				ChosenOne = option3;
			} 
			else if (ChosenOne == option3 && option1 != -1) 
			{
				ChosenOne = option1;
			} 
			else if (ChosenOne == option3 && option2 != -1) 
			{
				ChosenOne = option2;
			}
			//This if statement checks if the chosen door that was switched by the player is the prize 0 door. If it is, then it counts a win. Win rate should be around 2/3 when switching.
			if (ChosenOne == 0) 
			{
				WinCounter++;
			}
		}
		double WinPercent = (WinCounter * 1.0/PlayAmount)*100;
		System.out.printf("Think about if you were on a game show, given 3 doors and one has a prize and the other 2 have nothing.\n"
				+ "Now, say that you choose one door and the host of the game opens one he knows has nothing behind it then offers you to switch doors or keep yours,\nwhat do you do? ");
		System.out.println("You may think that it does not matter but, if you think that you are wrong.");
		System.out.println("After switching doors, " + PlayAmount + " plays, " + WinCounter + " came back winners, or " + WinPercent + "%.");
	}

}
