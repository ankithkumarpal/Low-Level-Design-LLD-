
// READ COMMENTS STEP BY STEP TO UNDERSTAND THE PRINCIPLE: 

// the PrinterScanner class implements the IDevice interface, which includes both the Print 
// and Scan methods. However, this violates the Interface Segregation Principle because not all 
// devices may support both printing and scanning.



// For example, if we have a simple printer that can only print but not scan, it would still need to implement the Scan method, 
// even though it doesn't make sense for it to do so. This creates a situation where the IDevice interface includes methods that
// are not relevant to all implementing classes, leading to unnecessary dependencies and potential confusion.

interface IDevice
{
    void Print(string document);
    string Scan();
}

class PrinterScanner implements IDevice
{
    public void Print(string document)
    {
        // print 
    }

    public string Scan()
    {
        return "Scanned content";
    }
}


public class ruleViolation {
    public static void main(String[] args) {
        
    }
}
