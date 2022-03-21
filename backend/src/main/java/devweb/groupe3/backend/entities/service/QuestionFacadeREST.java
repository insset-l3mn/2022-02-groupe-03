/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities.service;

import devweb.groupe3.backend.entities.Proposition;
import devweb.groupe3.backend.entities.Question;
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
    @Path("/add")
    public Response create(@FormParam("contenu_question") String contenuQuestion, @FormParam("reponse_question") String reponseQuestion, @FormParam("aideQuestion") String aideQuestion, @FormParam("date_ajouter") Date dateAjouter) {
        if (contenuQuestion != null && reponseQuestion != null && aideQuestion != null && dateAjouter != null) {
            Question entityQuestion = new Question();
            entityQuestion.setContenuQuestion(contenuQuestion);
            entityQuestion.setReponseQuestion(reponseQuestion);
            entityQuestion.setAideQuestion(aideQuestion);
            entityQuestion.setDateAjouter(dateAjouter);
            super.create(entityQuestion);  
           return Response.status(200).build();
        }
        return Response.status(406).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/update/{id}")
    public Response edit(@PathParam("id") Integer id, @FormParam("contenu_question") String contenuQuestion, @FormParam("reponse_question") String reponseQuestion, @FormParam("aideQuestion") String aideQuestion, @FormParam("date_ajouter") Date dateAjouter) {
        Question entity = super.find(id);
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
            super.edit(entity);
            return Response.status(200).build();
        }
        
        return Response.status(404).build();
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
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
