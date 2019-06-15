package lund.backend.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Request implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private KindOfRequest kind;
    
    @Column(nullable = false)
    private String policyNumber;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, length = 5000)
    private String requestText;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KindOfRequest getKind() {
        return kind;
    }

    public void setKind(KindOfRequest kind) {
        this.kind = kind;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.kind);
        hash = 43 * hash + Objects.hashCode(this.policyNumber);
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.requestText);
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
        final Request other = (Request) obj;
        if (!Objects.equals(this.policyNumber, other.policyNumber)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.requestText, other.requestText)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Request{" + "id=" + id + ", kind=" + kind + ", policyNumber=" + policyNumber + ", name=" + name + ", requestText=" + requestText + '}';
    }
    
    
}