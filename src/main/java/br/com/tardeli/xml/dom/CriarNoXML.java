package br.com.tardeli.xml.dom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.xml.sax.SAXException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class CriarNoXML {

    public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("vereadoresDOM.xml");

        try {
            Element raiz = document.getDocumentElement();
            Element vereadorElement = document.createElement("vereador");

            Element codigoElement = document.createElement("codigo");
            codigoElement.appendChild(document.createTextNode("19"));
            Element nomeElement = document.createElement("nome");
            nomeElement.appendChild(document.createTextNode("NOVO NÓ"));
            Element dataElement = document.createElement("dataAssociacao");
            dataElement.appendChild(document.createTextNode(converteDataParaString(new Date())));
            Element desempenhoElement = document.createElement("desempenho");
            desempenhoElement.appendChild(document.createTextNode("100"));

            Element partidoElement = document.createElement("partido");
            Element numeroPartidoElement = document.createElement("numero");
            numeroPartidoElement.appendChild(document.createTextNode("100"));
            Element nomePartidoElement = document.createElement("nome");
            nomePartidoElement.appendChild(document.createTextNode("MN"));

            Element projetosElement = document.createElement("projetos");

            Element projetoElement = document.createElement("projeto");
            Element codigoProjetoElement = document.createElement("codigo");
            codigoProjetoElement.appendChild(document.createTextNode("19"));
            Element nomeProjetoElement = document.createElement("nome");
            nomeProjetoElement.appendChild(document.createTextNode("NOVO NÓ - teste"));
            Element apresentadoElement = document.createElement("apresentado");
            apresentadoElement.appendChild(document.createTextNode("true"));
            Element aprovadoElement = document.createElement("aprovado");
            aprovadoElement.appendChild(document.createTextNode("true"));

            vereadorElement.appendChild(codigoElement);
            vereadorElement.appendChild(nomeElement);
            vereadorElement.appendChild(dataElement);
            vereadorElement.appendChild(desempenhoElement);
            partidoElement.appendChild(numeroPartidoElement);
            partidoElement.appendChild(nomePartidoElement);
            projetoElement.appendChild(codigoProjetoElement);
            projetoElement.appendChild(nomeProjetoElement);
            projetoElement.appendChild(apresentadoElement);
            projetoElement.appendChild(aprovadoElement);

            raiz.appendChild(vereadorElement);
            vereadorElement.appendChild(partidoElement);
            vereadorElement.appendChild(projetosElement);
            projetosElement.appendChild(projetoElement);

            DOMSource domSource = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream("vereadoresDOM.xml"));
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Novo nó criado com sucesso!!!");
        }

    }

    public static String converteDataParaString(Date data) {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            String dataFormatada = sd.format(data);
            return dataFormatada;
        } catch (Exception e) {
            //....
        }
        return null;
    }
}
