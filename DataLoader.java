import java.io.*;
import java.util.*;

public class DataLoader {
    public static List<Driver> loadDrivers(String path) throws IOException {
        List<Driver> drivers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String teamName = parts[1];
                double skill = Double.parseDouble(parts[2]);
                Team team = new Team(teamName, 1.0);
                Car car = new Car(TireCompound.MEDIUM, 100);
                Strategy strategy = new BalancedStrategy();
                drivers.add(new Driver(name, team, car, skill, strategy));
            }
        }
        return drivers;
    }
}
