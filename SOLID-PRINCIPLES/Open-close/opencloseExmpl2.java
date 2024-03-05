
// READ COMMENTS FOR BETTER UNDERSTANDING OF CODE STEP BY STEP.

// Let's say we have a system that calculates the total cost of a shopping cart. 
// Initially, we have two types of items: StandardItem and DiscountedItem. 
// Both types of items have a calculatePrice method, but DiscountedItem applies 
// a discount before calculating the price.

interface item {
    public double calculatePrice();
}

class StandardItem implements Item
{
    private double _price;

    public StandardItem(double price)
    {
        _price = price;
    }

    @Override
    public  double CalculatePrice()
    {
        return _price;
    }
}

class DiscountedItem implements Item
{
    private double _price;
    private double _discount;

    public DiscountedItem(double price, double discount)
    {
        _price = price;
        _discount = discount;
    }

    @Override
    public  double CalculatePrice()
    {
        return _price - (_price * _discount);
    }
}

// Now, let's say we want to add a new type of item called BulkItem, 
// which applies a bulk discount for purchasing a certain quantity. We can do this 
// without modifying the existing Item classes by creating a new class that extends Item 

public class BulkItem implements Item
{
    private double _pricePerUnit;
    private int _quantityThreshold;
    private double _discount;

    public BulkItem(double pricePerUnit, int quantityThreshold, double discount)
    {
        _pricePerUnit = pricePerUnit;
        _quantityThreshold = quantityThreshold;
        _discount = discount;
    }

    @Override
    public  double CalculatePrice()
    {
        int quantity = GetQuantity();
        if (quantity >= _quantityThreshold)
        {
            return quantity * _pricePerUnit * (1 - _discount);
        }
        else
        {
            return quantity * _pricePerUnit;
        }
    }

    private int GetQuantity()
    {
        // Implementation of how to get the quantity of this item in the cart
        return 0; // Placeholder implementation
    }
}


public class opencloseExmpl2 {
   public static void main(String[] args) {
       
   } 
}
