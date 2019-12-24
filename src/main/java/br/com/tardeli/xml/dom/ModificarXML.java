package br.com.tardeli.xml.dom;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class ModificarXML {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("vereadoresDOM.xml");
        
        Element raiz = document.getDocumentElement();
        
        NodeList vereadoresNodeList = raiz.getElementsByTagName("vereador");
        for (int i = 0; i < vereadoresNodeList.getLength(); i++) {
            Element vereadorElement = (Element) vereadoresNodeList.item(i);
            String nome = vereadorElement.getElementsByTagName("nome").item(0).getTextContent();
            if (nome.equalsIgnoreCase("Nome")) {
                // formato de alteracao 1
                vereadorElement.getElementsByTagName("nome").item(0).setTextContent("Nome alterado - teste");
                
            }
        }
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileOutputStream("vereadoresDOM.xml"));
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer transformer = transFactory.newTransformer();
        transformer.transform(source, result);
    }
}
