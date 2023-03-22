package com.codestates.CordJg.hello_world.repository;

import com.codestates.CordJg.hello_world.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
