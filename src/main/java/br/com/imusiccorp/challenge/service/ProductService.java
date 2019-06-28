package br.com.imusiccorp.challenge.service;

import br.com.imusiccorp.challenge.domain.entity.Product;
import br.com.imusiccorp.challenge.domain.repository.ProductRepository;
import com.sun.org.apache.xml.internal.security.utils.I18n;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Objects;

/**
 * Restful WebServices provider for product's operations.
 *
 * @author Marcio Fraga
 */
@RestController
@RequestMapping("/products")
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * List all products.
     *
     * @return product list;
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ServiceResponse<List<Product>> getProducts() {

        List<Product> products  = repository.findAll();

        ServiceResponse<List<Product>> response =  new ServiceResponse<>();
        response.setData(products);

        if(CollectionUtils.isEmpty(products))
            response.setMessage("Nenhum produto encontrado");

        return response;
    }

    /**
     * Fetch the product by the informed id. If the product don't exists return null.
     * @param id
     * @return product
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ServiceResponse<Product> getProduct(@PathVariable("id") String id) {
        Product product = repository.findBy_id(new ObjectId(id));

        ServiceResponse<Product> response =  new ServiceResponse<>();
        response.setData(product);

        if(Objects.isNull(product))
            response.setMessage("Produto não encontrado.");
        return response;
    }


    /**
     * Fetch the product by the informed name. If the product don't exists return null.
     * @param name
     * @return product
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ServiceResponse<Product> getProductByName(@PathVariable("name") String name) {

        Product product = repository.findByName(name);

        ServiceResponse<Product> response =  new ServiceResponse<>();
        response.setData(product);

        if(Objects.isNull(product))
            response.setMessage("Produto não encontrado.");
        return response;
    }


    /**
     * Create a new product.
     * @param product
     * @return product
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ServiceResponse<Product> create(@Valid @RequestBody Product product) {
        product.set_id(ObjectId.get());
        return this.save(product);
    }

    /**
     * Modify product's data by the informed id.
     *
     * @param id
     * @param product
     *
     * @return product
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ServiceResponse<Product> modify(@PathVariable("id") ObjectId id, @Valid @RequestBody Product product) {
        product.set_id(id);
        return this.save(product);
    }

    /**
     * Remove a product by the informed id.
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ServiceResponse<Product> delete(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));

        ServiceResponse<Product> response =  new ServiceResponse<>();
        response.setMessage("Produto excluido com sucesso.");
        return response;
    }

    private ServiceResponse<Product> save(Product product){
        repository.save(product);

        ServiceResponse<Product> response =  new ServiceResponse<>();
        response.setData(product);
        return response;
    }
}