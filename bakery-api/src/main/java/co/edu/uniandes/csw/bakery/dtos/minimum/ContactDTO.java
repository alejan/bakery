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
package co.edu.uniandes.csw.bakery.dtos.minimum;

import co.edu.uniandes.csw.bakery.entities.ContactEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @generated
 */
@XmlRootElement
public class ContactDTO  implements Serializable{

    private Long id;
    private String cel;
    private String email;
    private String name;


    /**
     * @generated
     */
    public ContactDTO() {
    }

    /**
     * Crea un objeto ContactDTO a partir de un objeto ContactEntity.
     *
     * @param entity Entidad ContactEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public ContactDTO(ContactEntity entity) {
	   if (entity!=null){
        this.id=entity.getId();
        this.cel=entity.getCel();
        this.email=entity.getEmail();
        this.name=entity.getName();
       }
    }

    /**
     * Convierte un objeto ContactDTO a ContactEntity.
     *
     * @return Nueva objeto ContactEntity.
     * @generated
     */
    public ContactEntity toEntity() {
        ContactEntity entity = new ContactEntity();
        entity.setId(this.getId());
        entity.setCel(this.getCel());
        entity.setEmail(this.getEmail());
        entity.setName(this.getName());
    return entity;
    }

    /**
     * Obtiene el atributo id.
     *
     * @return atributo id.
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor del atributo id.
     *
     * @param id nuevo valor del atributo
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el atributo cel.
     *
     * @return atributo cel.
     * @generated
     */
    public String getCel() {
        return cel;
    }

    /**
     * Establece el valor del atributo cel.
     *
     * @param cel nuevo valor del atributo
     * @generated
     */
    public void setCel(String cel) {
        this.cel = cel;
    }

    /**
     * Obtiene el atributo email.
     *
     * @return atributo email.
     * @generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el valor del atributo email.
     *
     * @param email nuevo valor del atributo
     * @generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el atributo name.
     *
     * @return atributo name.
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el valor del atributo name.
     *
     * @param name nuevo valor del atributo
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }


}
