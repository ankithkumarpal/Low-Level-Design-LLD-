// for better understanding first read theory.txt -> ruleViolation.java -> this

interface IPrinter
{
    void Print(string document);
}

public interface IScanner
{
    string Scan();
}


// printer just perform the print functionallity not scan 

public class Printer implements IPrinter
{
    public void Print(string document)
    {
        // print
    }
}

// scanner just perform the scan functionallity not print 

public class Scanner implements IScanner
{
    public string Scan()
    {
        return "Scanned content";
    }
}


// Now, let's say we have a multifunction device that can both print and scan.
//  We can create a new interface, IMultiFunctionDevice, that combines the behaviors of printing 
//  and scanning, and have the multifunction device implement this interface.


// FOCUS ON THIS INTERFACE IT EXTENDS IPRINTER AND ISCANNER BOTH 

interface IMultiFunctionDevice extends IPrinter , IScanner
{
    // No need to add any additional members here
}

public class MultiFunctionDevice implements IMultiFunctionDevice
{
    public void Print(string document)
    {
        // Print
    }

    public string Scan()
    {
        return "Multi-function device scanned content";
    }
}



public class InterfaceSegregation {
    public static void main(String[] args) {
        
    }
}
