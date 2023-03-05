package br.com.tabernatech.conversorxml.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

/**
 * @author vinny
 * Started at 05/03/2023
 **/
@Entity
public class Pais extends AbstractModel<Long>{

    @Column(name = "codigo", length = 5)
    private String codigo;

    @Column(name = "nome", length = 500)
    private String nome;

    @Column(name = "sigla", length = 2)
    private String sigla;

    @Column(name = "sigla3", length = 3)
    private String sigla3;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getSigla3() {
        return sigla3;
    }

    public void setSigla3(String sigla3) {
        this.sigla3 = sigla3;
    }
}
