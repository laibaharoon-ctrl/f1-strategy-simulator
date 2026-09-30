public interface Strategy {
    boolean shouldPit(int currentLap, Track track, Car car, Weather weather);
    TireCompound chooseNextTire(Weather weather, int lapsRemaining);
    String getName();
}
