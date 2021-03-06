package br.com.tardeli.Jaxb;

import br.com.tardeli.modelo.Partido;
import br.com.tardeli.modelo.Partidos;
import br.com.tardeli.modelo.Projeto;
import br.com.tardeli.modelo.Vereador;
import br.com.tardeli.modelo.Vereadores;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Tardeli da Rocha <tardeliltda@hotmail.com>
 */
public class ExecutarJAXB {
    static List<Vereador> list = new ArrayList<>();
    
    public static void main(String[] args) throws JAXBException, ParseException{
        carregarDados();
        
        Vereadores vereadores = new Vereadores(list);
                
        JAXBContext context = JAXBContext.newInstance(Vereadores.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        m.marshal(vereadores, System.out);
        
        // Write to File
        m.marshal(vereadores, new File("vereadorJAXB.xml"));
                
    }
    
    public static Date converterStringParaDate(String data) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date d = formato.parse(data);
        return d;
    }
    
    public static void carregarDados() throws ParseException{
        Partido partido1 = new Partido(15L, "PMDB");
        Partido partido2 = new Partido(13L, "PT");
        Partido partido3 = new Partido(17L, "PSL");
        Partido partido4 = new Partido(45L, "PSDB");
        Partido partido5 = new Partido(14L, "PTB");
        Partido partido6 = new Partido(25L, "DEM");
        Partido partido7 = new Partido(12L, "PDT");
                
        Vereador ve_1 = new Vereador(converterStringParaDate("22/10/2019"), partido1, 1L, "Tardeli da Rocha");
        Vereador ve_2 = new Vereador(converterStringParaDate("22/10/2019"), partido1, 2L, "Fernando da Silva");
        Vereador ve_3 = new Vereador(converterStringParaDate("24/10/2019"), partido2, 3L, "Maria da Rosa");
        Vereador ve_4 = new Vereador(converterStringParaDate("25/08/2019"), partido3, 4L, "Marilse Cardoso");
        Vereador ve_5 = new Vereador(converterStringParaDate("27/07/2019"), partido1, 5L, "Prdro Fernandes");
        Vereador ve_6 = new Vereador(converterStringParaDate("30/06/2019"), partido4, 6L, "Thomas Edisom");
        Vereador ve_7 = new Vereador(converterStringParaDate("22/10/2019"), partido4, 7L, "Dyenifer Vitória");
        Vereador ve_8 = new Vereador(converterStringParaDate("24/10/2019"), partido4, 8L, "Jessica Patricia");
        Vereador ve_9 = new Vereador(converterStringParaDate("24/10/2019"), partido3, 9L, "Silvia Bedim");
        Vereador ve_10 = new Vereador(converterStringParaDate("22/10/2019"), partido1, 10L, "Lurdes Carraro");
        Vereador ve_11 = new Vereador(converterStringParaDate("23/10/2019"), partido1, 11L, "João Cardoso");
                
        Projeto pj_1 = new Projeto(1L, "Projeto-1", true, true);
        ve_1.adicionaProjeto(pj_1);
        Projeto pj_2 = new Projeto(2L, "Projeto-2", false, true);
        ve_2.adicionaProjeto(pj_2);
        Projeto pj_3 = new Projeto(3L, "Projeto-3", true, true);
        ve_3.adicionaProjeto(pj_3);
        Projeto pj_4 = new Projeto(4L, "Projeto-4", true, true);
        ve_1.adicionaProjeto(pj_4);
        Projeto pj_5 = new Projeto(5L, "Projeto-5", true, true);
        ve_4.adicionaProjeto(pj_5);
        Projeto pj_6 = new Projeto(6L, "Projeto-6", true, true);
        ve_2.adicionaProjeto(pj_6);
        Projeto pj_7 = new Projeto(7L, "Projeto-7", true, true);
        ve_1.adicionaProjeto(pj_7);
        Projeto pj_8 = new Projeto(8L, "Projeto-8", false, true);
        ve_5.adicionaProjeto(pj_8);
        Projeto pj_9 = new Projeto(9L, "Projeto-9", true, true);
        ve_4.adicionaProjeto(pj_9);
        Projeto pj_10 = new Projeto(10L, "Projeto-10", false, true);
        ve_1.adicionaProjeto(pj_10);
        Projeto pj_11 = new Projeto(11L, "Projeto-11", true, true);
        ve_3.adicionaProjeto(pj_11);
        Projeto pj_12 = new Projeto(12L, "Projeto-12", false, true);
        ve_5.adicionaProjeto(pj_12);
        Projeto pj_13 = new Projeto(13L, "Projeto-13", true, true);
        ve_5.adicionaProjeto(pj_13);
        Projeto pj_14 = new Projeto(14L, "Projeto-14", false, true);
        ve_3.adicionaProjeto(pj_14);
        Projeto pj_15 = new Projeto(15L, "Projeto-15", true, true);
        ve_11.adicionaProjeto(pj_15);
        Projeto pj_16 = new Projeto(16L, "Projeto-16", true, true);
        ve_11.adicionaProjeto(pj_16);
        
        list.add(ve_1);
        list.add(ve_2);
        list.add(ve_3);
        list.add(ve_4);
        list.add(ve_5);
        list.add(ve_6);
        list.add(ve_7);
        list.add(ve_8);
        list.add(ve_9);
        list.add(ve_10);
        list.add(ve_11);
    }
}
