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
public class Formulas
{
    public Formulas()
    {
        
    }
    
    public Double parallaxDistance()
    {
        if (parallax==null||distanceTo!=null)
            return 0.0;
        distanceTo=3.086*Math.pow(10,16)/(parallax*3600);
        return distanceTo;
    }
    
    public Double parallaxAngle()
    {
        if (distanceTo==null||parallax!=null)
            return 0.0;
        parallax=1/(3600*distanceTo/(3.086*Math.pow(10,16)));
        return parallax;
    }
    
    public Double luminosityLuminosity()
    {
        if (distanceTo==null||brightnessFlux==null||luminosity!=null)
            return 0.0;
        luminosity=4*Math.PI* Math.pow(distanceTo, 2)*brightnessFlux;
        return luminosity;
    }
    
    public Double luminosityDistance()
    {
        if (luminosity==null||brightnessFlux==null||distanceTo!=null)
            return 0.0;
        distanceTo=Math.sqrt(luminosity/(4*Math.PI*brightnessFlux));
        return distanceTo;
    }
    
    public Double luminosityBrightness()
    {
        if (luminosity==null||distanceTo==null||brightnessFlux!=null)
            return 0.0;
        brightnessFlux=luminosity/(4*Math.PI*Math.pow(distanceTo, 2));
        return brightnessFlux;
    }
    
    public Double luminosityRatioLuminosity()
    {
        if (distanceTo==null||brightnessFlux==null||luminosity!=null)
            return 0.0;
        luminosity=3.828*Math.pow(10,26)*Math.pow(distanceTo/1.496*Math.pow(10,11), 2)*brightnessFlux/1361.13;
        return luminosity;
    }
    
    public Double luminosityRatioDistance()
    {
        if (luminosity==null||brightnessFlux==null||distanceTo!=null)
            return 0.0;
        distanceTo=1.496*Math.pow(10,11)*Math.pow((luminosity/(3.828*Math.pow(10,26)))/(brightnessFlux/1361.13),0.5);
        return distanceTo;
    }
    
    public Double luminosityRatioBrightness()
    {
        if (luminosity==null||distanceTo==null||brightnessFlux!=null)
            return 0.0;
        brightnessFlux=luminosity*1361.13/(3.828*Math.pow(10,26))/(Math.pow(distanceTo/1.496*Math.pow(10,11), 2));
        return brightnessFlux;
    }
    
    public Double magnitudeRatioMag()
    {
        if (brightnessFlux==null||apparentMag!=null)
            return 0.0;
        apparentMag=-26.7-2.5*Math.log10(brightnessFlux/1361.13);
        return apparentMag;
    }
    
    public Double magnitudeRatioFlux()
    {
        if (apparentMag==null||brightnessFlux!=null)
            return 0.0;
        brightnessFlux=1361.13*Math.pow(10, (apparentMag+26.7)/(-2.5));
        return brightnessFlux;
    }
    
    public Double modulus()
    {
        if (apparentMag==null||absoluteMag==null||modulus!=null)
            return 0.0;
        modulus=apparentMag-absoluteMag;
        return modulus;
    }
    
    public Double modulusApparent()
    {
        if (absoluteMag==null||distanceTo==null||apparentMag!=null)
            return 0.0;
        apparentMag=absoluteMag+5*Math.log10(distanceTo/(3.086*Math.pow(10,16)))-5;
        return apparentMag;
    }
    
    public Double modulusAbsolute()
    {
        if (distanceTo==null||apparentMag==null||absoluteMag!=null)
            return 0.0;
        absoluteMag=-5*Math.log10(distanceTo/(3.086*Math.pow(10,16)))+5+apparentMag;
        return absoluteMag;
    }
    
    public Double modulusDistance()
    {
        if (distanceTo==null||modulus==null||distanceTo!=null)
            return 0.0;
        distanceTo=3.086*Math.pow(10,16)*Math.pow(10,(modulus+5)/5);
        return distanceTo;
    }
    
    public Double parallax, distanceTo, brightnessFlux, luminosity, apparentMag, absoluteMag, modulus;
}
