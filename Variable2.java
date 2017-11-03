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
public class Variable2 extends Variable
{
    public Variable2(String v, String u, String u2, String p, String p2, double va)
    {
        super(v,u,p,va);
        units2=u2;
        prefix2=p2;
        prefixUnitsDisplay=prefix+units+"/"+prefix2+units2+"^2";
    }
    @Override
    public void convertPowerFlux(String nLength,String nPower, String npLength, String npPower)//includes prefix convsersions
    {
        super.convertLength(nLength);
        for(int j=0; j<powerUnits.length; j++)
            if(units.equals(powerUnits[j]))
                for(int y=0; y<powerUnits.length; y++)
                    if(nPower.equals(powerUnits[y]))
                        for(int k=0; k<lengthUnits.length; k++)
                            if(units2.equals(lengthUnits[k]))
                                for(int z=0; z<lengthUnits.length;z++)
                                    if(nLength.equals(lengthUnits[z]))
                                        for(int h=0; h<prefixes.length;h++)
                                            if(prefix.equals(prefixes[h]))
                                                for(int m=0; m<prefixes.length; m++)
                                                    if(npPower.equals(prefixes[m]))
                                                        for(int n=0; n<prefixes.length;n++)
                                                            if(prefix2.equals(prefixes[n]))
                                                                for(int v=0; v<prefixes.length; v++)
                                                                    if(npLength.equals(prefixes[v]))
                    value=value*(powerValues[y]/powerValues[j]*(prefixValues[h]/prefixValues[m])/Math.pow(powerValues[z]/powerValues[k]*prefixValues[n]/prefixValues[v],2));
        units=nPower;
        units2=nLength;
        prefix=npPower;
        prefix2=npLength;
        prefixUnitsDisplay=prefix+units+"/"+prefix2+units2+"^2";
    }
    @Override
    public String toString()
    {
        return super.varName+": "+super.value+" "+prefixUnitsDisplay;
    }
    public String units2;
    public String prefix2;
    public String prefixUnitsDisplay;
}