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
@Table(name = "Modifier_Competance")
@NamedQueries({
    @NamedQuery(name = "ModifierCompetance.findAll", query = "SELECT m FROM ModifierCompetance m"),
    @NamedQuery(name = "ModifierCompetance.findByIdCompetence", query = "SELECT m FROM ModifierCompetance m WHERE m.modifierCompetancePK.idCompetence = :idCompetence"),
    @NamedQuery(name = "ModifierCompetance.findByIdUtilisateur", query = "SELECT m FROM ModifierCompetance m WHERE m.modifierCompetancePK.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "ModifierCompetance.findByCommentaireModification", query = "SELECT m FROM ModifierCompetance m WHERE m.commentaireModification = :commentaireModification"),
    @NamedQuery(name = "ModifierCompetance.findByDateModification", query = "SELECT m FROM ModifierCompetance m WHERE m.dateModification = :dateModification")})
public class ModifierCompetance implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModifierCompetancePK modifierCompetancePK;
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
    @JoinColumn(name = "id_competence", referencedColumnName = "id_competence", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Competence competence;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Utilisateur utilisateur;

    public ModifierCompetance() {
    }

    public ModifierCompetance(ModifierCompetancePK modifierCompetancePK) {
        this.modifierCompetancePK = modifierCompetancePK;
    }

    public ModifierCompetance(ModifierCompetancePK modifierCompetancePK, String commentaireModification, Date dateModification) {
        this.modifierCompetancePK = modifierCompetancePK;
        this.commentaireModification = commentaireModification;
        this.dateModification = dateModification;
    }

    public ModifierCompetance(int idCompetence, int idUtilisateur) {
        this.modifierCompetancePK = new ModifierCompetancePK(idCompetence, idUtilisateur);
    }

    public ModifierCompetancePK getModifierCompetancePK() {
        return modifierCompetancePK;
    }

    public void setModifierCompetancePK(ModifierCompetancePK modifierCompetancePK) {
        this.modifierCompetancePK = modifierCompetancePK;
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

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
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
        hash += (modifierCompetancePK != null ? modifierCompetancePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierCompetance)) {
            return false;
        }
        ModifierCompetance other = (ModifierCompetance) object;
        if ((this.modifierCompetancePK == null && other.modifierCompetancePK != null) || (this.modifierCompetancePK != null && !this.modifierCompetancePK.equals(other.modifierCompetancePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ModifierCompetance[ modifierCompetancePK=" + modifierCompetancePK + " ]";
    }
    
}
