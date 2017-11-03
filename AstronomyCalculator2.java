/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronomycalculator2;

/**
 *
 * @author jasonkim
 */
import java.util.*;
public class AstronomyCalculator2
{
    List <Variable> inputs;
    public AstronomyCalculator2(List <Variable> ips)
    {
        inputs=ips;
    }
    
    public void convertSI() //converts ips to SI units
    {
        for(Variable y: inputs)
        {
            if(y.varName.equals("Parallax"))
            {
                y.convertAngles("degrees");
                y.convertPrefix("");
            }
            else if(y.varName.equals("Distance To Object"))
            {
                y.convertLength("meters");
                y.convertPrefix("");
            }
            else if(y.varName.equals("Brightness"))
            {
                y.convertPowerFlux("meters","watts","","");
            }
            else if(y.varName.equals("Luminosity"))
            {
                y.convertPower("watts");
                y.convertPrefix("");
            }
            else if(y.varName.equals("Apparent Magnitude"))
            {
                y.convertPrefix("");
            }
            else if(y.varName.equals("Absolute Magnitude"))
            {
                y.convertPrefix("");
            }
            else if(y.varName.equals("Distance Modulus"))
            {
                y.convertPrefix("");
            }
        }
    }
    
    public List<Variable> calculate()//creates list of calculated values
    {
        Formulas calc=new Formulas();
        for(Variable x: inputs)
        {
            if(x.varName.equals("Parallax"))
                calc.parallax=x.value;
            else if(x.varName.equals("Distance To Object"))
                calc.distanceTo=x.value;
            else if(x.varName.equals("Brightness"))
                calc.brightnessFlux=x.value;
            else if(x.varName.equals("Luminosity"))
                calc.luminosity=x.value;
            else if(x.varName.equals("Apparent Magnitude"))
                calc.apparentMag=x.value;
            else if(x.varName.equals("Absolute Magnitude"))
                calc.absoluteMag=x.value;
            else if(x.varName.equals("Distance Modulus"))
                calc.modulus=x.value;
        }
        for(int j=0; j<14; j++)
        {
            calc.parallaxDistance();
            calc.parallaxAngle();
            calc.luminosityBrightness();
            calc.luminosityDistance();
            calc.luminosityLuminosity();
            calc.luminosityRatioLuminosity();
            calc.luminosityRatioDistance();
            calc.luminosityRatioBrightness();
            calc.magnitudeRatioFlux();
            calc.magnitudeRatioMag();
            calc.modulus();
            calc.modulusApparent();
            calc.modulusAbsolute();
            calc.modulusDistance();
        }
        List<Variable> calcList=new ArrayList <Variable>();
        if(calc.parallax!=null)
            calcList.add(new Variable("Parallax", "degrees", "", calc.parallax));
        if(calc.distanceTo!=null)
            calcList.add(new Variable("Distance To Object", "meters", "", calc.distanceTo));
        if(calc.brightnessFlux!=null)
            calcList.add(new Variable2("Brightness", "watts", "meters","","", calc.brightnessFlux));
        if(calc.luminosity!=null)
            calcList.add(new Variable("Luminosity", "watts", "", calc.luminosity));
        if(calc.apparentMag!=null)
            calcList.add(new Variable("Apparent Magnitude","","",calc.apparentMag));
        if(calc.absoluteMag!=null)
            calcList.add(new Variable("Aboslute Magnitude","","",calc.absoluteMag));
        if(calc.modulus!=null)
            calcList.add(new Variable("Modulus","","",calc.modulus));
        return calcList;
    }
}
