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

import co.edu.uniandes.csw.bakery.ejbs.ProductLogic;
import co.edu.uniandes.csw.bakery.api.IProductLogic;
import co.edu.uniandes.csw.bakery.entities.ProductEntity;
import co.edu.uniandes.csw.bakery.entities.BakerEntity;
import co.edu.uniandes.csw.bakery.persistence.ProductPersistence;
import co.edu.uniandes.csw.bakery.entities.BakerEntity;
import co.edu.uniandes.csw.bakery.entities.CategoryEntity;
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
public class ProductLogicTest {

    /**
     * @generated
     */
    BakerEntity fatherEntity;

    /**
     * @generated
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * @generated
     */
    @Inject
    private IProductLogic productLogic;

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
    private List<ProductEntity> data = new ArrayList<ProductEntity>();
    /**
     * @generated
     */
    private List<BakerEntity> bakerData = new ArrayList<>();
    /**
     * @generated
     */
    private List<CategoryEntity> categoryData = new ArrayList<>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ProductLogic.class.getPackage())
                .addPackage(IProductLogic.class.getPackage())
                .addPackage(ProductPersistence.class.getPackage())
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
        em.createQuery("delete from ProductEntity").executeUpdate();
        em.createQuery("delete from BakerEntity").executeUpdate();
        em.createQuery("delete from CategoryEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     *
     * @generated
     */
    private void insertData() {
            for (int i = 0; i < 3; i++) {
                CategoryEntity category = factory.manufacturePojo(CategoryEntity.class);
                em.persist(category);
                categoryData.add(category);
            }
    
            fatherEntity = factory.manufacturePojo(BakerEntity.class);
            fatherEntity.setId(1L);
            em.persist(fatherEntity);
        for (int i = 0; i < 3; i++) {
            ProductEntity entity = factory.manufacturePojo(ProductEntity.class);
                entity.setBaker(fatherEntity);
    
                entity.getCategory().add(categoryData.get(0));

            em.persist(entity);
            data.add(entity);
        }
    }
   /**
     * Prueba para crear un Product
     *
     * @generated
     */
    @Test
    public void createProductTest() {
        ProductEntity newEntity = factory.manufacturePojo(ProductEntity.class);
        ProductEntity result = productLogic.createProduct(fatherEntity.getId(), newEntity);
        Assert.assertNotNull(result);
        ProductEntity entity = em.find(ProductEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getImage(), entity.getImage());
        Assert.assertEquals(newEntity.getPrice(), entity.getPrice());
    }

    /**
     * Prueba para consultar la lista de Products
     *
     * @generated
     */
    @Test
    public void getProductsTest() {
        List<ProductEntity> list = productLogic.getProducts(fatherEntity.getId());
        Assert.assertEquals(data.size(), list.size());
        for (ProductEntity entity : list) {
            boolean found = false;
            for (ProductEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar un Product
     *
     * @generated
     */
    @Test
    public void getProductTest() {
        ProductEntity entity = data.get(0);
        ProductEntity resultEntity = productLogic.getProduct(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getImage(), resultEntity.getImage());
        Assert.assertEquals(entity.getPrice(), resultEntity.getPrice());
    }

    /**
     * Prueba para eliminar un Product
     *
     * @generated
     */
    @Test
    public void deleteProductTest() {
        ProductEntity entity = data.get(0);
        productLogic.removeCategory(entity.getId(), categoryData.get(0).getId());
        productLogic.deleteProduct(entity.getId());
        ProductEntity deleted = em.find(ProductEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Product
     *
     * @generated
     */
    @Test
    public void updateProductTest() {
        ProductEntity entity = data.get(0);
        ProductEntity pojoEntity = factory.manufacturePojo(ProductEntity.class);

        pojoEntity.setId(entity.getId());

        productLogic.updateProduct(fatherEntity.getId(), pojoEntity);

        ProductEntity resp = em.find(ProductEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getImage(), resp.getImage());
        Assert.assertEquals(pojoEntity.getPrice(), resp.getPrice());
    }

    /**
     * Prueba para obtener una instancia de Category asociada a una instancia Product
     *
     * @generated
     */
    @Test
    public void getCategoryTest() {
        ProductEntity entity = data.get(0);
        CategoryEntity categoryEntity = categoryData.get(0);
        CategoryEntity response = productLogic.getCategory(entity.getId(), categoryEntity.getId());

        Assert.assertEquals(categoryEntity.getId(), response.getId());
        Assert.assertEquals(categoryEntity.getName(), response.getName());
    }

    /**
     * Prueba para obtener una colección de instancias de Category asociadas a una instancia Product
     *
     * @generated
     */
    @Test
    public void listCategoryTest() {
        List<CategoryEntity> list = productLogic.listCategory(data.get(0).getId());
        Assert.assertEquals(1, list.size());
    }

    /**
     *Prueba para asociar un Category existente a un Product
     *
     * @generated
     */
    @Test
    public void addCategoryTest() {
        ProductEntity entity = data.get(0);
        CategoryEntity categoryEntity = categoryData.get(1);
        CategoryEntity response = productLogic.addCategory(entity.getId(), categoryEntity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(categoryEntity.getId(), response.getId());
    }

    /**
     * Prueba para remplazar las instancias de Category asociadas a una instancia de Product
     *
     * @generated
     */
    @Test
    public void replaceCategoryTest() {
        ProductEntity entity = data.get(0);
        List<CategoryEntity> list = categoryData.subList(1, 3);
        productLogic.replaceCategory(entity.getId(), list);

        entity = productLogic.getProduct(entity.getId());
        Assert.assertFalse(entity.getCategory().contains(categoryData.get(0)));
        Assert.assertTrue(entity.getCategory().contains(categoryData.get(1)));
        Assert.assertTrue(entity.getCategory().contains(categoryData.get(2)));
    }

    /**
     * Prueba para desasociar un Category existente de un Product existente
     *
     * @generated
     */
    @Test
    public void removeCategoryTest() {
        productLogic.removeCategory(data.get(0).getId(), categoryData.get(0).getId());
        CategoryEntity response = productLogic.getCategory(data.get(0).getId(), categoryData.get(0).getId());
        Assert.assertNull(response);
    }
}

