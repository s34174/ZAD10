public abstract class Container {
    protected String serialNumber;
    protected double height;
    protected double depth;
    protected double emptyWeight;
    protected double maxLoadWeight;
    protected double currentLoad;

    public Container(String serialNumber, double height, double depth, double emptyWeight, double maxLoadWeight) {
        this.serialNumber = serialNumber;
        this.height = height;
        this.depth = depth;
        this.emptyWeight = emptyWeight;
        this.maxLoadWeight = maxLoadWeight;
        this.currentLoad = 0;
    }

    public void loadCargo(double weight) throws Exception {
        if (currentLoad + weight > maxLoadWeight) {
            throw new Exception("OverfillException: cargo exceeds max load weight.");
        }
        currentLoad += weight;
    }

    public void unloadCargo() {
        currentLoad = 0;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}