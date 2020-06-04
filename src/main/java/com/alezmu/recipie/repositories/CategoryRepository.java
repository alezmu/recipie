package com.alezmu.recipie.repositories;

import com.alezmu.recipie.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
