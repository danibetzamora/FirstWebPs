package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daniel BZ
 */
public class Catalogo {

    private static Catalogo catalogoInstance;
    private static ArrayList<Producto> catalogo;
    
    private Catalogo() {
        
        catalogo = new ArrayList();
        JSONParser parser = new JSONParser();
        
        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\FirstWebPs\\books.json"));
            JSONArray jsonObject = (JSONArray) obj;
            
            Random rnd = new Random();
            DecimalFormatSymbols mySeparador = new DecimalFormatSymbols();
            mySeparador.setDecimalSeparator('.');
            DecimalFormat myFormat = new DecimalFormat("0.00", mySeparador);
            
            for (int i=0; i < jsonObject.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonObject.get(i);
                
                this.catalogo.add(new Producto((String) jsonObject1.get("author"),
                                               (String) jsonObject1.get("title"), 
                                               (Long) jsonObject1.get("pages"), 
                                                Double.parseDouble(myFormat.format((rnd.nextDouble() * 15 + 2))), 
                                                1, (String) jsonObject1.get("imageLink"))); 
            }

        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ParseException e) {
            
        }
            
    }
    
    public static Catalogo getCatalogoInstance() {
        if(catalogoInstance == null) { 
            catalogoInstance = new Catalogo();
        }
        return catalogoInstance;
    }
    
    public ArrayList<Producto> getCatalogo() {
        return this.catalogo;
    }
    
}
