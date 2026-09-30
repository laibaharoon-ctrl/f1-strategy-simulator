public class Driver {
    private final String name;
    private final Team team;
    private final Car car;
    private final double skillRating; // 0.95 - 1.05
    private Strategy strategy;
    private double totalTimeSeconds;
    private int position;

    public Driver(String name, Team team, Car car, double skillRating, Strategy strategy) {
        this.name = name;
        this.team = team;
        this.car = car;
        this.skillRating = skillRating;
        this.strategy = strategy;
    }

    public double calculateLapTime(Track track, Weather weather) {
        double fuelPenalty = car.getFuelLoadKg() * 0.035;
        double tirePenalty = car.getTireWear() * 3.0;
        double weatherPenalty = weather.getPenaltyFor(car.getCurrentTire());

        return (track.getBaseLapTimeSeconds()
                + car.getCurrentTire().getPaceMultiplier()
                + fuelPenalty
                + tirePenalty
                + weatherPenalty) * skillRating;
    }

    public void completeLap(double lapTime) {
        totalTimeSeconds += lapTime;
        car.consumeFuel(1.5);
        car.wearTires();
    }

    // getters/setters
    public String getName() { return name; }
    public Team getTeam() { return team; }
    public Car getCar() { return car; }
    public double getTotalTimeSeconds() { return totalTimeSeconds; }
    public Strategy getStrategy() { return strategy; }
    public int getPosition() { return position; }
    public void setPosition(int p) { this.position = p; }
}
