import java.util.*;

public class Race {
    private final Track track;
    private final List<Driver> drivers;
    private Weather weather;
    private Driver playerDriver;
    private final Random random = new Random();

    public Race(Track track, List<Driver> drivers, Weather weather) {
        this.track = track;
        this.drivers = drivers;
        this.weather = weather;
        this.playerDriver = drivers.get(0); // first is player
    }

    public void run() {
        ConsoleUI.printRaceHeader(track, weather);

        for (int lap = 1; lap <= track.getTotalLaps(); lap++) {
            weather = maybeChangeWeather();

            for (Driver driver : drivers) {
                // AI pit decisions
                if (driver != playerDriver && driver.getStrategy().shouldPit(lap, track, driver.getCar(), weather)) {
                    TireCompound next = driver.getStrategy().chooseNextTire(weather, track.getTotalLaps() - lap);
                    driver.getCar().pit(next, 0);
                    driver.completeLap(track.getPitStopLossSeconds() * 20);
                    continue;
                }

                // Player decision handled by ConsoleUI
                if (driver == playerDriver) {
                    if (ConsoleUI.askPitDecision(driver, lap, track, weather)) {
                        TireCompound next = ConsoleUI.askTireChoice();
                        driver.getCar().pit(next, 0);
                    }
                }

                double lapTime = driver.calculateLapTime(track, weather);
                driver.completeLap(lapTime);
            }

            updatePositions();
            ConsoleUI.printLapSummary(lap, drivers);
        }

        ConsoleUI.printFinalResults(drivers);
    }

    private Weather maybeChangeWeather() {
        if (random.nextDouble() < 0.05) {
            Weather[] options = Weather.values();
            return options[random.nextInt(options.length)];
        }
        return weather;
    }

    private void updatePositions() {
        List<Driver> sorted = new ArrayList<>(drivers);
        sorted.sort(Comparator.comparingDouble(Driver::getTotalTimeSeconds));
        for (int i = 0; i < sorted.size(); i++) {
            sorted.get(i).setPosition(i + 1);
        }
    }
}
