enum SpotType {
    COMPACT, LARGE, DISABLED, MOTORCYCLE
}

enum VehicleType {
    COMPACT, LARGE, DISABLED, MOTORCYCLE
}

class Vehicle {
    int id ; 
    VehicleType type ; 
}

class ParkingSpot {
    int id ; 
    Vehicle vehicle ; 
    boolean isOccupied ; 
    SpotType spotType ; 
}

public class ParkingLot {
    public static void main(String[] args) {
        
    }
}
