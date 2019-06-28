package br.com.br.imusiccorp.challenge.service;

import br.com.imusiccorp.challenge.domain.entity.Product;
import br.com.imusiccorp.challenge.domain.repository.ProductRepository;
import br.com.imusiccorp.challenge.service.ProductService;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    protected ProductRepository repository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void getProducts() {
        productService.getProducts();

        verify(repository, times(1)).findAll();
    }

    @Test
    public void getProduct() {
        String id = "5d166b42908f003510c5f8bb";
        ObjectId objectId = new ObjectId(id);

        productService.getProduct(id);

        verify(repository, times(1)).findBy_id(objectId);
    }

    @Test
    public void getProductByName() {
        String name = "teste";

        productService.getProductByName(name);

        verify(repository, times(1)).findByName(name);
    }

    @Test
    public void create() {
        Product product = new Product("Teste", BigDecimal.ZERO, 0L);
        product.set_id(ObjectId.get());

        productService.create(product);

        verify(repository, times(1)).save(product);
    }

    @Test
    public void modify() {
        ObjectId objectId = new ObjectId("5d166b42908f003510c5f8bb");
        Product product = new Product("Teste", BigDecimal.ZERO, 0L);
        product.set_id(objectId);

        productService.modify(objectId, product);

        verify(repository, times(1)).save(product);
    }

    @Test
    public void delete() {
        ObjectId objectId = new ObjectId("5d166b42908f003510c5f8bb");
        Product mock = new Product("Teste", BigDecimal.ZERO, 0L);
        mock.set_id(objectId);

        when(repository.findBy_id(objectId)).thenReturn(mock);

        productService.delete(objectId);

        verify(repository, times(1)).findBy_id(objectId);
        verify(repository, times(1)).delete(mock);
    }
}
