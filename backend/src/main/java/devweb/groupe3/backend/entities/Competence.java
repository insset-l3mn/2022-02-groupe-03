/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gaetanlhf
 */
@Entity
@Table(name = "Competence")
@NamedQueries({
    @NamedQuery(name = "Competence.findAll", query = "SELECT c FROM Competence c"),
    @NamedQuery(name = "Competence.findByIdCompetence", query = "SELECT c FROM Competence c WHERE c.idCompetence = :idCompetence"),
    @NamedQuery(name = "Competence.findByNomCompetence", query = "SELECT c FROM Competence c WHERE c.nomCompetence = :nomCompetence"),
    @NamedQuery(name = "Competence.findByPoidsCompetence", query = "SELECT c FROM Competence c WHERE c.poidsCompetence = :poidsCompetence"),
    @NamedQuery(name = "Competence.findByTestableCompetence", query = "SELECT c FROM Competence c WHERE c.testableCompetence = :testableCompetence"),
    @NamedQuery(name = "Competence.findByDateCreation", query = "SELECT c FROM Competence c WHERE c.dateCreation = :dateCreation")})
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_competence")
    private Integer idCompetence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_competence")
    private String nomCompetence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "poids_competence")
    private String poidsCompetence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "testable_competence")
    private boolean testableCompetence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_creation")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @JoinTable(name = "Lier_Competance_Competance", joinColumns = {
        @JoinColumn(name = "id_competence_Lier_Competance_Competance", referencedColumnName = "id_competence")}, inverseJoinColumns = {
        @JoinColumn(name = "id_competence", referencedColumnName = "id_competence")})
    @ManyToMany
    private Collection<Competence> competenceCollection;
    @ManyToMany(mappedBy = "competenceCollection")
    private Collection<Competence> competenceCollection1;
    @JoinTable(name = "Lier_Question_Competance", joinColumns = {
        @JoinColumn(name = "id_competence", referencedColumnName = "id_competence")}, inverseJoinColumns = {
        @JoinColumn(name = "id_question", referencedColumnName = "id_question")})
    @ManyToMany
    private Collection<Question> questionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "competence")
    private Collection<ModifierCompetance> modifierCompetanceCollection;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;

    public Competence() {
    }

    public Competence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public Competence(Integer idCompetence, String nomCompetence, String poidsCompetence, boolean testableCompetence, Date dateCreation) {
        this.idCompetence = idCompetence;
        this.nomCompetence = nomCompetence;
        this.poidsCompetence = poidsCompetence;
        this.testableCompetence = testableCompetence;
        this.dateCreation = dateCreation;
    }

    public Integer getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Integer idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getNomCompetence() {
        return nomCompetence;
    }

    public void setNomCompetence(String nomCompetence) {
        this.nomCompetence = nomCompetence;
    }

    public String getPoidsCompetence() {
        return poidsCompetence;
    }

    public void setPoidsCompetence(String poidsCompetence) {
        this.poidsCompetence = poidsCompetence;
    }

    public boolean getTestableCompetence() {
        return testableCompetence;
    }

    public void setTestableCompetence(boolean testableCompetence) {
        this.testableCompetence = testableCompetence;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<Competence> getCompetenceCollection() {
        return competenceCollection;
    }

    public void setCompetenceCollection(Collection<Competence> competenceCollection) {
        this.competenceCollection = competenceCollection;
    }

    public Collection<Competence> getCompetenceCollection1() {
        return competenceCollection1;
    }

    public void setCompetenceCollection1(Collection<Competence> competenceCollection1) {
        this.competenceCollection1 = competenceCollection1;
    }

    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    public Collection<ModifierCompetance> getModifierCompetanceCollection() {
        return modifierCompetanceCollection;
    }

    public void setModifierCompetanceCollection(Collection<ModifierCompetance> modifierCompetanceCollection) {
        this.modifierCompetanceCollection = modifierCompetanceCollection;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompetence != null ? idCompetence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
        if ((this.idCompetence == null && other.idCompetence != null) || (this.idCompetence != null && !this.idCompetence.equals(other.idCompetence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.Competence[ idCompetence=" + idCompetence + " ]";
    }
    
}
