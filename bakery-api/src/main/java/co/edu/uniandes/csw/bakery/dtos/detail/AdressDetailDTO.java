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
import co.edu.uniandes.csw.bakery.entities.AdressEntity;
import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * @generated
 */
@XmlRootElement
public class AdressDetailDTO extends AdressDTO{


    @PodamExclude
    private ClientDTO client;

    /**
     * @generated
     */
    public AdressDetailDTO() {
        super();
    }

    /**
     * Crea un objeto AdressDetailDTO a partir de un objeto AdressEntity incluyendo los atributos de AdressDTO.
     *
     * @param entity Entidad AdressEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public AdressDetailDTO(AdressEntity entity) {
        super(entity);
        if (entity.getClient()!=null){
        this.client = new ClientDTO(entity.getClient());
        }
        
    }

    /**
     * Convierte un objeto AdressDetailDTO a AdressEntity incluyendo los atributos de AdressDTO.
     *
     * @return Nueva objeto AdressEntity.
     * @generated
     */
    @Override
    public AdressEntity toEntity() {
        AdressEntity entity = super.toEntity();
        if (this.getClient()!=null){
        entity.setClient(this.getClient().toEntity());
        }
        return entity;
    }

    /**
     * Obtiene el atributo client.
     *
     * @return atributo client.
     * @generated
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * Establece el valor del atributo client.
     *
     * @param client nuevo valor del atributo
     * @generated
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

}
