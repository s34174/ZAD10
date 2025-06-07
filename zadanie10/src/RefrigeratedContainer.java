public class RefrigeratedContainer extends Container {
    private String productType;
    private double temperature;

    public RefrigeratedContainer(String serialNumber, double height, double depth, double emptyWeight, double maxLoadWeight, String productType, double temperature) {
        super(serialNumber, height, depth, emptyWeight, maxLoadWeight);
        this.productType = productType;
        this.temperature = temperature;
    }

    public String getProductType() {
        return productType;
    }

    public double getTemperature() {
        return temperature;
    }

    public void validateTemperature(double requiredTemp) throws Exception {
        if (temperature < requiredTemp) {
            throw new Exception("Temperature too low for product " + productType);
        }
    }
}