/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities.service;

import devweb.groupe3.backend.entities.ContenirQuestion;
import devweb.groupe3.backend.entities.ContenirQuestionPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author gaetanlhf
 */
@Stateless
@Path("contenirquestion")
public class ContenirQuestionFacadeREST extends AbstractFacade<ContenirQuestion> {

    @PersistenceContext(unitName = "qcmPU")
    private EntityManager em;

    private ContenirQuestionPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idQuestion=idQuestionValue;idQuestionnaire=idQuestionnaireValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        devweb.groupe3.backend.entities.ContenirQuestionPK key = new devweb.groupe3.backend.entities.ContenirQuestionPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idQuestion = map.get("idQuestion");
        if (idQuestion != null && !idQuestion.isEmpty()) {
            key.setIdQuestion(new java.lang.Integer(idQuestion.get(0)));
        }
        java.util.List<String> idQuestionnaire = map.get("idQuestionnaire");
        if (idQuestionnaire != null && !idQuestionnaire.isEmpty()) {
            key.setIdQuestionnaire(new java.lang.Integer(idQuestionnaire.get(0)));
        }
        return key;
    }

    public ContenirQuestionFacadeREST() {
        super(ContenirQuestion.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ContenirQuestion entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, ContenirQuestion entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        devweb.groupe3.backend.entities.ContenirQuestionPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ContenirQuestion find(@PathParam("id") PathSegment id) {
        devweb.groupe3.backend.entities.ContenirQuestionPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ContenirQuestion> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ContenirQuestion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
