/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities.service;

import devweb.groupe3.backend.entities.Competence;
import devweb.groupe3.backend.entities.ModifierQuestion;
import devweb.groupe3.backend.entities.ModifierQuestionPK;
import devweb.groupe3.backend.entities.Question;
import devweb.groupe3.backend.entities.Utilisateur;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.time.DateUtils;

/**
 *
 * @author gaetanlhf
 */
@Stateless
@Path("question")
public class QuestionFacadeREST extends AbstractFacade<Question> {

    @PersistenceContext(unitName = "qcmPU")
    private EntityManager em;

    public QuestionFacadeREST() {
        super(Question.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/add/{id_utilisateur}/{id_competence}")
    public Response create(@PathParam("id_utilisateur") Integer idUtilisateur, @PathParam("id_competence") Integer idCompetence, @FormParam("contenu_question") String contenuQuestion, @FormParam("reponse_question") String reponseQuestion, @FormParam("aide_question") String aideQuestion) {
        if (idUtilisateur != null) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            Competence competence = em.find(Competence.class, idCompetence);
            if (utilisateur != null && competence != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (contenuQuestion != null && reponseQuestion != null && aideQuestion != null) {
                        Question entityQuestion = new Question();
                        entityQuestion.setIdUtilisateur(utilisateur);
                        entityQuestion.setContenuQuestion(contenuQuestion);
                        entityQuestion.setReponseQuestion(reponseQuestion);
                        entityQuestion.setAideQuestion(aideQuestion);
                        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
                        entityQuestion.setDateAjouter(today);
                        entityQuestion.setCompetenceCollection(competence.getCompetenceCollection1());
                        super.create(entityQuestion);
                        return Response.status(200).build();
                    } else {
                        return Response.status(404).build();
                    }
                } else {
                    return Response.status(401).build();
                }
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(404).build();
        }

    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("update/{id_utilisateur}/{id}")
    public Response edit(@PathParam("id") Integer id, @PathParam("id_utilisateur") Integer idUtilisateur, @FormParam("contenu_question") String contenuQuestion, @FormParam("reponse_question") String reponseQuestion, @FormParam("aideQuestion") String aideQuestion, @FormParam("commentaire_modifier") String commentaireModifier) {
        Question entity = super.find(id);
        if (idUtilisateur != null) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (entity != null) {
                        if (contenuQuestion != null) {
                            entity.setContenuQuestion(contenuQuestion);
                        }
                        if (reponseQuestion != null) {
                            entity.setReponseQuestion(reponseQuestion);
                        }
                        if (aideQuestion != null) {
                            entity.setAideQuestion(aideQuestion);
                        }
                        ModifierQuestion modif = new ModifierQuestion();
                        ModifierQuestionPK modifPK = new ModifierQuestionPK();
                        modifPK.setIdQuestion(entity.getIdQuestion());
                        modifPK.setIdUtilisateur(utilisateur.getIdUtilisateur());
                        modif.setUtilisateur(utilisateur);
                        modif.setQuestion(entity);
                        modif.setModifierQuestionPK(modifPK);
                        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
                        modif.setDateModifier(today);
                        if (commentaireModifier != null) {
                            modif.setComentaireModifier(commentaireModifier);
                        }
                        em.merge(modif);
                        super.edit(entity);
                        return Response.status(200).build();
                    } else {
                        return Response.status(404).build();

                    }
                } else {
                    return Response.status(401).build();
                }
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(404).build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("delete/{id_utilisateur}/{id}")
    public Response remove(@PathParam("id") Integer id, @PathParam("id_utilisateur") int idUtilisateur) {
        if (idUtilisateur != 0) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    Question entity = super.find(id);
                    if (entity != null) {
                        super.remove(entity);
                        return Response.status(200).build();
                    } else {
                        return Response.status(404).build();
                    }
                } else {
                    return Response.status(401).build();
                }
            } else {
                return Response.status(404).build();
            }
        } else {
            return Response.status(404).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Question find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Question> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Question> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
