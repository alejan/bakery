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
import co.edu.uniandes.csw.bakery.api.ISpecialOfferLogic;
import co.edu.uniandes.csw.bakery.dtos.detail.SpecialOfferDetailDTO;
import co.edu.uniandes.csw.bakery.entities.SpecialOfferEntity;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 * URI: specialOffers/
 * @generated
 */
@Path("/specialOffers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SpecialOfferResource {

    @Inject private ISpecialOfferLogic specialOfferLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("limit") private Integer maxRecords;

   
    /**
     * Convierte una lista de SpecialOfferEntity a una lista de SpecialOfferDetailDTO.
     *
     * @param entityList Lista de SpecialOfferEntity a convertir.
     * @return Lista de SpecialOfferDetailDTO convertida.
     * @generated
     */
    private List<SpecialOfferDetailDTO> listEntity2DTO(List<SpecialOfferEntity> entityList){
        List<SpecialOfferDetailDTO> list = new ArrayList<>();
        for (SpecialOfferEntity entity : entityList) {
            list.add(new SpecialOfferDetailDTO(entity));
        }
        return list;
    }


    /**
     * Obtiene la lista de los registros de SpecialOffer
     *
     * @return Colección de objetos de SpecialOfferDetailDTO
     * @generated
     */
    @GET
    public List<SpecialOfferDetailDTO> getSpecialOffers() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", specialOfferLogic.countSpecialOffers());
            return listEntity2DTO(specialOfferLogic.getSpecialOffers(page, maxRecords));
        }
        return listEntity2DTO(specialOfferLogic.getSpecialOffers());
    }

    /**
     * Obtiene los datos de una instancia de SpecialOffer a partir de su ID
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de SpecialOfferDetailDTO con los datos del SpecialOffer consultado
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public SpecialOfferDetailDTO getSpecialOffer(@PathParam("id") Long id) {
        return new SpecialOfferDetailDTO(specialOfferLogic.getSpecialOffer(id));
    }

    /**
     * Se encarga de crear un SpecialOffer en la base de datos
     *
     * @param dto Objeto de SpecialOfferDetailDTO con los datos nuevos
     * @return Objeto de SpecialOfferDetailDTOcon los datos nuevos y su ID
     * @generated
     */
    @POST
    @StatusCreated
    public SpecialOfferDetailDTO createSpecialOffer(SpecialOfferDetailDTO dto) {
        return new SpecialOfferDetailDTO(specialOfferLogic.createSpecialOffer(dto.toEntity()));
    }

    /**
     * Actualiza la información de una instancia de SpecialOffer
     *
     * @param id Identificador de la instancia de SpecialOffer a modificar
     * @param dto Instancia de SpecialOfferDetailDTO con los nuevos datos
     * @return Instancia de SpecialOfferDetailDTO con los datos actualizados
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public SpecialOfferDetailDTO updateSpecialOffer(@PathParam("id") Long id, SpecialOfferDetailDTO dto) {
        SpecialOfferEntity entity = dto.toEntity();
        entity.setId(id);
        SpecialOfferEntity oldEntity = specialOfferLogic.getSpecialOffer(id);
        entity.setProducts(oldEntity.getProducts());
        return new SpecialOfferDetailDTO(specialOfferLogic.updateSpecialOffer(entity));
    }

    /**
     * Elimina una instancia de SpecialOffer de la base de datos
     *
     * @param id Identificador de la instancia a eliminar
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSpecialOffer(@PathParam("id") Long id) {
        specialOfferLogic.deleteSpecialOffer(id);
    }
    public void existsSpecialOffer(Long specialOffersId){
        SpecialOfferDetailDTO specialOffer = getSpecialOffer(specialOffersId);
        if (specialOffer== null) {
            throw new WebApplicationException(404);
        }
    }
    
    
    @Path("{specialOffersId: \\d+}/products")
    public Class<SpecialOfferProductsResource> getSpecialOfferProductsResource(@PathParam("specialOffersId") Long specialOffersId){
        existsSpecialOffer(specialOffersId);
        return SpecialOfferProductsResource.class;
    }
    
}
