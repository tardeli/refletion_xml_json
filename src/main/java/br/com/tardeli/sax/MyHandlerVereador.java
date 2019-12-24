package br.com.tardeli.sax;

import br.com.tardeli.modelo.Vereador;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class MyHandlerVereador extends DefaultHandler {
	private List<Vereador> vereadores = new ArrayList<>();
	private Vereador vereador = null;
	private StringBuffer valorAtual = new StringBuffer(100);
	
	public void startDocument() {
		System.out.println("Iniciando a leitura do XML");
	}

	public void endDocument() {
		System.out.println("Finalizando a leitura do XML");
	}

	public void startElement(String uri, String localName, String tag, Attributes atributos) {
		// cria um vereador
		if (tag.equalsIgnoreCase("vereador")) {
			vereador = new Vereador();
		}
		// imprime o caminho da tag System.out.println("tag " + tag + " ");
		// se o elemento possui atributos, imprime
		for (int i = 0; i < atributos.getLength(); i++) {
			System.out.println("atributo " + atributos.getQName(i) + "=" + atributos.getValue(i));
			if (atributos.getQName(i).equalsIgnoreCase("codigo")) {
				vereador.setCodigo(Long.valueOf(atributos.getValue(i)));
			}
		}
	}
	
	public void endElement(String uri, String localName, String tag){
		if (tag.equalsIgnoreCase("nome")) {
			vereador.setNome(valorAtual.toString());
			System.out.println("tag 2 " + tag + " -" + valorAtual);	
		}
		if (tag.equalsIgnoreCase("nome")) {
			vereadores.add(vereador);	
		}
		valorAtual.delete(0, valorAtual.length());
	}
	
	public void characters(char[] ch, int start, int length) {  
        valorAtual.append(ch, start, length);  
    }

	public List<Vereador> getVereadors() {
		return vereadores;
	}

	public void setVereadors(List<Vereador> vereadores) {
		this.vereadores = vereadores;
	}  
	
}
