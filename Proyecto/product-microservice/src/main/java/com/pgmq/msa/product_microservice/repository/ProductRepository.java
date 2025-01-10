package com.pgmq.msa.product_microservice.repository;

import com.pgmq.msa.product_microservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <ProductEntity, String> {
}
