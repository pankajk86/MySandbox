package goal.design.system.parkinglot;

import java.util.Arrays;

public class ParkingLotTest {

    public static void main(String[] args) {

        // number of spots of each types 20
        final int LEVEL_0_TYPE_CAP = 21;

        ParkingLevel level0 = new ParkingLevel(1, LEVEL_0_TYPE_CAP - 1);
        // ParkingLevel level1 = new ParkingLevel(0, 60);
        // ParkingLevel level2 = new ParkingLevel(0, 30);

        ParkingLot parkingLot = new ParkingLot(Arrays.asList(level0));
        ParkingSpot spot = null;

        for (int i = 1; i < LEVEL_0_TYPE_CAP; i++) {
            if (i <= 20) {
                spot = new ParkingSpot(level0, i, LEVEL_0_TYPE_CAP, VehicleSize.SMALL);
            } else if (i > 20 && i <= 40) {
                spot = new ParkingSpot(level0, i, LEVEL_0_TYPE_CAP, VehicleSize.COMPACT);
            } else if (i > 40 && i <= 60) {
                spot = new ParkingSpot(level0, i, LEVEL_0_TYPE_CAP, VehicleSize.LARGE);
            }
            level0.addSpots(spot);
        }

        Vehicle motorcycle = new MotorCycle();
        // System.out.println(motorcycle.canFitInSpot(s));
    }

}
