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
public class ModifierQuestionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_question")
    private int idQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_utilisateur")
    private int idUtilisateur;

    public ModifierQuestionPK() {
    }

    public ModifierQuestionPK(int idQuestion, int idUtilisateur) {
        this.idQuestion = idQuestion;
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
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
        hash += (int) idQuestion;
        hash += (int) idUtilisateur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierQuestionPK)) {
            return false;
        }
        ModifierQuestionPK other = (ModifierQuestionPK) object;
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        if (this.idUtilisateur != other.idUtilisateur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ModifierQuestionPK[ idQuestion=" + idQuestion + ", idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
