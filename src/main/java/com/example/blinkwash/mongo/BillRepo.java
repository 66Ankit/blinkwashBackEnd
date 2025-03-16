package com.example.blinkwash.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillRepo extends MongoRepository<Bill,String> {
}
