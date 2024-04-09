package DesignQuestion.Ola_Uber;

import java.util.*;


interface  PricingStrategy {
    double caluclatePrice(Rider rider); 
}

interface MatchingStrategy {
   Driver matchDriver(HashMap<Integer , Driver> drivers);
}  

class Location {
    int x ;
    int y ; 
    Location (int x , int y) {
        this.x=x;
        this.y=y;
    }
}


class Rider {
    int id ; 
    String Name ; 
    int rating ; 

    Rider(int id , String name  , int rating) {
        this.id = id;
        this.Name = name;
        this.rating = rating;
    }

    String getName(){
        return this.Name;
    }

    int getRating() {
        return this.rating;
    }

}


class Driver {
    int id ; 
    String Name ; 
    int rating ;
    boolean isAvailable ; 

    Driver(int id , String name  , int rating) {
        this.id = id;
        this.Name = name;
        this.rating = rating;
    }

    String getName(){
        return this.Name;
    }

    boolean makeAvailable(){
        isAvailable = true;
        return true;
    }

    boolean occupyDriver() {
        isAvailable = false;
        return true;
    }

    int getRating() {
        return this.rating;
    }

}


 class RiderManager {

    private static RiderManager riderManager  = null; 

    HashMap<Integer,Rider> riders = new HashMap<>();

    private RiderManager(){};

    public static RiderManager getInstance() {
        if(riderManager == null) riderManager = new RiderManager();
        return riderManager ; 
    }

    boolean addRider(Rider rider) {
        riders.put(rider.id , rider);
        return true;
    }

    boolean removeRider(int id) {
        if(riders.containsKey(id)) riders.remove(id);
        return true;
    }

}


class DriverManager {

    private static DriverManager driverManager  = null; 

    HashMap<Integer,Driver> drivers = new HashMap<>();

    private DriverManager(){};

    public static DriverManager getInstance() {
        if(driverManager == null) driverManager = new DriverManager();
        return driverManager ; 
    }

    boolean addDriver(Driver driver) {
        drivers.put(driver.id , driver);
        return true;
    }

    boolean removeRider(int id) {
        if(drivers.containsKey(id)) drivers.remove(id);
        return true;
    }

    HashMap<Integer,Driver> getDrivers() {
        return this.drivers;
    }

}


class RatingBasedPricing implements PricingStrategy {

    public double caluclatePrice(Rider rider) {
        if(rider.rating >=4) return 69.00;
        return 99.00;
    }
}

class DefaultPricing implements PricingStrategy {
    public double caluclatePrice(Rider rider) {
        return 99.00;
    }
}

class driverMatching implements MatchingStrategy {

    public Driver matchDriver(HashMap<Integer , Driver> drivers) {
        Driver driver =  drivers.get(1);
        System.out.println(driver.id);
        return driver;
    }
}

class StrategyManager  {

    private static StrategyManager strategyManager ; 

    private StrategyManager() {};

    public static StrategyManager getInstance() {
        if(strategyManager == null) strategyManager = new StrategyManager();
        return strategyManager;
    }

    PricingStrategy getPricingStrategy(){
        return new RatingBasedPricing();
    }

    MatchingStrategy getDriverMatchingStrategy() {
        return new driverMatching();
    }
}


class Trip {
    int id ; 
    Rider rider ; 
    Driver driver ; 
    PricingStrategy pricingStrategy ; 
    MatchingStrategy matchingStrategy ; 
    Double price ;

    Trip(int id , Rider rider , Driver driver , PricingStrategy pricingStrategy , MatchingStrategy matchingStrategy , double price) {
        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.pricingStrategy = pricingStrategy;
        this.matchingStrategy = matchingStrategy;
        this.price = price;
    }    
}


class TripManager {

    private static TripManager tripManager ; 
    private TripManager() {};
    static int counter = 0;

    static TripManager getInstance() {
        if(tripManager == null) tripManager = new TripManager();
        return tripManager;
    }

    Trip createTrip(Rider rider , Location src , Location des) {

        StrategyManager strategyManager = StrategyManager.getInstance();
        DriverManager driverManager = DriverManager.getInstance();

        PricingStrategy pricingStrategy = strategyManager.getPricingStrategy();
        MatchingStrategy matchingStrategy = strategyManager.getDriverMatchingStrategy();

        double price = pricingStrategy.caluclatePrice(rider);
        Driver driver = matchingStrategy.matchDriver(driverManager.getDrivers());
        System.out.println(driver);

        Trip trip = new Trip(counter++ , rider , driver , pricingStrategy , matchingStrategy , price);
        return trip;
    }
}

public class Ola_Uber {

    public static void main(String[] args) {

        DriverManager driverManager = DriverManager.getInstance();
        RiderManager riderManager = RiderManager.getInstance();

        Rider rider = new Rider(1, "ankith", 4);
        Rider rider2 = new Rider(2, "rahul", 2);

        Driver driver = new Driver(1, "salman khan" , 5);
        Driver driver2 = new Driver(2, "Rohit sharma", 1);


        driverManager.addDriver(driver2);
        driverManager.addDriver(driver);

        riderManager.addRider(rider);
        riderManager.addRider(rider2);

        TripManager tripManager = TripManager.getInstance();
        Trip trip = tripManager.createTrip(rider, null, null);
        System.out.println("Trip-Id: " +  trip.id);
        System.out.println("Driver-Id: " +  trip.driver.id);
        System.out.println("Driver-Name: " +  trip.driver.Name);
        System.out.println("Rider Id: " +  trip.rider.id);
        System.out.println("Rider-Name: " + trip.rider.Name);
        System.out.println("Price: " +  trip.price);
    }
}
