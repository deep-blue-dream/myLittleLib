package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.AuthorityGroupDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.AuthorityGroup;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.service.AuthorityGroupService;
import com.mylittlelib.app.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("authority")
@CrossOrigin("*")
public class AuthorityGroupController {

    @Autowired
    private AuthorityGroupService authorityGroupService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody AuthorityGroupDTO authorityGroupDTO){
        try {
            Category getCategory = categoryService.findByIndex(authorityGroupDTO.getCategoryIndex());
            AuthorityGroup authorityGroup = AuthorityGroup.builder()
                    .groupLevel(authorityGroupDTO.getGroupLevel())
                    .category(getCategory).build();
            AuthorityGroup registerAuthorityGroup = authorityGroupService.save(authorityGroup, getCategory);
            AuthorityGroupDTO responseGroupDTO = AuthorityGroupDTO.builder()
                    .groupIndex(registerAuthorityGroup.getGroupIndex())
                    .groupLevel(registerAuthorityGroup.getGroupLevel())
                    .categoryIndex(registerAuthorityGroup.getCategory().getCategoryIndex())
                    .build();
            return ResponseEntity.ok(responseGroupDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody AuthorityGroupDTO authorityGroupDTO){
        try{
            Category getCategory = categoryService.findByIndex(authorityGroupDTO.getCategoryIndex());
            AuthorityGroup authorityGroup = authorityGroupService.update(authorityGroupDTO,getCategory);
            AuthorityGroupDTO responseGroupDTO = AuthorityGroupDTO.builder()
                    .groupIndex(authorityGroup.getGroupIndex())
                    .categoryIndex(authorityGroup.getCategory().getCategoryIndex())
                    .groupLevel(authorityGroup.getGroupLevel())
                    .build();
            return ResponseEntity.ok(responseGroupDTO);
        }catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
