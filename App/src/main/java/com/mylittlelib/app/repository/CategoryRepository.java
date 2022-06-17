package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findCategoryByCategoryTitle(String title);

    List<Category> findByUser(User user);
}
