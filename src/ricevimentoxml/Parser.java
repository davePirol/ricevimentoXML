package ricevimentoxml;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {

    private List corsi,consigli,albo;

    public Parser() {
        albo = new ArrayList();
    }

    public List parseDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document;
        Element root, element;
        NodeList nodelist;
        Prof p;
        // creazione dell’albero DOM dal documento XML
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(filename);
        root = document.getDocumentElement();
        
        nodelist = root.getElementsByTagName("tr");
        int count=0;
        if (nodelist != null && nodelist.getLength() > 0) {
            
            boolean trovato=false;
            
            while(!trovato){
                if(nodelist.item(count).getFirstChild().getTextContent().contains("DOCENTE"))
                    trovato=true;
                count++;
            }
            for (int i = count; i < nodelist.getLength(); i++) {
                element = (Element) nodelist.item(i);
                p = getProf(element);
                System.out.println(p.toString());
                if (p != null) 
                    albo.add(p);               
            }
        }
        return albo;
    }
    
    

    private Prof getProf(Element el) {
        Prof p = null;

        // cerco il primo elemento nel primo tr
        //Element elementParent = (Element) el.getParentNode();
        String IDstringa = el.getChildNodes().item(0).getTextContent(); //getTextValue(elementParent, "td", 0);
        String nome = el.getChildNodes().item(1).getTextContent(); //getTextValue(elementParent, "td", 1);
        String giorno = el.getChildNodes().item(2).getTextContent(); //getTextValue(elementParent, "td", 2);
        String ora = el.getChildNodes().item(3).getTextContent(); //getTextValue(elementParent, "td", 3);
        String commento = el.getChildNodes().item(4).getTextContent(); //getTextValue(elementParent, "td", 3);

        
        //sistemo i dati del professore
        int ID=Integer.parseInt(IDstringa);
        

        //creo l'oggetto del prof
        p = new Prof(ID,ora,nome,giorno,commento);
        return p;
    }
    
    

    // restituisce il valore testuale dell’elemento figlio specificato
    private String getTextValue(Element element, String tag, int child) {
        String value = null;
        NodeList nodelist;
        nodelist = element.getElementsByTagName(tag);
        if (nodelist != null && nodelist.getLength() > child) {
            Node nodeChild = nodelist.item(child).getFirstChild();
            if ((nodeChild != null) && nodeChild.hasChildNodes()) {
                value = nodeChild.getFirstChild().getNodeValue();
            }
        }
        return value;
    }

}
