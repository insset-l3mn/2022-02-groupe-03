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
@Table(name = "Modifier_Question")
@NamedQueries({
    @NamedQuery(name = "ModifierQuestion.findAll", query = "SELECT m FROM ModifierQuestion m"),
    @NamedQuery(name = "ModifierQuestion.findByIdQuestion", query = "SELECT m FROM ModifierQuestion m WHERE m.modifierQuestionPK.idQuestion = :idQuestion"),
    @NamedQuery(name = "ModifierQuestion.findByIdUtilisateur", query = "SELECT m FROM ModifierQuestion m WHERE m.modifierQuestionPK.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "ModifierQuestion.findByDateModifier", query = "SELECT m FROM ModifierQuestion m WHERE m.dateModifier = :dateModifier"),
    @NamedQuery(name = "ModifierQuestion.findByComentaireModifier", query = "SELECT m FROM ModifierQuestion m WHERE m.comentaireModifier = :comentaireModifier")})
public class ModifierQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModifierQuestionPK modifierQuestionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modifier")
    @Temporal(TemporalType.DATE)
    private Date dateModifier;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comentaire_modifier")
    private String comentaireModifier;
    @JoinColumn(name = "id_question", referencedColumnName = "id_question", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public ModifierQuestion() {
    }

    public ModifierQuestion(ModifierQuestionPK modifierQuestionPK) {
        this.modifierQuestionPK = modifierQuestionPK;
    }

    public ModifierQuestion(ModifierQuestionPK modifierQuestionPK, Date dateModifier, String comentaireModifier) {
        this.modifierQuestionPK = modifierQuestionPK;
        this.dateModifier = dateModifier;
        this.comentaireModifier = comentaireModifier;
    }

    public ModifierQuestion(int idQuestion, int idUtilisateur) {
        this.modifierQuestionPK = new ModifierQuestionPK(idQuestion, idUtilisateur);
    }

    public ModifierQuestionPK getModifierQuestionPK() {
        return modifierQuestionPK;
    }

    public void setModifierQuestionPK(ModifierQuestionPK modifierQuestionPK) {
        this.modifierQuestionPK = modifierQuestionPK;
    }

    public Date getDateModifier() {
        return dateModifier;
    }

    public void setDateModifier(Date dateModifier) {
        this.dateModifier = dateModifier;
    }

    public String getComentaireModifier() {
        return comentaireModifier;
    }

    public void setComentaireModifier(String comentaireModifier) {
        this.comentaireModifier = comentaireModifier;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        hash += (modifierQuestionPK != null ? modifierQuestionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierQuestion)) {
            return false;
        }
        ModifierQuestion other = (ModifierQuestion) object;
        if ((this.modifierQuestionPK == null && other.modifierQuestionPK != null) || (this.modifierQuestionPK != null && !this.modifierQuestionPK.equals(other.modifierQuestionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ModifierQuestion[ modifierQuestionPK=" + modifierQuestionPK + " ]";
    }
    
}
