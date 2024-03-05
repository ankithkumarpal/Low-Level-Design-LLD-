// Before this read theory.txt file 

// In this example, LightSwitch directly depends on the Light class, violating the DIP because LightSwitch is tightly 
// coupled to the concrete Light implementation.


public class Light
{
    public void TurnOn()
    {
        Console.WriteLine("Light is on");
    }

    public void TurnOff()
    {
        Console.WriteLine("Light is off");
    }
}

public class LightSwitch
{
    private Light _light;

    public LightSwitch()
    {
        _light = new Light();
    }

    public void Toggle()
    {
        if (_light != null)
        {
            if (_light.IsOn)
            {
                _light.TurnOff();
            }
            else
            {
                _light.TurnOn();
            }
        }
    }
}


public class ruleViolation {
    public static void main(String[] args) {
        
    }
}
