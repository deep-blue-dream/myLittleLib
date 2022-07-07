package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.AuthorityGroup;
import com.mylittlelib.app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityGroupRepository extends JpaRepository<AuthorityGroup, Long> {
    AuthorityGroup findAuthorityGroupByCategory(Category category);
}
