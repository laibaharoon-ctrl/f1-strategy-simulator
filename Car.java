 public class Car {
    private double fuelLoadKg;      // 1kg ≈ 0.035s per lap penalty
    private TireCompound currentTire;
    private int tireAge;
    private double tireWear;        // 0.0 = new, 1.0 = dead

    public Car(TireCompound startingTire, double startingFuel) {
        this.currentTire = startingTire;
        this.tireAge = 0;
        this.tireWear = 0.0;
        this.fuelLoadKg = startingFuel;
    }

    public void consumeFuel(double perLap) {
        fuelLoadKg = Math.max(0, fuelLoadKg - perLap);
    }

    public void wearTires() {
        tireAge++;
        tireWear = Math.min(1.0, (double) tireAge / currentTire.getMaxLaps());
    }

    public void pit(TireCompound newTire, double refuel) {
        this.currentTire = newTire;
        this.tireAge = 0;
        this.tireWear = 0.0;
        this.fuelLoadKg += refuel;
    }

    // getters...
    public double getFuelLoadKg() { return fuelLoadKg; }
    public TireCompound getCurrentTire() { return currentTire; }
    public int getTireAge() { return tireAge; }
    public double getTireWear() { return tireWear; }
}
