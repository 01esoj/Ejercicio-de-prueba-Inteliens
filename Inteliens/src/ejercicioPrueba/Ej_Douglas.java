package ejercicioPrueba;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * Esta clase recupera el nombre de los perfumes de la pagina que se indica y los vuelca a un array
 * @author: Jose Alvarez Felix
 * @version: 29/01/2023/a
 */
public class Ej_Douglas {
	
	public static void main(String[] args) throws IOException {
		// ESTA OPCION SI SE DESEAN IMPRIMIR TODOS LOS PERFUMES
        // Creo un ArrayList vacio 
        ArrayList<String> arrayPerfumes = new ArrayList<>();
        
        // Me conecto a la url que le paso por parametro
        Document html = getHtml("https://douglas.es/c/perfumes");
        
        // Compruebo que me he conectado con exito
        //System.out.println(html);
        
        // Recojo el ultimo numero de pagina para recorrer el for corrrectamente
        int paginaFinal = Integer.parseInt( html.select("div.rd__pagination").select("span.rd__copytext").last().text() );
        
        for(int i=1; i<=paginaFinal; i++) {
        	// ESTA OPCION SI SE DESEA IMPRIMIR LOS PERFUMES POR PAGINA
        	// Creo un ArrayList vacio 
            //ArrayList<String> arrayPerfumes = new ArrayList<>();
            
        	System.out.println("Numero de pagina: "+i);
        	String urlPaginas = (html.select("div.rd__pagination")).select("a.rd__pagination__next").attr("abs:href");
        	
        	Document urlPagina = getHtml(urlPaginas);
        	
        	// Selecciono los perfumes deseados
            Elements perfumes = urlPagina.select("div.rd__product-tile");
            
            for(Element perfume : perfumes){
                // Recupero el enlace a cada perfume
            	// Con abs trae la ruta absoluta
                String urlPerfume = perfume.select("a").attr("abs:href");
                
                // Me conecto a la url de cada perfume que recorre el forEach
                Document htmlPerfume = getHtml(urlPerfume);
                
                // Compruebo que me he conectado con exito
                //System.out.println(htmlPerfume);
                
                // Al haber un fallo en la pagina web, hay algunos perfumes cuya estructura html es distinta, divido la recogida de la informacion que me interesa
                String nombrePerfume = htmlPerfume.select("h1.rd__headline--130").text();
                arrayPerfumes.add(nombrePerfume);

                String nombrePerfumeJadore = htmlPerfume.select("h2").first().text();
                // Localizo en la pagina web que elementos me provocan conflictos y guardo en el ArrayList solo los que me interesan 
                if(nombrePerfumeJadore.contains("ADORE")){
                    arrayPerfumes.add(nombrePerfumeJadore);
                }
                
                // Debido al fallo de la pagina web, se generaban dos elementos en blanco, con esto me encargo de eliminarlos
                arrayPerfumes.remove("");
            }
            
            // SALEN LOS PERFUMES DE CADA PAGINA
            /*// Imprimo por pantalla el ArrayList
            System.out.println(arrayPerfumes);
            
            // Imprimo por pantalla linea a linea el ArrayList
            for(String nombrePerfume : arrayPerfumes){
                System.out.println(nombrePerfume);
            }*/
            
        }
        
        // SALEN TODOS LOS PERFUMES
        // Imprimo por pantalla el ArrayList
        System.out.println(arrayPerfumes);
        
        // Imprimo por pantalla linea a linea el ArrayList
        for(String nombrePerfume : arrayPerfumes){
            System.out.println(nombrePerfume);
        }
        
    }
    
	/*
	 * Metodo que le paso la url de la pagina web por parametro y me devuelve el codigo de dicha fuente
	 * @param: url
	 * @return: variable de tipo Document
	 */
    private static Document getHtml(String url){
        Document html = null;
        try {
            html = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}
