/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class PruebaFechas {
    
    public static void main(String[] args) throws ParseException {
    Date fecha = new Date(112,11,5);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fecha1 = "12-12-2015";
    String fecha2[]=fecha1.split("-");
    String fechaMysql = fecha2[2]+"-"+fecha2[1]+"-"+fecha2[0];
    String fecha4 = "2015-12-12";
    
    String fechaStr = sdf.format(fecha);
        System.out.println("Fecha sin formato: "+fecha);
        System.out.println("Fecha con formato: "+fechaStr);
        System.out.println("Fecha Mysql : "+fechaMysql);
    Date fecha3;
    fecha3 = sdf.parse(fecha4);

        System.out.println("Fecha parseada : "+sdf.parse(fecha1));    
        System.out.println("Fecha parseada : "+fecha3);    
        
    }
    
    
}
