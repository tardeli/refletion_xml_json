package br.com.tardeli.xml.dom;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class ValidandoXmlComDTD {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        builder.setErrorHandler(new ErrorHandler() {
            public void warning(SAXParseException e) throws SAXException {
                System.out.println("WARNING : " + e.getMessage()); // do nothing
            }

            public void error(SAXParseException e) throws SAXException {
                System.out.println("ERROR : " + e.getMessage());
                throw e;
            }

            public void fatalError(SAXParseException e) throws SAXException {
                System.out.println("FATAL : " + e.getMessage());
                throw e;
            }
        });
        builder.parse("vereadoresCom_DTD.xml");
        System.out.println("<<<<<<<<<<<<<<<<<VALIDADO COM SUCESSO>>>>>>>>>>>>");
    }
}
