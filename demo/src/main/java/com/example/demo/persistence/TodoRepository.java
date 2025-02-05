package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

  List<TodoEntity> findByUserId(String userId);
/*
  @Query("select * from TodoEntity t where t.userId = ?1")
  List<TodoEntity> findByUserIdQuery(String userId);*/
}
