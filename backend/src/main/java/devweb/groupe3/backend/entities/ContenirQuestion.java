/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author gaetanlhf
 */
@Entity
@Table(name = "Contenir_Question")
@NamedQueries({
    @NamedQuery(name = "ContenirQuestion.findAll", query = "SELECT c FROM ContenirQuestion c"),
    @NamedQuery(name = "ContenirQuestion.findByIdQuestion", query = "SELECT c FROM ContenirQuestion c WHERE c.contenirQuestionPK.idQuestion = :idQuestion"),
    @NamedQuery(name = "ContenirQuestion.findByIdQuestionnaire", query = "SELECT c FROM ContenirQuestion c WHERE c.contenirQuestionPK.idQuestionnaire = :idQuestionnaire"),
    @NamedQuery(name = "ContenirQuestion.findByIdPropositionChoisie", query = "SELECT c FROM ContenirQuestion c WHERE c.idPropositionChoisie = :idPropositionChoisie"),
    @NamedQuery(name = "ContenirQuestion.findByReussiteQuestion", query = "SELECT c FROM ContenirQuestion c WHERE c.reussiteQuestion = :reussiteQuestion")})
public class ContenirQuestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContenirQuestionPK contenirQuestionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id_proposition_choisie")
    private String idPropositionChoisie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reussite_question")
    private boolean reussiteQuestion;
    @JoinColumn(name = "id_question", referencedColumnName = "id_question", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Question question;
    @JoinColumn(name = "id_questionnaire", referencedColumnName = "id_questionnaire", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Questionaire questionaire;

    public ContenirQuestion() {
    }

    public ContenirQuestion(ContenirQuestionPK contenirQuestionPK) {
        this.contenirQuestionPK = contenirQuestionPK;
    }

    public ContenirQuestion(ContenirQuestionPK contenirQuestionPK, String idPropositionChoisie, boolean reussiteQuestion) {
        this.contenirQuestionPK = contenirQuestionPK;
        this.idPropositionChoisie = idPropositionChoisie;
        this.reussiteQuestion = reussiteQuestion;
    }

    public ContenirQuestion(int idQuestion, int idQuestionnaire) {
        this.contenirQuestionPK = new ContenirQuestionPK(idQuestion, idQuestionnaire);
    }

    public ContenirQuestionPK getContenirQuestionPK() {
        return contenirQuestionPK;
    }

    public void setContenirQuestionPK(ContenirQuestionPK contenirQuestionPK) {
        this.contenirQuestionPK = contenirQuestionPK;
    }

    public String getIdPropositionChoisie() {
        return idPropositionChoisie;
    }

    public void setIdPropositionChoisie(String idPropositionChoisie) {
        this.idPropositionChoisie = idPropositionChoisie;
    }

    public boolean getReussiteQuestion() {
        return reussiteQuestion;
    }

    public void setReussiteQuestion(boolean reussiteQuestion) {
        this.reussiteQuestion = reussiteQuestion;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Questionaire getQuestionaire() {
        return questionaire;
    }

    public void setQuestionaire(Questionaire questionaire) {
        this.questionaire = questionaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contenirQuestionPK != null ? contenirQuestionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContenirQuestion)) {
            return false;
        }
        ContenirQuestion other = (ContenirQuestion) object;
        if ((this.contenirQuestionPK == null && other.contenirQuestionPK != null) || (this.contenirQuestionPK != null && !this.contenirQuestionPK.equals(other.contenirQuestionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.ContenirQuestion[ contenirQuestionPK=" + contenirQuestionPK + " ]";
    }
    
}
