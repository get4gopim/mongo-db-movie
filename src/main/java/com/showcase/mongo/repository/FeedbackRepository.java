package com.showcase.mongo.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.showcase.mongo.domain.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, BigInteger> {

	
}
