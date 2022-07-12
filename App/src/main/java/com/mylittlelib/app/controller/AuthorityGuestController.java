package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.AuthorityGuestDTO;
import com.mylittlelib.app.model.AuthorityGroup;
import com.mylittlelib.app.service.AuthorityGroupService;
import com.mylittlelib.app.service.AuthorityGuestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authority")
@CrossOrigin("*")
@Slf4j
public class AuthorityGuestController {
    @Autowired
    private AuthorityGuestService authorityGuestService;

    @Autowired
    private AuthorityGroupService authorityGroupService;
//
//    @PostMapping("guest")
//    public ResponseEntity<?> save(@RequestBody AuthorityGuestDTO authorityGuestDTO){
//        try{
//            AuthorityGroup authorityGroup = authorityGroupService.findbyIndex(authorityGuestDTO.getGroupIndex());
//        }
//    }
}
