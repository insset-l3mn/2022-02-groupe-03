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
import javax.persistence.ManyToMany;
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
@Table(name = "Question")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByIdQuestion", query = "SELECT q FROM Question q WHERE q.idQuestion = :idQuestion"),
    @NamedQuery(name = "Question.findByContenuQuestion", query = "SELECT q FROM Question q WHERE q.contenuQuestion = :contenuQuestion"),
    @NamedQuery(name = "Question.findByReponseQuestion", query = "SELECT q FROM Question q WHERE q.reponseQuestion = :reponseQuestion"),
    @NamedQuery(name = "Question.findByAideQuestion", query = "SELECT q FROM Question q WHERE q.aideQuestion = :aideQuestion"),
    @NamedQuery(name = "Question.findByDateAjouter", query = "SELECT q FROM Question q WHERE q.dateAjouter = :dateAjouter")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_question")
    private Integer idQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "contenu_question")
    private String contenuQuestion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reponse_question")
    private String reponseQuestion;
    @Size(max = 255)
    @Column(name = "aide_question")
    private String aideQuestion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_ajouter")
    @Temporal(TemporalType.DATE)
    private Date dateAjouter;
    @ManyToMany(mappedBy = "questionCollection")
    private Collection<Competence> competenceCollection;
    @ManyToMany(mappedBy = "questionCollection")
    private Collection<Proposition> propositionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<ContenirQuestion> contenirQuestionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    private Collection<ModifierQuestion> modifierQuestionCollection;
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    @ManyToOne(optional = false)
    private Utilisateur idUtilisateur;

    public Question() {
    }

    public Question(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Question(Integer idQuestion, String contenuQuestion, String reponseQuestion, Date dateAjouter) {
        this.idQuestion = idQuestion;
        this.contenuQuestion = contenuQuestion;
        this.reponseQuestion = reponseQuestion;
        this.dateAjouter = dateAjouter;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getContenuQuestion() {
        return contenuQuestion;
    }

    public void setContenuQuestion(String contenuQuestion) {
        this.contenuQuestion = contenuQuestion;
    }

    public String getReponseQuestion() {
        return reponseQuestion;
    }

    public void setReponseQuestion(String reponseQuestion) {
        this.reponseQuestion = reponseQuestion;
    }

    public String getAideQuestion() {
        return aideQuestion;
    }

    public void setAideQuestion(String aideQuestion) {
        this.aideQuestion = aideQuestion;
    }

    public Date getDateAjouter() {
        return dateAjouter;
    }

    public void setDateAjouter(Date dateAjouter) {
        this.dateAjouter = dateAjouter;
    }

    public Collection<Competence> getCompetenceCollection() {
        return competenceCollection;
    }

    public void setCompetenceCollection(Collection<Competence> competenceCollection) {
        this.competenceCollection = competenceCollection;
    }

    public Collection<Proposition> getPropositionCollection() {
        return propositionCollection;
    }

    public void setPropositionCollection(Collection<Proposition> propositionCollection) {
        this.propositionCollection = propositionCollection;
    }

    public Collection<ContenirQuestion> getContenirQuestionCollection() {
        return contenirQuestionCollection;
    }

    public void setContenirQuestionCollection(Collection<ContenirQuestion> contenirQuestionCollection) {
        this.contenirQuestionCollection = contenirQuestionCollection;
    }

    public Collection<ModifierQuestion> getModifierQuestionCollection() {
        return modifierQuestionCollection;
    }

    public void setModifierQuestionCollection(Collection<ModifierQuestion> modifierQuestionCollection) {
        this.modifierQuestionCollection = modifierQuestionCollection;
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
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "devweb.groupe3.backend.entities.Question[ idQuestion=" + idQuestion + " ]";
    }
    
}
