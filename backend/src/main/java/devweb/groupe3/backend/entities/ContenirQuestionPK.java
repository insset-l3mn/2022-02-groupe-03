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
public class ContenirQuestionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_question")
    private int idQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_questionnaire")
    private int idQuestionnaire;

    public ContenirQuestionPK() {
    }

    public ContenirQuestionPK(int idQuestion, int idQuestionnaire) {
        this.idQuestion = idQuestion;
        this.idQuestionnaire = idQuestionnaire;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idQuestion;
        hash += (int) idQuestionnaire;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenirQuestionPK)) {
            return false;
        }
        ContenirQuestionPK other = (ContenirQuestionPK) object;
        if (this.idQuestion != other.idQuestion) {
            return false;
        }
        if (this.idQuestionnaire != other.idQuestionnaire) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ContenirQuestionPK[ idQuestion=" + idQuestion + ", idQuestionnaire=" + idQuestionnaire + " ]";
    }
    
}
