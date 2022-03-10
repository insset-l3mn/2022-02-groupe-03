/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author gaetanlhf
 */
@Embeddable
public class ModifierCompetancePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_competence")
    private int idCompetence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utilisateur")
    private int idUtilisateur;

    public ModifierCompetancePK() {
    }

    public ModifierCompetancePK(int idCompetence, int idUtilisateur) {
        this.idCompetence = idCompetence;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCompetence;
        hash += (int) idUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierCompetancePK)) {
            return false;
        }
        ModifierCompetancePK other = (ModifierCompetancePK) object;
        if (this.idCompetence != other.idCompetence) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ModifierCompetancePK[ idCompetence=" + idCompetence + ", idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
