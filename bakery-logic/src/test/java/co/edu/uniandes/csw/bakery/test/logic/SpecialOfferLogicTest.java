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
package co.edu.uniandes.csw.bakery.test.logic;

import co.edu.uniandes.csw.bakery.ejbs.SpecialOfferLogic;
import co.edu.uniandes.csw.bakery.api.ISpecialOfferLogic;
import co.edu.uniandes.csw.bakery.entities.SpecialOfferEntity;
import co.edu.uniandes.csw.bakery.persistence.SpecialOfferPersistence;
import co.edu.uniandes.csw.bakery.entities.ProductEntity;
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
public class SpecialOfferLogicTest {

    /**
     * @generated
     */

    /**
     * @generated
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * @generated
     */
    @Inject
    private ISpecialOfferLogic specialOfferLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    private UserTransaction utx;

    /**
     * @generated
     */
    private List<SpecialOfferEntity> data = new ArrayList<SpecialOfferEntity>();
    /**
     * @generated
     */
    private List<ProductEntity> productsData = new ArrayList<>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(SpecialOfferEntity.class.getPackage())
                .addPackage(SpecialOfferLogic.class.getPackage())
                .addPackage(ISpecialOfferLogic.class.getPackage())
                .addPackage(SpecialOfferPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
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
        em.createQuery("delete from SpecialOfferEntity").executeUpdate();
        em.createQuery("delete from ProductEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
            for (int i = 0; i < 3; i++) {
                ProductEntity products = factory.manufacturePojo(ProductEntity.class);
                em.persist(products);
                productsData.add(products);
            }
        for (int i = 0; i < 3; i++) {
            SpecialOfferEntity entity = factory.manufacturePojo(SpecialOfferEntity.class);
                entity.getProducts().add(productsData.get(0));

            em.persist(entity);
            data.add(entity);
        }
    }
    /**
     * Prueba para crear un SpecialOffer
     *
     * @generated
     */
    @Test
    public void createSpecialOfferTest() {
        SpecialOfferEntity newEntity = factory.manufacturePojo(SpecialOfferEntity.class);
        SpecialOfferEntity result = specialOfferLogic.createSpecialOffer(newEntity);
        Assert.assertNotNull(result);
        SpecialOfferEntity entity = em.find(SpecialOfferEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
    }

    /**
     * Prueba para consultar la lista de SpecialOffers
     *
     * @generated
     */
    @Test
    public void getSpecialOffersTest() {
        List<SpecialOfferEntity> list = specialOfferLogic.getSpecialOffers();
        Assert.assertEquals(data.size(), list.size());
        for (SpecialOfferEntity entity : list) {
            boolean found = false;
            for (SpecialOfferEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un SpecialOffer
     *
     * @generated
     */
    @Test
    public void getSpecialOfferTest() {
        SpecialOfferEntity entity = data.get(0);
        SpecialOfferEntity resultEntity = specialOfferLogic.getSpecialOffer(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getDescription(), resultEntity.getDescription());
    }

    /**
     * Prueba para eliminar un SpecialOffer
     *
     * @generated
     */
    @Test
    public void deleteSpecialOfferTest() {
        SpecialOfferEntity entity = data.get(0);
        specialOfferLogic.removeProducts(entity.getId(), productsData.get(0).getId());
        specialOfferLogic.deleteSpecialOffer(entity.getId());
        SpecialOfferEntity deleted = em.find(SpecialOfferEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un SpecialOffer
     *
     * @generated
     */
    @Test
    public void updateSpecialOfferTest() {
        SpecialOfferEntity entity = data.get(0);
        SpecialOfferEntity pojoEntity = factory.manufacturePojo(SpecialOfferEntity.class);

        pojoEntity.setId(entity.getId());

        specialOfferLogic.updateSpecialOffer(pojoEntity);

        SpecialOfferEntity resp = em.find(SpecialOfferEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getDescription(), resp.getDescription());
    }

    /**
     * Prueba para obtener una instancia de Products asociada a una instancia SpecialOffer
     *
     * @generated
     */
    @Test
    public void getProductsTest() {
        SpecialOfferEntity entity = data.get(0);
        ProductEntity productEntity = productsData.get(0);
        ProductEntity response = specialOfferLogic.getProducts(entity.getId(), productEntity.getId());

        Assert.assertEquals(productEntity.getId(), response.getId());
        Assert.assertEquals(productEntity.getName(), response.getName());
        Assert.assertEquals(productEntity.getImage(), response.getImage());
        Assert.assertEquals(productEntity.getPrice(), response.getPrice());
    }

    /**
     * Prueba para obtener una colección de instancias de Products asociadas a una instancia SpecialOffer
     *
     * @generated
     */
    @Test
    public void listProductsTest() {
        List<ProductEntity> list = specialOfferLogic.listProducts(data.get(0).getId());
        Assert.assertEquals(1, list.size());
    }

    /**
     *Prueba para asociar un Products existente a un SpecialOffer
     *
     * @generated
     */
    @Test
    public void addProductsTest() {
        SpecialOfferEntity entity = data.get(0);
        ProductEntity productEntity = productsData.get(1);
        ProductEntity response = specialOfferLogic.addProducts(entity.getId(), productEntity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(productEntity.getId(), response.getId());
    }

    /**
     * Prueba para remplazar las instancias de Products asociadas a una instancia de SpecialOffer
     *
     * @generated
     */
    @Test
    public void replaceProductsTest() {
        SpecialOfferEntity entity = data.get(0);
        List<ProductEntity> list = productsData.subList(1, 3);
        specialOfferLogic.replaceProducts(entity.getId(), list);

        entity = specialOfferLogic.getSpecialOffer(entity.getId());
        Assert.assertFalse(entity.getProducts().contains(productsData.get(0)));
        Assert.assertTrue(entity.getProducts().contains(productsData.get(1)));
        Assert.assertTrue(entity.getProducts().contains(productsData.get(2)));
    }

    /**
     * Prueba para desasociar un Products existente de un SpecialOffer existente
     *
     * @generated
     */
    @Test
    public void removeProductsTest() {
        specialOfferLogic.removeProducts(data.get(0).getId(), productsData.get(0).getId());
        ProductEntity response = specialOfferLogic.getProducts(data.get(0).getId(), productsData.get(0).getId());
        Assert.assertNull(response);
    }
}

