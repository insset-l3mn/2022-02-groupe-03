/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities.service;

import devweb.groupe3.backend.entities.Proposition;
import devweb.groupe3.backend.entities.Question;
import devweb.groupe3.backend.entities.Utilisateur;
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
@Path("proposition")
public class PropositionFacadeREST extends AbstractFacade<Proposition> {

    @PersistenceContext(unitName = "qcmPU")
    private EntityManager em;

    public PropositionFacadeREST() {
        super(Proposition.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/add/{id_utilisateur}/{id_competence}")
    public Response create(@PathParam("id_utilisateur") Integer idUtilisateur, @PathParam("id_question") Integer idQuestion, @FormParam("contenu_proposition") String contenuProposition, @FormParam("validite_proposition") Boolean validiteProposition) {
        if (idUtilisateur != null) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            Question question = em.find(Question.class, idQuestion);
            if (utilisateur != null && question != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (contenuProposition != null && validiteProposition != null) {
                        Proposition proposition = new Proposition();
                        proposition.setContenuProposition(contenuProposition);
                        proposition.setValiditeProposition(validiteProposition);
                        super.create(proposition);

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
    public Response edit(@PathParam("id") Integer id, @PathParam("id_utilisateur") Integer idUtilisateur, @FormParam("contenu_proposition") String contenuProposition, @FormParam("validite_proposition") Boolean validiteProposition) {
        Proposition entity = super.find(id);
        if (idUtilisateur != null) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (entity != null) {
                        if (contenuProposition != null) {
                            entity.setContenuProposition(contenuProposition);
                        }
                        if (validiteProposition != null) {
                            entity.setValiditeProposition(validiteProposition);
                        }
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
                    Proposition entity = super.find(id);
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
    public Proposition find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Proposition> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Proposition> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
