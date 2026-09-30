 public enum Weather {
    DRY(0, 0, 0),
    LIGHT_RAIN(2.0, 0.5, 8.0),
    HEAVY_RAIN(4.0, 2.0, 12.0);

    private final double dryTirePenalty;
    private final double interPenalty;
    private final double wetPenalty;

    Weather(double dryTirePenalty, double interPenalty, double wetPenalty) {
        this.dryTirePenalty = dryTirePenalty;
        this.interPenalty = interPenalty;
        this.wetPenalty = wetPenalty;
    }

    public double getPenaltyFor(TireCompound tire) {
        return switch (tire) {
            case SOFT, MEDIUM, HARD -> dryTirePenalty;
            case INTERMEDIATE -> interPenalty;
            case WET -> wetPenalty;
        };
    }
}
