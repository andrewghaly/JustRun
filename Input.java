import java.util.Scanner;


public class Input {
	
	String[] input ={"backpack", "stats", "help", "walk", "fight", "run", "drop", "grab"};

	public String readInput(){
		System.out.println("Please enter a command");
		Scanner keyboard = new Scanner(System.in);
		
		//String in = keyboard.nextLine();
		String walk = keyboard.nextLine();
		writeOutput(walk);
		return walk;		
	}

	public boolean checkInput(String a){
		for(int i = 0; i <= input.length - 1; i++){
			if(a == input[i]){
				return true;
			}
		}
		return false;
		
	}
	
	private void writeOutput(String a){

		if(a.equals(input[0])){ //backpack
			System.out.println("You have accessed your backpack");
			//Character.setStats("agility", 2);
			readInput();
		}else if(a.equals(input[1])){ //stats
			//System.out.println(Character.getStats());
			readInput();
		}else if(a.equals(input[2])){ //help
			System.out.println("backpack, stats, help, walk, fight, run, drop, grab");
			readInput();
		}else if(a.equals(input[3])){ //walk
			System.out.println("walking...");
			World.walk();
			readInput();
		}else if(a.equals(input[4])){ //fight
			System.out.println("fighting...");
			readInput();
		}else if(a.equals(input[5])){ //run
			System.out.println("running...");
			readInput();
		}else if(a.equals(input[6])){ //drop
			System.out.println("dropped item...");
			readInput();
		}else if(a.equals(input[7])){ //grab
			System.out.println("grabbed item...");
			readInput();
		}else if(checkInput(a) == false){
				System.out.println("This is an invlaid command. Type 'help' for help.");
				readInput();
			}
		
	}
	
	
}