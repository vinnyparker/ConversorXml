package br.com.tabernatech.conversorxml.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author vinny
 * Started at 05/03/2023
 **/
@MappedSuperclass
public abstract class AbstractModel <Long extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "version")
    private String version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractModel<?> that)) return false;

        if (id != that.id) return false;
        return Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
