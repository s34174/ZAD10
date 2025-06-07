public class LiquidContainer extends Container implements IHazardNotifier {
    private boolean isHazardous;

    public LiquidContainer(String serialNumber, double height, double depth, double emptyWeight, double maxLoadWeight, boolean isHazardous) {
        super(serialNumber, height, depth, emptyWeight, maxLoadWeight);
        this.isHazardous = isHazardous;
    }

    @Override
    public void loadCargo(double weight) throws Exception {
        double limit = isHazardous ? maxLoadWeight * 0.5 : maxLoadWeight * 0.9;
        if (currentLoad + weight > limit) {
            notifyHazard(serialNumber);
            throw new Exception("Hazardous load limit exceeded.");
        }
        currentLoad += weight;
    }

    @Override
    public void notifyHazard(String containerSerialNumber) {
        System.out.println("Hazard alert: LiquidContainer " + containerSerialNumber);
    }
}
