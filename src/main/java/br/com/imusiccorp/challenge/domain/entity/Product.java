package br.com.imusiccorp.challenge.domain.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Product POJO Object.
 *
 * @author Marcio Fraga
 *
 */
@Document
public class Product {

    @Id
    private ObjectId _id;

    private String name;
    private BigDecimal prize;
    private Long amount;

    /**
     * Empty product's constructor.
     */
    public Product(){

    }

    /**
     * Product's constructor with parameters.
     */
    public Product(String name, BigDecimal prize, Long amount) {
        this.name = name;
        this.prize = prize;
        this.amount = amount;
    }


    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
