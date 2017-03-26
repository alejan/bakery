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
package co.edu.uniandes.csw.bakery.test.persistence;
import co.edu.uniandes.csw.bakery.entities.BakerEntity;
import co.edu.uniandes.csw.bakery.entities.ContactEntity;
import co.edu.uniandes.csw.bakery.persistence.ContactPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ContactPersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ContactEntity.class.getPackage())
                .addPackage(ContactPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    BakerEntity fatherEntity;

    /**
     * @generated
     */
    @Inject
    private ContactPersistence contactPersistence;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ContactEntity").executeUpdate();
        em.createQuery("delete from BakerEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ContactEntity> data = new ArrayList<ContactEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
            fatherEntity = factory.manufacturePojo(BakerEntity.class);
            fatherEntity.setId(1L);
            em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            ContactEntity entity = factory.manufacturePojo(ContactEntity.class);
            
            entity.setBaker(fatherEntity);
            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un Contact.
     *
     * @generated
     */
    @Test
    public void createContactTest() {
		PodamFactory factory = new PodamFactoryImpl();
        ContactEntity newEntity = factory.manufacturePojo(ContactEntity.class);
        newEntity.setBaker(fatherEntity);
        ContactEntity result = contactPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ContactEntity entity = em.find(ContactEntity.class, result.getId());

        Assert.assertEquals(newEntity.getCel(), entity.getCel());
        Assert.assertEquals(newEntity.getEmail(), entity.getEmail());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de Contacts.
     *
     * @generated
     */
    @Test
    public void getContactsTest() {
        List<ContactEntity> list = contactPersistence.findAll(null, null, fatherEntity.getId());
        Assert.assertEquals(data.size(), list.size());
        for (ContactEntity ent : list) {
            boolean found = false;
            for (ContactEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Contact.
     *
     * @generated
     */
    @Test
    public void getContactTest() {
        ContactEntity entity = data.get(0);
        ContactEntity newEntity = contactPersistence.find(entity.getBaker().getId(), entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getCel(), newEntity.getCel());
        Assert.assertEquals(entity.getEmail(), newEntity.getEmail());
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Prueba para eliminar un Contact.
     *
     * @generated
     */
    @Test
    public void deleteContactTest() {
        ContactEntity entity = data.get(0);
        contactPersistence.delete(entity.getId());
        ContactEntity deleted = em.find(ContactEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Contact.
     *
     * @generated
     */
    @Test
    public void updateContactTest() {
        ContactEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ContactEntity newEntity = factory.manufacturePojo(ContactEntity.class);

        newEntity.setId(entity.getId());

        contactPersistence.update(newEntity);

        ContactEntity resp = em.find(ContactEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getCel(), resp.getCel());
        Assert.assertEquals(newEntity.getEmail(), resp.getEmail());
        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
