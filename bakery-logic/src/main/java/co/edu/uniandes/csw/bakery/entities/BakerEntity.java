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
package co.edu.uniandes.csw.bakery.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;


/**
 * @generated
 */
@Entity
public class BakerEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToMany(mappedBy = "baker", cascade = CascadeType.REMOVE)
    private List<ContactEntity> contacts = new ArrayList<>();

    @PodamExclude
    @OneToMany(mappedBy = "baker", cascade = CascadeType.REMOVE)
    private List<ProductEntity> products = new ArrayList<>();

    /**
     * Obtiene la colección de contacts.
     *
     * @return colección contacts.
     * @generated
     */
    public List<ContactEntity> getContacts() {
        return contacts;
    }

    /**
     * Establece el valor de la colección de contacts.
     *
     * @param contacts nuevo valor de la colección.
     * @generated
     */
    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    /**
     * Obtiene la colección de products.
     *
     * @return colección products.
     * @generated
     */
    public List<ProductEntity> getProducts() {
        return products;
    }

    /**
     * Establece el valor de la colección de products.
     *
     * @param products nuevo valor de la colección.
     * @generated
     */
    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
