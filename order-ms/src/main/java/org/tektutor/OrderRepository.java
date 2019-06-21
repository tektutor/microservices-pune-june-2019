package org.tektutor;

import java.util.ArrayList;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc="order")
public interface OrderRepository extends CouchbaseRepository<Order, Integer> {

    @Query("#{#n1ql.selectEntity} where customerId = $1 within #{#n1ql.bucket}")
    ArrayList<org.tektutor.Order> findByCustomerId(int customerId);

}