/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gaetanlhf
 */
@Entity
@Table(name = "Proposition")
@NamedQueries({
    @NamedQuery(name = "Proposition.findAll", query = "SELECT p FROM Proposition p"),
    @NamedQuery(name = "Proposition.findByIdProposition", query = "SELECT p FROM Proposition p WHERE p.idProposition = :idProposition"),
    @NamedQuery(name = "Proposition.findByContenuProposition", query = "SELECT p FROM Proposition p WHERE p.contenuProposition = :contenuProposition"),
    @NamedQuery(name = "Proposition.findByValiditeProposition", query = "SELECT p FROM Proposition p WHERE p.validiteProposition = :validiteProposition")})
public class Proposition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proposition")
    private Integer idProposition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contenu_proposition")
    private String contenuProposition;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validite_proposition")
    private boolean validiteProposition;
    @JoinTable(name = "Posseder_Proposition", joinColumns = {
        @JoinColumn(name = "id_proposition", referencedColumnName = "id_proposition")}, inverseJoinColumns = {
        @JoinColumn(name = "id_question", referencedColumnName = "id_question")})
    @ManyToMany
    private Collection<Question> questionCollection;

    public Proposition() {
    }

    public Proposition(Integer idProposition) {
        this.idProposition = idProposition;
    }

    public Proposition(Integer idProposition, String contenuProposition, boolean validiteProposition) {
        this.idProposition = idProposition;
        this.contenuProposition = contenuProposition;
        this.validiteProposition = validiteProposition;
    }

    public Integer getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(Integer idProposition) {
        this.idProposition = idProposition;
    }

    public String getContenuProposition() {
        return contenuProposition;
    }

    public void setContenuProposition(String contenuProposition) {
        this.contenuProposition = contenuProposition;
    }

    public boolean getValiditeProposition() {
        return validiteProposition;
    }

    public void setValiditeProposition(boolean validiteProposition) {
        this.validiteProposition = validiteProposition;
    }

    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProposition != null ? idProposition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposition)) {
            return false;
        }
        Proposition other = (Proposition) object;
        if ((this.idProposition == null && other.idProposition != null) || (this.idProposition != null && !this.idProposition.equals(other.idProposition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.Proposition[ idProposition=" + idProposition + " ]";
    }
    
}
