public class Main {
    public static void main(String[] args) {
        try {
           
            Ship ship1 = new Ship(100_000, 10, 25);
            Ship ship2 = new Ship(80_000, 8, 22);

            LiquidContainer liquid1 = new LiquidContainer("KON-L-001", 200, 300, 500, 5000, true);
            GasContainer gas1 = new GasContainer("KON-G-002", 200, 300, 600, 4000, 2.5);
            RefrigeratedContainer fridge1 = new RefrigeratedContainer("KON-C-003", 250, 350, 700, 3000, "Fish", 2);

            liquid1.loadCargo(2000);
            gas1.loadCargo(3500);
            fridge1.loadCargo(1000);

            ship1.loadContainer(liquid1);
            ship1.loadContainer(gas1);
            ship1.loadContainer(fridge1);

            ship1.printShipInfo();

            RefrigeratedContainer newFridge = new RefrigeratedContainer("KON-C-004", 260, 360, 700, 3000, "Meat", -10);
            newFridge.loadCargo(1200);
            ship1.replaceContainer("KON-C-003", newFridge);

            ship1.transferContainerTo(liquid1, ship2);

            try {
                liquid1.loadCargo(5000);
            } catch (Exception e) {
                System.out.println("⛔ Błąd załadunku: " + e.getMessage());
            }

            ship1.printShipInfo();
            ship2.printShipInfo();

        } catch (Exception e) {
            System.out.println("❌ Błąd systemu: " + e.getMessage());
        }
    }
}