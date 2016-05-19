/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t3;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;

/**
 *
 * @author rodrigo
 */
@WebService(serviceName = "tarea3")
public class tarea3 {

    
    @WebMethod(operationName = "hello")
    public String[] hello(@WebParam(name = "pais") String pais) {
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gws = gw.getGlobalWeatherSoap();
        
        String r1 = gws.getCitiesByCountry(pais);
        
        Airport air = new Airport();
        AirportSoap airSoap = air.getAirportSoap();
        
        String r2 = airSoap.getAirportInformationByCountry(pais);
        
        String[] answer = new String [3];
        answer[0]=r1;
        answer[1]=r2;
        answer[2]=pais;
        
        return answer;
        
    }
}
