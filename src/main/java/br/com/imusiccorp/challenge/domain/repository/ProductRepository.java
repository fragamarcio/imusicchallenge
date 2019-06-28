package br.com.imusiccorp.challenge.domain.repository;

import br.com.imusiccorp.challenge.domain.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {

    Product findBy_id(ObjectId _id);

    Product findByName(String name);

}

