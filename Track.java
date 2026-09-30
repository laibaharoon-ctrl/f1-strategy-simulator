 public class Track {
    private final String name;
    private final int totalLaps;
    private final double baseLapTimeSeconds;
    private final double pitStopLossSeconds;
    private final double safetyCarProbability;

    public Track(String name, int totalLaps, double baseLapTimeSeconds,
                 double pitStopLossSeconds, double safetyCarProbability) {
        this.name = name;
        this.totalLaps = totalLaps;
        this.baseLapTimeSeconds = baseLapTimeSeconds;
        this.pitStopLossSeconds = pitStopLossSeconds;
        this.safetyCarProbability = safetyCarProbability;
    }

    // getters...
    public String getName() { return name; }
    public int getTotalLaps() { return totalLaps; }
    public double getBaseLapTimeSeconds() { return baseLapTimeSeconds; }
    public double getPitStopLossSeconds() { return pitStopLossSeconds; }
    public double getSafetyCarProbability() { return safetyCarProbability; }
}
