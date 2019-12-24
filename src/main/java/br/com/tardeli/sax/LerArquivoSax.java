package br.com.tardeli.sax;

import br.com.tardeli.modelo.Vereador;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class LerArquivoSax {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandlerVereador handler = new MyHandlerVereador();
        parser.parse("vereadoresDOM.xml", handler);
        System.out.println("Resultado: ");
        for (Vereador vereador : handler.getVereadors()) {
            System.out.println(vereador);
        }
    }
}
