public class AggressiveStrategy implements Strategy {
    @Override
    public boolean shouldPit(int lap, Track track, Car car, Weather weather) {
        return car.getTireWear() > 0.7 || car.getTireAge() >= car.getCurrentTire().getMaxLaps() - 3;
    }

    @Override
    public TireCompound chooseNextTire(Weather weather, int lapsRemaining) {
        if (weather == Weather.HEAVY_RAIN) return TireCompound.WET;
        if (weather == Weather.LIGHT_RAIN) return TireCompound.INTERMEDIATE;
        return lapsRemaining < 15 ? TireCompound.SOFT : TireCompound.MEDIUM;
    }

    @Override
    public String getName() { return "Aggressive"; }
}
