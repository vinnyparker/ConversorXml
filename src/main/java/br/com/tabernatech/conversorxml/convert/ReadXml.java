package br.com.tabernatech.conversorxml.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author vinny
 * Started at 05/03/2023
 **/
@Component
public class ReadXml {

    @Autowired
    private PaisXml paisXml;

    public void start() {
        System.out.print("Starting reading xml \n");
        File diretorio = new File("/home/vinny/ideaProjects/conversorXml/src/main/dadosxml");
        File[] files = diretorio.listFiles();
        assert files != null;
        int count = 0;
        for (File file : files) {
            count++;
            if (file.isFile() && file.getName().equalsIgnoreCase("pais.xml")) {
                System.out.println("O nome do arquivo é " + file.getName());
                paisXml.convert(file);
            }

        }
        System.out.printf("Temos " + count + " arquivo(s) no diretorio.");


    }
}
