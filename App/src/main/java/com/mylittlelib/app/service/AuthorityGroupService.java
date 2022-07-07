package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.AuthorityGroupDTO;
import com.mylittlelib.app.model.AuthorityGroup;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.repository.AuthorityGroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class AuthorityGroupService {
    @Autowired
    private AuthorityGroupRepository authorityGroupRepository;

    public AuthorityGroup save(AuthorityGroup authorityGroup, Category category) {
        if(authorityGroupRepository.findAuthorityGroupByCategory(category) != null){
            log.error("이미 이 카테고리의 그룹 권한은 저장되어있다");
            throw new RuntimeException("Authority already exists");
        }
        return authorityGroupRepository.save(authorityGroup);
    }
    public AuthorityGroup update(AuthorityGroupDTO authorityGroupDTO,Category category) {
        if(authorityGroupRepository.findAuthorityGroupByCategory(category) == null){
            log.error("{}번째 카테고리는 그룹 권한 설정이 아직 안되있음 ");
            throw new RuntimeException("Invalid authority");
        }
        AuthorityGroup authorityGroup = authorityGroupRepository.findAuthorityGroupByCategory(category);
        authorityGroup.setGroupLevel(authorityGroupDTO.getGroupLevel());
        return authorityGroup;
    }
}
