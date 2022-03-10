/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gaetanlhf
 */
@Entity
@Table(name = "Utilisateur")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
    @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByNomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :nomUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByPrenomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.prenomUtilisateur = :prenomUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByEmailUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.emailUtilisateur = :emailUtilisateur"),
    @NamedQuery(name = "Utilisateur.findByTypeUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.typeUtilisateur = :typeUtilisateur")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_utilisateur")
    private Integer idUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nom_utilisateur")
    private String nomUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prenom_utilisateur")
    private String prenomUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_utilisateur")
    private String emailUtilisateur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type_utilisateur")
    private String typeUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<ModifierCompetance> modifierCompetanceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Competence> competenceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<ModifierQuestion> modifierQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Collection<ModifierQuestionnaire> modifierQuestionnaireCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Question> questionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur")
    private Collection<Questionaire> questionaireCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(Integer idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String typeUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.typeUtilisateur = typeUtilisateur;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public Collection<ModifierCompetance> getModifierCompetanceCollection() {
        return modifierCompetanceCollection;
    }

    public void setModifierCompetanceCollection(Collection<ModifierCompetance> modifierCompetanceCollection) {
        this.modifierCompetanceCollection = modifierCompetanceCollection;
    }

    public Collection<Competence> getCompetenceCollection() {
        return competenceCollection;
    }

    public void setCompetenceCollection(Collection<Competence> competenceCollection) {
        this.competenceCollection = competenceCollection;
    }

    public Collection<ModifierQuestion> getModifierQuestionCollection() {
        return modifierQuestionCollection;
    }

    public void setModifierQuestionCollection(Collection<ModifierQuestion> modifierQuestionCollection) {
        this.modifierQuestionCollection = modifierQuestionCollection;
    }

    public Collection<ModifierQuestionnaire> getModifierQuestionnaireCollection() {
        return modifierQuestionnaireCollection;
    }

    public void setModifierQuestionnaireCollection(Collection<ModifierQuestionnaire> modifierQuestionnaireCollection) {
        this.modifierQuestionnaireCollection = modifierQuestionnaireCollection;
    }

    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    public Collection<Questionaire> getQuestionaireCollection() {
        return questionaireCollection;
    }

    public void setQuestionaireCollection(Collection<Questionaire> questionaireCollection) {
        this.questionaireCollection = questionaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
