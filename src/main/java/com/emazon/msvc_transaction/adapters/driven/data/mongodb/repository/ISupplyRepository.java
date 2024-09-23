package com.emazon.msvc_transaction.adapters.driven.data.mongodb.repository;

import com.emazon.msvc_transaction.adapters.driven.data.mongodb.document.SupplyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISupplyRepository extends MongoRepository<SupplyDocument, String> {
}
