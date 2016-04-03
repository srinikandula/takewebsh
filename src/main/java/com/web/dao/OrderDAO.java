package com.web.dao;

import com.web.model.MyOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by njonnala on 4/1/2016.
 */
public interface OrderDAO extends CrudRepository<MyOrder, Integer> {
}
