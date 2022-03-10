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
public class ModifierQuestionnairePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_questionnaire")
    private int idQuestionnaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utilisateur")
    private int idUtilisateur;

    public ModifierQuestionnairePK() {
    }

    public ModifierQuestionnairePK(int idQuestionnaire, int idUtilisateur) {
        this.idQuestionnaire = idQuestionnaire;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
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
        hash += (int) idQuestionnaire;
        hash += (int) idUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierQuestionnairePK)) {
            return false;
        }
        ModifierQuestionnairePK other = (ModifierQuestionnairePK) object;
        if (this.idQuestionnaire != other.idQuestionnaire) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ModifierQuestionnairePK[ idQuestionnaire=" + idQuestionnaire + ", idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
