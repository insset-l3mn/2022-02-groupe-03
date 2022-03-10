/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Modifier_Questionnaire")
@NamedQueries({
    @NamedQuery(name = "ModifierQuestionnaire.findAll", query = "SELECT m FROM ModifierQuestionnaire m"),
    @NamedQuery(name = "ModifierQuestionnaire.findByIdQuestionnaire", query = "SELECT m FROM ModifierQuestionnaire m WHERE m.modifierQuestionnairePK.idQuestionnaire = :idQuestionnaire"),
    @NamedQuery(name = "ModifierQuestionnaire.findByIdUtilisateur", query = "SELECT m FROM ModifierQuestionnaire m WHERE m.modifierQuestionnairePK.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "ModifierQuestionnaire.findByCommentaireModification", query = "SELECT m FROM ModifierQuestionnaire m WHERE m.commentaireModification = :commentaireModification"),
    @NamedQuery(name = "ModifierQuestionnaire.findByDateModification", query = "SELECT m FROM ModifierQuestionnaire m WHERE m.dateModification = :dateModification")})
public class ModifierQuestionnaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModifierQuestionnairePK modifierQuestionnairePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "commentaire_modification")
    private String commentaireModification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modification")
    @Temporal(TemporalType.DATE)
    private Date dateModification;
    @JoinColumn(name = "id_questionnaire", referencedColumnName = "id_questionnaire", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Questionaire questionaire;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public ModifierQuestionnaire() {
    }

    public ModifierQuestionnaire(ModifierQuestionnairePK modifierQuestionnairePK) {
        this.modifierQuestionnairePK = modifierQuestionnairePK;
    }

    public ModifierQuestionnaire(ModifierQuestionnairePK modifierQuestionnairePK, String commentaireModification, Date dateModification) {
        this.modifierQuestionnairePK = modifierQuestionnairePK;
        this.commentaireModification = commentaireModification;
        this.dateModification = dateModification;
    }

    public ModifierQuestionnaire(int idQuestionnaire, int idUtilisateur) {
        this.modifierQuestionnairePK = new ModifierQuestionnairePK(idQuestionnaire, idUtilisateur);
    }

    public ModifierQuestionnairePK getModifierQuestionnairePK() {
        return modifierQuestionnairePK;
    }

    public void setModifierQuestionnairePK(ModifierQuestionnairePK modifierQuestionnairePK) {
        this.modifierQuestionnairePK = modifierQuestionnairePK;
    }

    public String getCommentaireModification() {
        return commentaireModification;
    }

    public void setCommentaireModification(String commentaireModification) {
        this.commentaireModification = commentaireModification;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Questionaire getQuestionaire() {
        return questionaire;
    }

    public void setQuestionaire(Questionaire questionaire) {
        this.questionaire = questionaire;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modifierQuestionnairePK != null ? modifierQuestionnairePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierQuestionnaire)) {
            return false;
        }
        ModifierQuestionnaire other = (ModifierQuestionnaire) object;
        if ((this.modifierQuestionnairePK == null && other.modifierQuestionnairePK != null) || (this.modifierQuestionnairePK != null && !this.modifierQuestionnairePK.equals(other.modifierQuestionnairePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ModifierQuestionnaire[ modifierQuestionnairePK=" + modifierQuestionnairePK + " ]";
    }
    
}
