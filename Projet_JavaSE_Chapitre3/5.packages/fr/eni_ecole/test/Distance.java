package fr.eni_ecole.test;

import static java.lang.Math.*; 

public class Distance 
{ 
    public static double dist(double lat1,double lon1,
                              double lat2,double lon2) 
    { 
        double deltaLat; 
        double abscurv; 
        deltaLat =lon2-lon1; 
        abscurv=acos((sin(lat1) * sin(lat2)) + 
                     (cos(lat1) * cos(lat2) * cos(deltaLat))); 
        return abscurv * 6371598; 
    } 
}
