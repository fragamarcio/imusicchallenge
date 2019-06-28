package br.com.imusiccorp.challenge.domain.repository;

import br.com.imusiccorp.challenge.domain.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Repository to product's operations.
 *
 * @author Marcio Fraga
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    /**
     * Fetch the product by the informed id. If the product do not exists, return null.
     *
     * @param _id
     * @return Product.
     *
     */
    Product findBy_id(ObjectId _id);

    /**
     * Fetch the product by the informed id. If the product do not exists, return null.
     *
     * @param name
     * @return Product.
     *
     */
    Product findByName(String name);

}

