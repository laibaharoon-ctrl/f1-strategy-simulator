 public enum TireCompound {
    SOFT(1.0, 1.8, 15),      // paceMultiplier, degRate, maxLaps
    MEDIUM(1.3, 1.2, 25),
    HARD(1.7, 0.8, 40),
    INTERMEDIATE(2.5, 2.0, 30),
    WET(4.0, 1.5, 35);

    private final double paceMultiplier;
    private final double degradationRate;
    private final int maxLaps;

    TireCompound(double paceMultiplier, double degradationRate, int maxLaps) {
        this.paceMultiplier = paceMultiplier;
        this.degradationRate = degradationRate;
        this.maxLaps = maxLaps;
    }

    public double getPaceMultiplier() { return paceMultiplier; }
    public double getDegradationRate() { return degradationRate; }
    public int getMaxLaps() { return maxLaps; }
}
