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
public class Variable
{
    public Variable(String v, String u, String p, double va)
    {
        varName=v;
        units=u;
        prefix=p;
        value=va;
    }
    
    public void convertLength(String nu)//get new value and scientific notation value based on input units and prefix.
    {
        //length
        for(int j=0; j<lengthUnits.length; j++)
            if(units.equals(lengthUnits[j]))
                for(int k=0; k<lengthUnits.length; k++)
                    if(nu.equals(lengthUnits[k]))
                        value=value*lengthValues[k]/lengthValues[j];
        units=nu;
    }
    public void convertAngles(String nu)
    {
        //angles
        for(int j=0; j<angleUnits.length; j++)
            if(units.equals(angleUnits[j]))
                for(int k=0; k<angleUnits.length; k++)
                    if(nu.equals(angleUnits[k]))
                        value=value*angleValues[k]/angleValues[j];
        units=nu;
    }
    public void convertPower(String nu)
    {
        //power
        for(int j=0; j<powerUnits.length; j++)
            if(units.equals(powerUnits[j]))
                for(int k=0; k<powerUnits.length; k++)
                    if(nu.equals(powerUnits[k]))
                        value=value*powerValues[k]/powerValues[j];
        units=nu;
    }
    public void convertPowerFlux(String nLength, String nPower, String npLength, String npPower)
    {
        
    }
    public void convertPrefix(String np)
    {
        for(int j=0; j<prefixes.length; j++)
            if(prefix.equals(prefixes[j]))
                    for(int k=0; k<prefixes.length;k++)
                        if(np.equals(prefixes[k]))
                            value=value*prefixValues[j]/prefixValues[k];
        prefix=np;  
    }
    
    @Override
    public String toString()//presents the name, value, units, prefix, scinot information in presentable form
    {
        return varName+": "+value+" "+prefix+units;
    }
    
    public String varName;
    public String units;
    public String prefix;
    public double value;
    public static String prefixes[]={"yocto", "zepto", "atto", "femto", "pico", "nano", "micro", "milli", "centi", "deci", "","deka","hecto","kilo","mega","giga","tetra","peta","exa","zetta","yotta"};
    public static double prefixValues[]={Math.pow(10,-24),Math.pow(10,-21),Math.pow(10,-18),Math.pow(10,-15),Math.pow(10,-12),Math.pow(10,-9),Math.pow(10,-6),Math.pow(10,-3),0.01,0.1,1.0,10,100,1000,1000000,Math.pow(10,9),Math.pow(10,12),Math.pow(10,15),Math.pow(10,18),Math.pow(10,21),Math.pow(10,24)};
    public static String lengthUnits[]={"meters", "inches", "feet", "yards", "miles", "au", "light years", "parsecs"};
    public static double lengthValues[]={1.0, 39.3701, 3.28084, 1.09361, 0.000621371,6.6846*Math.pow(10,-12), 1.057*Math.pow(10,-16), 3.2408*Math.pow(10,-17)};
    public static String powerUnits[]={"watts","horsepower"};
    public static double powerValues[]={1.0, 0.00134102};
    public static String angleUnits[]={"degrees","radians","arcminutes","archours","arcseconds"};
    public static double angleValues[]={1.0,0.0174533,60,1.0,3600,};
}
