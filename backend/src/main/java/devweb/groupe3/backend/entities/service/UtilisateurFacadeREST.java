/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devweb.groupe3.backend.entities.service;

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
@Path("utilisateur")
public class UtilisateurFacadeREST extends AbstractFacade<Utilisateur> {

    @PersistenceContext(unitName = "qcmPU")
    private EntityManager em;

    public UtilisateurFacadeREST() {
        super(Utilisateur.class);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/add/{id_utilisateur}")
    public Response create(@PathParam("id_utilisateur") int idUtilisateur, @FormParam("nom_utilisateur") String nomUtilisateur, @FormParam("prenom_utilisateur") String prenomUtilisateur, @FormParam("email_utilisateur") String emailUtilisateur, @FormParam("type_utilisateur") String typeUtilisateur) {
        if (idUtilisateur != 0) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    if (nomUtilisateur != null && prenomUtilisateur != null && emailUtilisateur != null && typeUtilisateur != null) {
                        Utilisateur entity = new Utilisateur();
                        entity.setNomUtilisateur(nomUtilisateur);
                        entity.setPrenomUtilisateur(prenomUtilisateur);
                        entity.setEmailUtilisateur(emailUtilisateur);
                        entity.setTypeUtilisateur(typeUtilisateur);
                        super.create(entity);
                        return Response.status(200).build();
                    }
                    return Response.status(406).build();
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
    @Path("/update/{id_utilisateur}/{id}")
    public Response edit(@PathParam("id_utilisateur") int idUtilisateur, @PathParam("id") Integer id, @FormParam("nom_utilisateur") String nomUtilisateur, @FormParam("prenom_utilisateur") String prenomUtilisateur, @FormParam("email_utilisateur") String emailUtilisateur, @FormParam("type_utilisateur") String typeUtilisateur) {
        if (idUtilisateur != 0) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    Utilisateur entity = super.find(id);
                    if (entity != null) {
                        if (nomUtilisateur != null) {
                            entity.setNomUtilisateur(nomUtilisateur);
                        }
                        if (prenomUtilisateur != null) {
                            entity.setNomUtilisateur(prenomUtilisateur);
                        }
                        if (emailUtilisateur != null) {
                            entity.setNomUtilisateur(emailUtilisateur);
                        }
                        if (typeUtilisateur != null) {
                            entity.setNomUtilisateur(typeUtilisateur);
                        }
                        super.edit(entity);
                        return Response.status(200).build();
                    }
                    return Response.status(404).build();
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
    @Path("delete/{id_utilisateur}/{id}")
    public Response remove(@PathParam("id_utilisateur") int idUtilisateur, @PathParam("id") Integer id) {
        if (idUtilisateur != 0) {
            Utilisateur utilisateur = em.find(Utilisateur.class, idUtilisateur);
            if (utilisateur != null) {
                if ("admin".equalsIgnoreCase(utilisateur.getTypeUtilisateur())) {
                    Utilisateur entity = super.find(id);
                    if (entity != null) {
                        super.remove(super.find(id));
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
    public Utilisateur find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utilisateur> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
