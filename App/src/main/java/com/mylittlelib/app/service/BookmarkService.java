package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.BookmarkDTO;
import com.mylittlelib.app.model.Bookmark;
import com.mylittlelib.app.repository.BookmarkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookmarkService {
    @Autowired
    private BookmarkRepository bookmarkRepository;
    private Bookmark bookmark;
    public Bookmark save(Bookmark bookmark) {
        final String bookmarkTitle = bookmark.getBookmarkTitle();
        try{
            titleIsNull(bookmarkTitle);
            if(bookmarkRepository.findBookmarkByBookmarkTitle(bookmarkTitle) != null){
                log.warn("Bookmark already exists {}", bookmarkTitle);
                throw new RuntimeException("Bookmark alreay exists");
            }
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return bookmarkRepository.save(bookmark);
    }
    private void titleIsNull(String title){
        if(title == null || title.equals("")){
            log.error("title is null");
            throw  new RuntimeException("Invalid argument");
        }
    }

    public Bookmark updateBookmark(BookmarkDTO bookmarkDTO) {
        String title = bookmarkDTO.getBookmarkTitle();
        try{
            titleIsNull(title);
            bookmark = bookmarkRepository.findBookmarkByBookmarkTitle(title);
            bookmark.setBookmarkTitle(bookmarkDTO.getNewbookmarkTitle());
            bookmark.setDescription(bookmarkDTO.getNewdescription());
        }catch(NullPointerException e) {
            throw new RuntimeException("Not found title");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return bookmarkRepository.save(bookmark);
    }
}
