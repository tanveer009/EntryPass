package com.entryPass.visitor.repository;

import org.springframework.data.repository.CrudRepository;

import com.entryPass.visitor.model.VisitorData;

public interface VisitorRepository extends CrudRepository<VisitorData,Long> {

}
