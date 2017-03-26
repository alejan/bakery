/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.bakery.resources;

import co.edu.uniandes.csw.auth.provider.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.bakery.api.IContactLogic;
import co.edu.uniandes.csw.bakery.dtos.detail.ContactDetailDTO;
import co.edu.uniandes.csw.bakery.entities.ContactEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: bakers/{bakersId: \\d+}/contacts
 * @generated
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactsResource {

    @Inject private IContactLogic contactLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;
    @PathParam("bakersId") private Long bakersId;

   
    /**
     * Convierte una lista de ContactEntity a una lista de ContactDetailDTO
     *
     * @param entityList Lista de ContactEntity a convertir
     * @return Lista de ContactDetailDTO convertida
     * @generated
     */
    private List<ContactDetailDTO> listEntity2DTO(List<ContactEntity> entityList){
        List<ContactDetailDTO> list = new ArrayList<>();
        for (ContactEntity entity : entityList) {
            list.add(new ContactDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de Contact asociados a un Baker
     *
     * @return Colección de objetos de ContactDetailDTO
     * @generated
     */
    @GET
    public List<ContactDetailDTO> getContactss() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", contactLogic.countContacts());
            return listEntity2DTO(contactLogic.getContacts(page, maxRecords, bakersId));
        }
        return listEntity2DTO(contactLogic.getContacts(bakersId));
    }

    /**
     * Obtiene los datos de una instancia de Contact a partir de su ID asociado a un Baker
     *
     * @param contactsId Identificador de la instancia a consultar
     * @return Instancia de ContactDetailDTO con los datos del Contact consultado
     * @generated
     */
    @GET
    @Path("{contactsId: \\d+}")
    public ContactDetailDTO getContacts(@PathParam("contactsId") Long contactsId) {
        ContactEntity entity = contactLogic.getContact(contactsId);
        if (entity.getBaker() != null && !bakersId.equals(entity.getBaker().getId())) {
            throw new WebApplicationException(404);
        }
        return new ContactDetailDTO(entity);
    }

    /**
     * Asocia un Contact existente a un Baker
     *
     * @param dto Objeto de ContactDetailDTO con los datos nuevos
     * @return Objeto de ContactDetailDTOcon los datos nuevos y su ID.
     * @generated
     */
    @POST
    @StatusCreated
    public ContactDetailDTO createContacts(ContactDetailDTO dto) {
        return new ContactDetailDTO(contactLogic.createContact(bakersId, dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de Contact.
     *
     * @param contactsId Identificador de la instancia de Contact a modificar
     * @param dto Instancia de ContactDetailDTO con los nuevos datos.
     * @return Instancia de ContactDetailDTO con los datos actualizados.
     * @generated
     */
    @PUT
    @Path("{contactsId: \\d+}")
    public ContactDetailDTO updateContacts(@PathParam("contactsId") Long contactsId, ContactDetailDTO dto) {
        ContactEntity entity = dto.toEntity();
        entity.setId(contactsId);
        return new ContactDetailDTO(contactLogic.updateContact(bakersId, entity));
    }

    /**
     * Elimina una instancia de Contact de la base de datos.
     *
     * @param contactId Identificador de la instancia a eliminar.
     * @generated
     */
    @DELETE
    @Path("contactsId: \\d+}")
    public void deleteContacts(@PathParam("contactsId") Long contactsId) {
        contactLogic.deleteContact(contactsId);
    }
    
}
