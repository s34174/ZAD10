import java.util.ArrayList;
import java.util.List;

public class Ship {
    private List<Container> containers = new ArrayList<>();
    private double maxWeight;
    private int maxContainerCount;
    private double speed;

    public Ship(double maxWeight, int maxContainerCount, double speed) {
        this.maxWeight = maxWeight;
        this.maxContainerCount = maxContainerCount;
        this.speed = speed;
    }

    public void loadContainer(Container container) throws Exception {
        if (containers.size() >= maxContainerCount || getTotalWeight() + container.currentLoad + container.emptyWeight > maxWeight) {
            throw new Exception("Cannot load container: ship overload");
        }
        containers.add(container);
    }

    public void unloadContainer(String serialNumber) {
        containers.removeIf(c -> c.getSerialNumber().equals(serialNumber));
    }

    public void printShipInfo() {
        System.out.println("Ship speed: " + speed + " knots");
        System.out.println("Total containers: " + containers.size());
        for (Container c : containers) {
            System.out.println("- " + c.getSerialNumber() + ": " + c.currentLoad + " kg");
        }
    }

    public double getTotalWeight() {
        return containers.stream().mapToDouble(c -> c.currentLoad + c.emptyWeight).sum();
    }

    public Container findContainer(String serial) {
        return containers.stream().filter(c -> c.getSerialNumber().equals(serial)).findFirst().orElse(null);
    }

    public void replaceContainer(String oldSerial, Container newContainer) throws Exception {
        unloadContainer(oldSerial);
        loadContainer(newContainer);
    }

    public void transferContainerTo(Container container, Ship otherShip) throws Exception {
        unloadContainer(container.getSerialNumber());
        otherShip.loadContainer(container);
    }
}
