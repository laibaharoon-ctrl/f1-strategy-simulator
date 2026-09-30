import java.util.*;

public class ConsoleUI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printRaceHeader(Track track, Weather weather) {
        System.out.println("\n🏁 ================================");
        System.out.println("   " + track.getName().toUpperCase() + " GRAND PRIX");
        System.out.println("   Laps: " + track.getTotalLaps() + " | Weather: " + weather);
        System.out.println("🏁 ================================\n");
    }

    public static boolean askPitDecision(Driver driver, int lap, Track track, Weather weather) {
        System.out.printf("Lap %d/%d | Tire: %s (age %d, wear %.0f%%) | Fuel: %.1fkg%n",
                lap, track.getTotalLaps(), driver.getCar().getCurrentTire(),
                driver.getCar().getTireAge(), driver.getCar().getTireWear() * 100,
                driver.getCar().getFuelLoadKg());
        System.out.print("Pit this lap? (y/n): ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    public static TireCompound askTireChoice() {
        System.out.println("Choose tire: [1] SOFT  [2] MEDIUM  [3] HARD  [4] INTER  [5] WET");
        int choice = Integer.parseInt(scanner.nextLine().trim());
        return switch (choice) {
            case 1 -> TireCompound.SOFT;
            case 2 -> TireCompound.MEDIUM;
            case 3 -> TireCompound.HARD;
            case 4 -> TireCompound.INTERMEDIATE;
            case 5 -> TireCompound.WET;
            default -> TireCompound.MEDIUM;
        };
    }

    public static void printLapSummary(int lap, List<Driver> drivers) {
        System.out.println("\n--- Lap " + lap + " ---");
        drivers.stream()
                .sorted(Comparator.comparingInt(Driver::getPosition))
                .forEach(d -> System.out.printf("P%d %-12s %.3fs (tire: %s)%n",
                        d.getPosition(), d.getName(), d.getTotalTimeSeconds(), d.getCar().getCurrentTire()));
    }

    public static void printFinalResults(List<Driver> drivers) {
        System.out.println("\n🏆 ===== FINAL CLASSIFICATION =====");
        drivers.stream()
                .sorted(Comparator.comparingInt(Driver::getPosition))
                .forEach(d -> System.out.printf("P%d %-12s Total: %.3fs%n",
                        d.getPosition(), d.getName(), d.getTotalTimeSeconds()));
    }
}
