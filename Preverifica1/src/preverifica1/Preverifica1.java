/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preverifica1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author gianlucanarducci
 */
public class Preverifica1 {

    /**
     * @param args the command line arguments
     */
    
         
     public static void main(String[] args) {
        List docenti = null;
        Parser dom = new Parser();
        String giorno;
        String docente;
        InputStreamReader input= new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);
        int scelta;
        
        
        try {
            System.out.println("Selezionare il tipo di ricerca:");
            System.out.println("1)Ricerca per giorno");
            System.out.println("2)Ricerca per docente");
            scelta=Integer.parseInt(tastiera.readLine());
            switch(scelta){
                case 1:
                    System.out.println("INSERIRE IL GIORNO");
                    giorno=tastiera.readLine();
                    docenti = dom.parseDocumentGiorno("RicevimentoDocenti.xml",giorno);
                    break;
                case 2:
                    System.out.println("INSERIRE IL DOCENTE");
                    docente= tastiera.readLine();
                    docenti = dom.parseDocumentDocente("RicevimentoDocenti.xml",docente);
                    break;
                default:
                    System.out.println("Inserimento non riconosciuto");
                    break;
            }
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            System.out.println("Errore!");
        }
        // iterazione della lista e visualizzazione degli oggetti
        Iterator iterator = docenti.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
     }
    
}
