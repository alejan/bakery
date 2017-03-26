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

import co.edu.uniandes.csw.bakery.api.IContactLogic;
import co.edu.uniandes.csw.bakery.entities.ContactEntity;
import co.edu.uniandes.csw.bakery.persistence.ContactPersistence;
import co.edu.uniandes.csw.bakery.api.IBakerLogic;
import co.edu.uniandes.csw.bakery.entities.BakerEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 * @generated
 */
@Stateless
public class ContactLogic implements IContactLogic {

    @Inject private ContactPersistence persistence;

    @Inject
    private IBakerLogic bakerLogic;

    /**
     * Obtiene el número de registros de Contact.
     *
     * @return Número de registros de Contact.
     * @generated
     */
    public int countContacts() {
        return persistence.count();
    }

    /**
     * Obtiene la lista de los registros de Contact que pertenecen a un Baker.
     *
     * @param bakerid id del Baker el cual es padre de los Contacts.
     * @return Colección de objetos de ContactEntity.
     * @generated
     */
    @Override
    public List<ContactEntity> getContacts(Long bakerid) {
        BakerEntity baker = bakerLogic.getBaker(bakerid);
        return baker.getContacts();
        
    }

    /**
     * Obtiene la lista de los registros de Contact que pertenecen a un Baker indicando los datos para la paginación.
     *
     * @param page Número de página.
     * @param maxRecords Número de registros que se mostraran en cada página.
     * @param bakerid id del Baker el cual es padre de los Contacts.
     * @return Colección de objetos de ContactEntity.
     * @generated
     */
    @Override
    public List<ContactEntity> getContacts(Integer page, Integer maxRecords, Long bakerid) {
        return persistence.findAll(page, maxRecords, bakerid);
    }

    /**
     * Obtiene los datos de una instancia de Contact a partir de su ID.
     *
     * @pre La existencia del elemento padre Baker se debe garantizar.
     * @param contactid) Identificador del Contact a consultar
     * @return Instancia de ContactEntity con los datos del Contact consultado.
     * @generated
     */
    @Override
    public ContactEntity getContact(Long contactid) {
        try {
            return persistence.find(contactid);
        }catch(NoResultException e){
            throw new IllegalArgumentException("El Contact no existe");
        }
    }

    /**
     * Se encarga de crear un Contact en la base de datos.
     *
     * @param entity Objeto de ContactEntity con los datos nuevos
     * @param bakerid id del Baker el cual sera padre del nuevo Contact.
     * @return Objeto de ContactEntity con los datos nuevos y su ID.
     * @generated
     */
    @Override
    public ContactEntity createContact(Long bakerid, ContactEntity entity) {
        BakerEntity baker = bakerLogic.getBaker(bakerid);
        entity.setBaker(baker);
        entity = persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Contact.
     *
     * @param entity Instancia de ContactEntity con los nuevos datos.
     * @param bakerid id del Baker el cual sera padre del Contact actualizado.
     * @return Instancia de ContactEntity con los datos actualizados.
     * @generated
     */
    @Override
    public ContactEntity updateContact(Long bakerid, ContactEntity entity) {
        BakerEntity baker = bakerLogic.getBaker(bakerid);
        entity.setBaker(baker);
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Contact de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @param bakerid id del Baker el cual es padre del Contact.
     * @generated
     */
    @Override
    public void deleteContact(Long id) {
        ContactEntity old = getContact(id);
        persistence.delete(old.getId());
    }
  
}
