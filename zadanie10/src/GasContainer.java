public class GasContainer extends Container implements IHazardNotifier {
    private double pressure;

    public GasContainer(String serialNumber, double height, double depth, double emptyWeight, double maxLoadWeight, double pressure) {
        super(serialNumber, height, depth, emptyWeight, maxLoadWeight);
        this.pressure = pressure;
    }

    @Override
    public void unloadCargo() {
        currentLoad *= 0.05; // leave 5%
    }

    @Override
    public void notifyHazard(String containerSerialNumber) {
        System.out.println("Hazard alert: GasContainer " + containerSerialNumber + " with pressure: " + pressure);
    }

    @Override
    public void loadCargo(double weight) throws Exception {
        if (currentLoad + weight > maxLoadWeight) {
            notifyHazard(serialNumber);
            throw new Exception("OverfillException in GasContainer");
        }
        currentLoad += weight;
    }
}
