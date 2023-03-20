package com.codestates.hello_world.repository;

import com.codestates.hello_world.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
