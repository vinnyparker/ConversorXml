package br.com.tabernatech.conversorxml.convert;

import br.com.tabernatech.conversorxml.model.Pais;
import br.com.tabernatech.conversorxml.service.PaisService;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vinny
 * Started at 05/03/2023
 **/
@Component
public class PaisXml {
    private final PaisService paisService;

    public PaisXml(PaisService paisService) {
        this.paisService = paisService;
    }

    public void convert(File file) {
        System.out.println(">>> O Tamanho do arquivo é " + file.length());

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter stringWriter = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));

            doc.getDocumentElement().normalize();
            System.out.println("Root Element = " + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName("pais");
            List<Pais> paisList = new ArrayList<>();
            Pais pais;

            for (int i = 0; i < nodeList.getLength(); i++) {
                pais = new Pais();
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    long id = Long.parseLong(element.getElementsByTagName("ordem").item(0).getTextContent());
                    String codigo = element.getElementsByTagName("codigo").item(0).getTextContent();
                    String nome = element.getElementsByTagName("nome").item(0).getTextContent();
                    String sigla = element.getElementsByTagName("sigla2").item(0).getTextContent();
                    String sigla3 = element.getElementsByTagName("sigla3").item(0).getTextContent();

                    pais.setId(id);
                    pais.setCodigo(codigo);
                    pais.setNome(nome);
                    pais.setSigla(sigla);
                    pais.setSigla3(sigla3);
                    pais.setVersion("2023");

                    paisList.add(pais);

                }
            }
            paisService.saveAll(paisList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

