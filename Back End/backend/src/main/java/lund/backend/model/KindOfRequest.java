package lund.backend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KindOfRequest implements Serializable {

    @Id
    private String kind;

    public KindOfRequest() {
    }

    public KindOfRequest(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.kind);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KindOfRequest other = (KindOfRequest) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KindOfRequest{" + "kind=" + kind + '}';
    }

}
