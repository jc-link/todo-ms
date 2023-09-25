package com.todoms.todoms.repository;

import com.todoms.todoms.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Repository("taskRepository")
public interface TaskRepository extends JpaRepository<Task, Serializable> {
    List<Task> findByCompletedTrue();
    List<Task> findByCompletedFalse();

    @Modifying
    @Transactional
    @Query("UPDATE Task t set t.completed = true where t.id = :id")
    int completeTaskById(@Param("id") int id);  
}
