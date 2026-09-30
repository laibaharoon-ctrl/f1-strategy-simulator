public class Team {
    private final String name;
    private final double performanceFactor; // 1.0 = neutral, <1.0 faster car

    public Team(String name, double performanceFactor) {
        this.name = name;
        this.performanceFactor = performanceFactor;
    }

    public String getName() {
        return name;
    }

    public double getPerformanceFactor() {
        return performanceFactor;
    }

    @Override
    public String toString() {
        return name;
    }
}