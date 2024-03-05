// Before this read ruleViolation.java file 
// this is improvised version of that code which violates dependency inversion principle 


// To improve this design and adhere to the DIP, we can introduce an interface ILight that 
// Light implements, and then LightSwitch can depend on ILight instead of Light directly:


public interface ILight
{
    void TurnOn();
    void TurnOff();
}

public class Light implements ILight
{
    public void TurnOn()
    {
       // turn on 
    }

    public void TurnOff()
    {
        // turn off 
    }
}

public class LightSwitch
{
    private ILight _light;

    public LightSwitch(ILight light)
    {
        _light = light;
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


public class DependencyInversion {
    public static void main(String[] args) {
        
    }
}
