package br.com.tardeli.xml.dom;

import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class LerXML {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ParseException {
        Projeto projeto = new Projeto();
        Partido partido = new Partido();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("vereadoresDOM.xml");

        List<Vereador> vereadores = new ArrayList<Vereador>();

        NodeList nodeVereador = document.getElementsByTagName("vereador");

        for (int j = 0; j < nodeVereador.getLength(); j++) {

            Node node = nodeVereador.item(j);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Long codigo = Long.valueOf(element.getElementsByTagName("codigo").item(0).getTextContent());
                String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                Date data = converterStringParaDate(element.getElementsByTagName("dataAssociacao").item(0).getTextContent());

                NodeList nodePartido = element.getElementsByTagName("partido");
                Node noPartido = nodePartido.item(0);
                if (noPartido.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) noPartido;

                    Long numeroPartido = Long.valueOf(e.getElementsByTagName("numero").item(0).getTextContent());
                    String nomePartido = e.getElementsByTagName("nome").item(0).getTextContent();

                    partido = new Partido(numeroPartido, nomePartido);

                }

                NodeList nodeProjeto = element.getElementsByTagName("projeto");

                Vereador vereador = new Vereador(data, partido, codigo, nome);

                for (int i = 0; i < nodeProjeto.getLength(); i++) {
                    Node noFilho = nodeProjeto.item(i);
                    if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) noFilho;

                        Long codigoProjeto = Long.parseLong(e.getElementsByTagName("codigo").item(0).getTextContent());
                        String nomeProjeto = e.getElementsByTagName("nome").item(0).getTextContent();
                        boolean apresentado = Boolean.parseBoolean(e.getElementsByTagName("apresentado").item(0).getTextContent());
                        boolean aprovado = Boolean.parseBoolean(e.getElementsByTagName("aprovado").item(0).getTextContent());

                        projeto = new Projeto(codigoProjeto, nomeProjeto, aprovado, apresentado);
                        vereador.adicionaProjeto(projeto);
                    }
                }

                vereadores.add(vereador);
            }
        }

        for (Vereador v : vereadores) {
            System.out.println(v.toString());
        }
    }

    public static Date converterStringParaDate(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date d = formato.parse(data);
        return d;
    }
}
