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
package co.edu.uniandes.csw.bakery.dtos.detail;

import co.edu.uniandes.csw.bakery.dtos.minimum.*;
import co.edu.uniandes.csw.bakery.entities.ContactEntity;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement
public class ContactDetailDTO extends ContactDTO{


    @PodamExclude
    private BakerDTO baker;

    /**
     * @generated
     */
    public ContactDetailDTO() {
        super();
    }

    /**
     * Crea un objeto ContactDetailDTO a partir de un objeto ContactEntity incluyendo los atributos de ContactDTO.
     *
     * @param entity Entidad ContactEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public ContactDetailDTO(ContactEntity entity) {
        super(entity);
        if (entity.getBaker()!=null){
        this.baker = new BakerDTO(entity.getBaker());
        }
        
    }

    /**
     * Convierte un objeto ContactDetailDTO a ContactEntity incluyendo los atributos de ContactDTO.
     *
     * @return Nueva objeto ContactEntity.
     * @generated
     */
    @Override
    public ContactEntity toEntity() {
        ContactEntity entity = super.toEntity();
        if (this.getBaker()!=null){
        entity.setBaker(this.getBaker().toEntity());
        }
        return entity;
    }

    /**
     * Obtiene el atributo baker.
     *
     * @return atributo baker.
     * @generated
     */
    public BakerDTO getBaker() {
        return baker;
    }

    /**
     * Establece el valor del atributo baker.
     *
     * @param baker nuevo valor del atributo
     * @generated
     */
    public void setBaker(BakerDTO baker) {
        this.baker = baker;
    }

}
