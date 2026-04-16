import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecommendationApp {

    private State currentState;
    private boolean quit = false;
    private Scanner scanner = new Scanner(System.in);
    private List<Recommendation> recommendations = new ArrayList<>();
    private List<Book> booksInSystem = new ArrayList<>();
    private Recommendation selectedRecommendation = null;

    public void operate() {
        do {
            currentState.operate();
        } while (!quit);
    }

    public void setState(State state) {
        currentState = state;
    }

    public void setIsQuit(boolean isQuit) {
        quit = isQuit;
    }

    public int readInput(String[] options) {
        java.lang.System.out.println("\nWhat do you want to do?:");
        for (int i = 1; i <= options.length; i++) {
            java.lang.System.out.println(i + ". " + options[i-1]);
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clean the scanner/absorb the empty line
        return choice;
    }

    public void showRecommendations() {
        System.out.println("Recommendation Lists:");
        for (Recommendation r : recommendations) {
            System.out.println();
            List<Book> books = r.getBooks();
            System.out.println("  " + r.getTargetAudience());
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public void cloneARecommendation() {
        System.out.println("Which Recommendation List do You want to clone?");
        int count = 0;
        for (Recommendation r : recommendations) {
            System.out.println(++count + ". " + r.getTargetAudience());
        }

        boolean isCorrect = false;
        while (!isCorrect) {
            int index = scanner.nextInt() - 1;
            System.out.println();
            if (index >= 0 && index <= recommendations.size() -1) {
                selectedRecommendation = recommendations.get(index).clone(); // Clone the recommendation
                isCorrect = true;
            } else {
                System.out.println("Not a valid choice. Try again.");
            }
        }
        scanner.nextLine(); // Clear the scanner

        System.out.println("Give your Recommendation a new target audience: ");
        String target = scanner.nextLine();
        selectedRecommendation.setTargetAudience(target);
    }

    public void addABookToRecommendation() {
        System.out.println("Do you want to create a new book or select an existing one?");
        System.out.println("1. New Book\n2. Select a book");

        boolean isCorrectInput = false;
        while (!isCorrectInput) {
            switch (scanner.nextInt()) {
                case 1:
                    createAndAddBook();
                    isCorrectInput = true;
                    break;
                case 2:
                    selectABook();
                    isCorrectInput = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public void createAndAddBook() {
        scanner.nextLine(); // Clear the scanner
        System.out.println("Give the book title: ");
        String title = scanner.nextLine();
        System.out.println("Give the author: ");
        String author = scanner.nextLine();
        System.out.println("Give the genre: ");
        String genre = scanner.nextLine();

        Book book = new Book(title, author, genre);
        booksInSystem.add(book);
        selectedRecommendation.addBook(book);

        System.out.println("\nBooks in your recommendation:");
        for (Book b : selectedRecommendation.getBooks()) {
            System.out.println("  " + b.getTitle());
        }
    }

    public void selectABook() {
        scanner.nextLine(); // Clear the scanner
        System.out.println("Select a book to add: ");
        int count = 0;
        for (Book b : booksInSystem) {
            System.out.println(++count + ". " + b.getTitle());
        }

        boolean isCorrect = false;
        while (!isCorrect) {
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index <= booksInSystem.size() - 1) {
                Book book = booksInSystem.get(index).clone();
                selectedRecommendation.addBook(book);
                isCorrect = true;
            } else {
                System.out.println("Not a valid choice. Try again.");
            }
        }

        System.out.println("\nBooks in your recommendation:");
        for (Book b : selectedRecommendation.getBooks()) {
            System.out.println("  " + b.getTitle());
        }
    }

    public void removeABookFromRecommendation() {
        System.out.println("Select a book to remove: ");
        int count = 0;
        for (Book b : selectedRecommendation.getBooks()) {
            System.out.println(++count + ". " + b.getTitle());
        }

        boolean isCorrect = false;
        while (!isCorrect) {
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index <= selectedRecommendation.getBooks().size() - 1) {
                Book book = selectedRecommendation.getBooks().get(index);
                selectedRecommendation.removeBook(book);
                isCorrect = true;
            } else {
                System.out.println("Not a valid choice. Try again.");
            }
        }

        System.out.println("\nBooks in your recommendation:");
        for (Book b : selectedRecommendation.getBooks()) {
            System.out.println("  " + b.getTitle());
        }
    }

    public void saveRecommendation() {
        recommendations.add(selectedRecommendation);
        selectedRecommendation = null;
    }

    public void clearRecommendation() {
        selectedRecommendation = null;
    }

    public void start() {
        Recommendation rec1 = new Recommendation("For Horror Enthusiasts");
        Recommendation rec2 = new Recommendation("For Comfort Seekers");
        Recommendation rec3 = new Recommendation("For Adventurers");

        Book book1 = new Book("Pet Sematary", "Stephen King", "Supernatural Horror");
        Book book2 = new Book("The Haunting of Hill House", "Shirley Jackson", "Supernatural Horror");
        Book book3 = new Book("Frankenstein", "Mary Shelley", "Gothic Horror");
        Book book4 = new Book("The Call of Cthulhu", "H. P. Lovecraft", "Cosmic Horror");
        rec1.addBook(book1);
        rec1.addBook(book2);
        rec1.addBook(book3);
        rec1.addBook(book4);
        booksInSystem.add(book1);
        booksInSystem.add(book2);
        booksInSystem.add(book3);
        booksInSystem.add(book4);

        Book book5 = new Book("The Secret Garden", "Frances Hodgson Burnett", "Drama");
        Book book6 = new Book("Little Women", "Louisa May Alcott", "Coming-of-Age");
        Book book7 = new Book("Pride and Prejudice", "Jane Austen", "Romance");
        Book book8 = new Book("Where the Crawdads Sing", "Delia Owens", "Mystery");
        rec2.addBook(book5);
        rec2.addBook(book6);
        rec2.addBook(book7);
        rec2.addBook(book8);
        booksInSystem.add(book5);
        booksInSystem.add(book6);
        booksInSystem.add(book7);
        booksInSystem.add(book8);

        Book book9 = new Book("Life of Pi", "Yann Martel", "Adventure");
        Book book10 = new Book("The Count of Monte Cristo", "Alexandre Dumas", "Historical Drama");
        Book book11 = new Book("The Hobbit", "J. R. R. Tolkien", "Fantasy");
        Book book12 = new Book("Moby-Dick", "Herman Melville", "Adventure");
        rec3.addBook(book9);
        rec3.addBook(book10);
        rec3.addBook(book11);
        rec3.addBook(book12);
        booksInSystem.add(book9);
        booksInSystem.add(book10);
        booksInSystem.add(book11);
        booksInSystem.add(book12);

        recommendations.add(rec1);
        recommendations.add(rec2);
        recommendations.add(rec3);

        currentState = new StartState(this);
        operate();
    }
}
