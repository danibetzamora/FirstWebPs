package model;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
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

    private static Catalogo oficialCatalogo;
    private static ArrayList<Producto> catalogo;
    
    
   
    private Catalogo() {
        catalogo = new ArrayList();
        JSONParser parser = new JSONParser();
        boolean control = true;
        
        try {

            Object obj = parser.parse(new FileReader("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\FirstWebPs\\books.json"));

            JSONArray jsonObject = (JSONArray) obj;
            Random rnd = new Random();
            
            for (int i = 0; i<jsonObject.size(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonObject.get(i);
                this.catalogo.add(new Producto((String) jsonObject1.get("author"),(String) jsonObject1.get("title"), (Long) jsonObject1.get("pages"), (double)Math.round((rnd.nextDouble() * 15 + 2) * 100d) / 100d, 1, (String) jsonObject1.get("imageLink")));
                
            }
            //String name = (String) jsonObject.get("author");
            //System.out.println(name);
           

         

        } catch (FileNotFoundException e) {
            
        } catch (IOException e) {
            
        } catch (ParseException e) {
            
        }
        
        
        
    }
    
    public static Catalogo getObjectCatalogo() {
        if(oficialCatalogo == null) { 
            oficialCatalogo = new Catalogo();
        }
        return oficialCatalogo;
    }
    
    public ArrayList<Producto> getCatalogo() {
        return this.catalogo;
    }
}
