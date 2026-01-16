package com.rca.OneToMany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rca.OneToMany.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
