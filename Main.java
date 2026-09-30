import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Track monza = new Track("Monza", 53, 82.0, 22.0, 0.15);

        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("YOU", new Team("Your Team", 1.0),
                new Car(TireCompound.MEDIUM, 100), 1.00, new BalancedStrategy()));
        drivers.add(new Driver("Verstappen", new Team("Red Bull", 1.0),
                new Car(TireCompound.MEDIUM, 100), 0.97, new AggressiveStrategy()));
        drivers.add(new Driver("Hamilton", new Team("Ferrari", 1.0),
                new Car(TireCompound.HARD, 100), 0.98, new BalancedStrategy()));
        drivers.add(new Driver("Norris", new Team("McLaren", 1.0),
                new Car(TireCompound.SOFT, 100), 0.975, new ConservativeStrategy()));

        Race race = new Race(monza, drivers, Weather.DRY);
        race.run();
    }
}
