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
import javax.persistence.Lob;
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
@Table(name = "Questionaire")
@NamedQueries({
    @NamedQuery(name = "Questionaire.findAll", query = "SELECT q FROM Questionaire q"),
    @NamedQuery(name = "Questionaire.findByIdQuestionnaire", query = "SELECT q FROM Questionaire q WHERE q.idQuestionnaire = :idQuestionnaire"),
    @NamedQuery(name = "Questionaire.findByNomQuestionnaire", query = "SELECT q FROM Questionaire q WHERE q.nomQuestionnaire = :nomQuestionnaire"),
    @NamedQuery(name = "Questionaire.findByDateQuestionnaire", query = "SELECT q FROM Questionaire q WHERE q.dateQuestionnaire = :dateQuestionnaire"),
    @NamedQuery(name = "Questionaire.findByScoreQuestionnaire", query = "SELECT q FROM Questionaire q WHERE q.scoreQuestionnaire = :scoreQuestionnaire"),
    @NamedQuery(name = "Questionaire.findByFormationProposeeQuestionnaire", query = "SELECT q FROM Questionaire q WHERE q.formationProposeeQuestionnaire = :formationProposeeQuestionnaire")})
public class Questionaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_questionnaire")
    private Integer idQuestionnaire;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_questionnaire")
    private String nomQuestionnaire;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "sauvegarde_graphe_questionnaire")
    private String sauvegardeGrapheQuestionnaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_questionnaire")
    @Temporal(TemporalType.DATE)
    private Date dateQuestionnaire;
    @Size(max = 255)
    @Column(name = "score_questionnaire")
    private String scoreQuestionnaire;
    @Size(max = 255)
    @Column(name = "formation_proposee_questionnaire")
    private String formationProposeeQuestionnaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionaire")
    private Collection<ContenirQuestion> contenirQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionaire")
    private Collection<ModifierQuestionnaire> modifierQuestionnaireCollection;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;

    public Questionaire() {
    }

    public Questionaire(Integer idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public Questionaire(Integer idQuestionnaire, String nomQuestionnaire, Date dateQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
        this.nomQuestionnaire = nomQuestionnaire;
        this.dateQuestionnaire = dateQuestionnaire;
    }

    public Integer getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(Integer idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getNomQuestionnaire() {
        return nomQuestionnaire;
    }

    public void setNomQuestionnaire(String nomQuestionnaire) {
        this.nomQuestionnaire = nomQuestionnaire;
    }

    public String getSauvegardeGrapheQuestionnaire() {
        return sauvegardeGrapheQuestionnaire;
    }

    public void setSauvegardeGrapheQuestionnaire(String sauvegardeGrapheQuestionnaire) {
        this.sauvegardeGrapheQuestionnaire = sauvegardeGrapheQuestionnaire;
    }

    public Date getDateQuestionnaire() {
        return dateQuestionnaire;
    }

    public void setDateQuestionnaire(Date dateQuestionnaire) {
        this.dateQuestionnaire = dateQuestionnaire;
    }

    public String getScoreQuestionnaire() {
        return scoreQuestionnaire;
    }

    public void setScoreQuestionnaire(String scoreQuestionnaire) {
        this.scoreQuestionnaire = scoreQuestionnaire;
    }

    public String getFormationProposeeQuestionnaire() {
        return formationProposeeQuestionnaire;
    }

    public void setFormationProposeeQuestionnaire(String formationProposeeQuestionnaire) {
        this.formationProposeeQuestionnaire = formationProposeeQuestionnaire;
    }

    public Collection<ContenirQuestion> getContenirQuestionCollection() {
        return contenirQuestionCollection;
    }

    public void setContenirQuestionCollection(Collection<ContenirQuestion> contenirQuestionCollection) {
        this.contenirQuestionCollection = contenirQuestionCollection;
    }

    public Collection<ModifierQuestionnaire> getModifierQuestionnaireCollection() {
        return modifierQuestionnaireCollection;
    }

    public void setModifierQuestionnaireCollection(Collection<ModifierQuestionnaire> modifierQuestionnaireCollection) {
        this.modifierQuestionnaireCollection = modifierQuestionnaireCollection;
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
        hash += (idQuestionnaire != null ? idQuestionnaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionaire)) {
            return false;
        }
        Questionaire other = (Questionaire) object;
        if ((this.idQuestionnaire == null && other.idQuestionnaire != null) || (this.idQuestionnaire != null && !this.idQuestionnaire.equals(other.idQuestionnaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.Questionaire[ idQuestionnaire=" + idQuestionnaire + " ]";
    }
    
}
