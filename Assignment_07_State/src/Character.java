import java.util.Scanner;

public class Character {

    private static Scanner scanner = new Scanner(System.in);

    private int turn = 1;
    private String name = null;
    private State level;
    private int experience;
    private int health;
    private boolean isActive = true;

    public Character() {
        this.level = new NoviceState(this);
    }

    public void play() {
        do {
            if (name == null) {
                setName();
            }
            level.action();
        } while (isActive);
    }

    public void setState(State state) {
        this.level = state;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setTurn() {this.turn++;}

    public void setName() {
        System.out.println();
        System.out.println("Give your character a name.");
        this.name = scanner.nextLine();
    }

    public int getExperiencePoints() {return this.experience;}

    public void train() {
        this.experience += 5;
    }

    public void meditate() {
        this.health += 5;
    }

    public void fight() {
        this.experience += 7;
        this.health -= 2;
    }

    public int readInput(String[] options) {
        System.out.println("\nWhat do you want to do?:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clean the scanner/absorb the empty line
        return choice;
    }

    public void showCharacterStatus() {
        System.out.println();
        System.out.println("TURN " + turn + " - CHARACTER STATUS:");
        System.out.println("Name: " + this.name);
        System.out.println("Level: " + this.level);
        System.out.println("Experience Points: " + this.experience);
        System.out.println("Health Points: " + this.health);
        System.out.println();
    }

}
