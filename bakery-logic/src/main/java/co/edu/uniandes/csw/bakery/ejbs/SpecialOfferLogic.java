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
package co.edu.uniandes.csw.bakery.ejbs;

import co.edu.uniandes.csw.bakery.api.ISpecialOfferLogic;
import co.edu.uniandes.csw.bakery.entities.SpecialOfferEntity;
import co.edu.uniandes.csw.bakery.persistence.SpecialOfferPersistence;
import co.edu.uniandes.csw.bakery.entities.ProductEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class SpecialOfferLogic implements ISpecialOfferLogic {

    @Inject private SpecialOfferPersistence persistence;


    /**
     * Obtiene el número de registros de SpecialOffer.
     *
     * @return Número de registros de SpecialOffer.
     * @generated
     */
    public int countSpecialOffers() {
        return persistence.count();
    }

    /**
     * Obtiene la lista de los registros de SpecialOffer.
     *
     * @return Colección de objetos de SpecialOfferEntity.
     * @generated
     */
    @Override
    public List<SpecialOfferEntity> getSpecialOffers() {
        return persistence.findAll();
    }

    /**
     * Obtiene la lista de los registros de SpecialOffer indicando los datos para la paginación.
     *
     * @param page Número de página.
     * @param maxRecords Número de registros que se mostraran en cada página.
     * @return Colección de objetos de SpecialOfferEntity.
     * @generated
     */
    @Override
    public List<SpecialOfferEntity> getSpecialOffers(Integer page, Integer maxRecords) {
        return persistence.findAll(page, maxRecords);
    }

    /**
     * Obtiene los datos de una instancia de SpecialOffer a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de SpecialOfferEntity con los datos del SpecialOffer consultado.
     * @generated
     */
    public SpecialOfferEntity getSpecialOffer(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un SpecialOffer en la base de datos.
     *
     * @param entity Objeto de SpecialOfferEntity con los datos nuevos
     * @return Objeto de SpecialOfferEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public SpecialOfferEntity createSpecialOffer(SpecialOfferEntity entity) {
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de SpecialOffer.
     *
     * @param entity Instancia de SpecialOfferEntity con los nuevos datos.
     * @return Instancia de SpecialOfferEntity con los datos actualizados.
     * @generated
     */
    @Override
    public SpecialOfferEntity updateSpecialOffer(SpecialOfferEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de SpecialOffer de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @Override
    public void deleteSpecialOffer(Long id) {
        persistence.delete(id);
    }
  

    /**
     * Obtiene una colección de instancias de ProductEntity asociadas a una
     * instancia de SpecialOffer
     *
     * @param specialOfferId Identificador de la instancia de SpecialOffer
     * @return Colección de instancias de ProductEntity asociadas a la instancia de SpecialOffer
     * @generated
     */
    @Override
    public List<ProductEntity> listProducts(Long specialOfferId) {
        return getSpecialOffer(specialOfferId).getProducts();
    }

    /**
     * Obtiene una instancia de ProductEntity asociada a una instancia de SpecialOffer
     *
     * @param specialOfferId Identificador de la instancia de SpecialOffer
     * @param productsId Identificador de la instancia de Product
     * @generated
     */
    @Override
    public ProductEntity getProducts(Long specialOfferId, Long productsId) {
        List<ProductEntity> list = getSpecialOffer(specialOfferId).getProducts();
        ProductEntity productsEntity = new ProductEntity();
        productsEntity.setId(productsId);
        int index = list.indexOf(productsEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    /**
     * Asocia un Product existente a un SpecialOffer
     *
     * @param specialOfferId Identificador de la instancia de SpecialOffer
     * @param productsId Identificador de la instancia de Product
     * @return Instancia de ProductEntity que fue asociada a SpecialOffer
     * @generated
     */
    @Override
    public ProductEntity addProducts(Long specialOfferId, Long productsId) {
        SpecialOfferEntity specialOfferEntity = getSpecialOffer(specialOfferId);
        ProductEntity productsEntity = new ProductEntity();
        productsEntity.setId(productsId);
        specialOfferEntity.getProducts().add(productsEntity);
        return getProducts(specialOfferId, productsId);
    }

    /**
     * Remplaza las instancias de Product asociadas a una instancia de SpecialOffer
     *
     * @param specialOfferId Identificador de la instancia de SpecialOffer
     * @param list Colección de instancias de ProductEntity a asociar a instancia de SpecialOffer
     * @return Nueva colección de ProductEntity asociada a la instancia de SpecialOffer
     * @generated
     */
    @Override
    public List<ProductEntity> replaceProducts(Long specialOfferId, List<ProductEntity> list) {
        SpecialOfferEntity specialOfferEntity = getSpecialOffer(specialOfferId);
        specialOfferEntity.setProducts(list);
        return specialOfferEntity.getProducts();
    }

    /**
     * Desasocia un Product existente de un SpecialOffer existente
     *
     * @param specialOfferId Identificador de la instancia de SpecialOffer
     * @param productsId Identificador de la instancia de Product
     * @generated
     */
    @Override
    public void removeProducts(Long specialOfferId, Long productsId) {
        SpecialOfferEntity entity = getSpecialOffer(specialOfferId);
        ProductEntity productsEntity = new ProductEntity();
        productsEntity.setId(productsId);
        entity.getProducts().remove(productsEntity);
    }
}
