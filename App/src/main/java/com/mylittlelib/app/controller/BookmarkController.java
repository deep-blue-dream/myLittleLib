package com.mylittlelib.app.controller;

import com.mylittlelib.app.DTO.BookmarkDTO;
import com.mylittlelib.app.DTO.ResponseDTO;
import com.mylittlelib.app.model.Bookmark;
import com.mylittlelib.app.model.Category;
import com.mylittlelib.app.service.BookmarkService;
import com.mylittlelib.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bookmark")
@CrossOrigin("*")
public class BookmarkController {
    @Autowired
    BookmarkService bookmarkService;
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Bookmark> bookmarks = bookmarkService.findAll();
        List<BookmarkDTO> dtos =bookmarks.stream().map(BookmarkDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    //like 생성자는 일단 보류
    @PostMapping("save")
    public ResponseEntity<?> saveBookmark(@RequestBody BookmarkDTO bookmarkDTO){
        try {
            Category getCategory = categoryService.findByTitle(bookmarkDTO.getCategorytitle());
            Bookmark bookmark = Bookmark.builder()
                    .bookmarkTitle(bookmarkDTO.getBookmarkTitle())
                    .description(bookmarkDTO.getDescription())
                    .category(getCategory)
                    .bookmarkurl(bookmarkDTO.getBookmarkUrl())
                    .build();
            Bookmark registerBookmark = bookmarkService.save(bookmark);
            BookmarkDTO responseBookmarkDTO = BookmarkDTO.builder()
                    .bookmarkIndex(registerBookmark.getBookmarkIndex())
                    .categorytitle(registerBookmark.getCategory().getCategoryTitle())
                    .bookmarkTitle(registerBookmark.getBookmarkTitle())
                    .description(registerBookmark.getDescription())
                    .bookmarkUrl(registerBookmark.getBookmarkurl())
                    .build();
            return ResponseEntity.ok(responseBookmarkDTO);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @PutMapping()
    public ResponseEntity<?> updateBookmark(@RequestBody BookmarkDTO bookmarkDTO){
        try {
            Bookmark bookmark = bookmarkService.updateBookmark(bookmarkDTO);
            BookmarkDTO responseBookmarkDTO = BookmarkDTO.builder()
                    .bookmarkIndex(bookmark.getBookmarkIndex())
                    .bookmarkTitle(bookmark.getBookmarkTitle())
                    .description(bookmark.getDescription())
                    .categorytitle(bookmark.getCategory().getCategoryTitle())
                    .bookmarkUrl(bookmark.getBookmarkurl())
                    .build();
            return ResponseEntity.ok(responseBookmarkDTO);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteBookmark(@RequestBody BookmarkDTO bookmarkDTO){
        try{
            List<Bookmark> bookmarks = bookmarkService.deleteBookmark(bookmarkDTO);
            List<BookmarkDTO> dtos = bookmarks.stream().map(BookmarkDTO::new).collect(Collectors.toList());
           return ResponseEntity.ok(dtos);
        }catch (Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return  ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
