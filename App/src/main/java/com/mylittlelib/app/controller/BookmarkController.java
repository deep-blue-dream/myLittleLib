package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.BookmarkDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Bookmark;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.service.BookmarkService;
import com.mylittlelib.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookmark")
public class BookmarkController {
    @Autowired
    BookmarkService bookmarkService;
    @Autowired
    CategoryService categoryService;
    //like 생성자는 일단 보류
    @GetMapping
    public ResponseEntity<?> save(@RequestBody BookmarkDTO bookmarkDTO){
        try {
            Category getCategory = categoryService.findByTitle(bookmarkDTO.getCategorytitle());
            Bookmark bookmark = Bookmark.builder()
                    .bookmarkTitle(bookmarkDTO.getBookmarkTitle())
                    .description(bookmarkDTO.getDescription())
                    .category(getCategory)
                    .build();
            Bookmark registerBookmark = bookmarkService.save(bookmark);
            BookmarkDTO responseBookmarkDTO = BookmarkDTO.builder()
                    .bookmarkIndex(registerBookmark.getBookmarkIndex())
                    .categorytitle(registerBookmark.getCategory().getCategoryTitle())
                    .bookmarkTitle(registerBookmark.getBookmarkTitle())
                    .description(registerBookmark.getDescription())
                    .build();
            return ResponseEntity.ok(responseBookmarkDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
