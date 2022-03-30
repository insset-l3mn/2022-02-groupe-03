/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities.service;

import devweb.groupe3.backend.entities.Competence;
import devweb.groupe3.backend.entities.ModifierCompetance;
import devweb.groupe3.backend.entities.ModifierCompetancePK;
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
@Path("competence")
public class CompetenceFacadeREST extends AbstractFacade<Competence> {

    @PersistenceContext(unitName = "qcmPU")
    private EntityManager em;

    public CompetenceFacadeREST() {
        super(Competence.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/add/{id_utilisateur}")
    public Response create(@PathParam("id_utilisateur") Integer idUtilisateur, @FormParam("nom_competence") String nomCompetence, @FormParam("poids_competence") Integer poidsCompetence, @FormParam("testable_competence") Boolean testableCompetence) {
        if (idUtilisateur != null) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (nomCompetence != null && poidsCompetence != null && testableCompetence != null) {
                        Competence entityCompetence = new Competence();
                        entityCompetence.setNomCompetence(nomCompetence);
                        entityCompetence.setPoidsCompetence(poidsCompetence.toString());
                        entityCompetence.setTestableCompetence(testableCompetence);
                        entityCompetence.setIdUtilisateur(utilisateur);
                        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
                        entityCompetence.setDateCreation(today);
                        super.create(entityCompetence);
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
    public Response edit(@PathParam("id") Integer id, @PathParam("id_utilisateur") int idUtilisateur, @FormParam("nom_competence") String nomCompetence, @FormParam("poids_competence") Integer poidsCompetence, @FormParam("testable_competence") Boolean testableCompetence, @FormParam("commentaire_modification") String commentaireModification) {
        Competence entity = super.find(id);
        if (idUtilisateur != 0) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (entity != null) {
                        if (nomCompetence != null) {
                            entity.setNomCompetence(nomCompetence);
                        }
                        if (poidsCompetence != null) {
                            entity.setPoidsCompetence(poidsCompetence.toString());
                        }
                        if (testableCompetence != null) {
                            entity.setTestableCompetence(testableCompetence);
                        }
                        ModifierCompetance modif = new ModifierCompetance();
                        ModifierCompetancePK modifPK = new ModifierCompetancePK();
                        modifPK.setIdCompetence(entity.getIdCompetence());
                        modifPK.setIdUtilisateur(utilisateur.getIdUtilisateur());
                        modif.setUtilisateur(utilisateur);
                        modif.setCompetence(entity);
                        modif.setModifierCompetancePK(modifPK);
                        Date today = DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH);
                        modif.setDateModification(today);
                        if (commentaireModification != null) {
                            modif.setCommentaireModification(commentaireModification);
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
                    Competence entity = super.find(id);
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
    public Competence find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Competence> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Competence> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
