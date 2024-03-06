import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class randomMap {

    // main functions + navigation in the menu
    public static void main(String[] args)
    {
        // active duty map pool
        String admp_path = "/home/paul/IdeaProjects/cs_map_randomizer/src/data/active_duty_map_pool";
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.println("\nPlease enter a valid number to navigate in the menu.");
            choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        List<String> lines = readLineFromFile(admp_path);
                        if (!admp_path.isEmpty()) {
                            String randomLine = getRandomLine(lines);
                            System.out.println("The randomized map is: " + randomLine);
                        } else {
                            System.out.println("empty file");
                        }
                        break;
                    case 2:
                        System.out.println("exit program");
                        break;
                    default:
                        System.out.println("input invalid");
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                System.out.println("please enter an integer");
                scanner.nextLine();
                choice = -1;
            }
        }
        while (choice != 2) ;
        {
            scanner.close();
        }
    }

    private static List<String> readLineFromFile(String admp_path) throws IOException
    {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(admp_path)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
        }
        return lines;
    }
    private static String getRandomLine(List<String> lines)
    {
        Random random = new Random();
        int randomIndex = random.nextInt(lines.size());
        return lines.get(randomIndex);
    }

    private static void displayMenu()
    {
        System.out.println("\nMenü: ");
        System.out.println("[1.] generate random map");
        System.out.println("[2.] exit program");
    }
}