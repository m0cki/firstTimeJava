import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class randomMap {

    public static void main(String[] args)
    {
        // active duty map pool
        String admp_path = "/home/paul/IdeaProjects/cs_map_randomizer/src/data/active_duty_map_pool";

        try
        {
            List<String> lines = readLineFromFile(admp_path);
            if (!admp_path.isEmpty())
            {
                String randomLine = getRandomLine(lines);
                System.out.println("The randomized map is: " + randomLine);
            }
            else
            {
                System.out.println("File is empty");
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
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
}