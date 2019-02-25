package preverifica1;

import java.io.IOException;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List docenti;

    public Parser() {
        docenti = new ArrayList();
    }

    public List parseDocument(String filename, String giorno)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        String docente="";
        boolean coincide=false;
        
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        // generazione della lista degli elementi "link"
        nodelist = root.getElementsByTagName("tr");
        if (nodelist != null && nodelist.getLength() > 0) {
            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                NodeList td = element.getElementsByTagName("td");
                for (int j = 0; j < td.getLength(); j++) {
                    element = (Element) td.item(j);
                    if (element != null && element.getFirstChild() != null) {
                        docente += GetContent(element)+ " ";
                        if (GetContent(element).equals(giorno)) {
                            coincide=true;
                        }
                    }
                }
                if (coincide==true){
                    System.out.println(docente);
                }
                docente="";
                coincide=false;
            }
        }
        return docenti;
    }

    private String GetContent(Element element) {
        return element.getFirstChild().getNodeValue();
    }

    private Docente GetDocente(Element element) {
        Docente docente = null;
        String cognome = element.getAttribute("td");
        String giornoRicevimento = getTextValue(element, "titolo");
        String oraRicevimento = getTextValue(element, "autore");
        String note = getTextValue(element, "autore");
        docente = new Docente(cognome, giornoRicevimento, oraRicevimento, note);
        return docente;
    }

    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag) {
        String tmp = "";
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);

        if (nodelist != null && nodelist.getLength() > 0) {
            docenti.add(element);

            for (int i = 0; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                if (element != null && element.getFirstChild() != null) {
                    tmp += element.getFirstChild().getNodeValue() + " ";
                }
            }
        }
        return tmp;
    }

// restituisce il valore intero dell’elemento figlio specificato
    private int getIntValue(Element element, String tag) {
        return Integer.parseInt(getTextValue(element, tag));
    }

    // restituisce il valore numerico dell’elemento figlio specificato
    private float getFloatValue(Element element, String tag) {
        return Float.parseFloat(getTextValue(element, tag));
    }

}
