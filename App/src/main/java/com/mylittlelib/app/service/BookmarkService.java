package com.mylittlelib.app.service;

import com.mylittlelib.app.DTO.BookmarkDTO;
import com.mylittlelib.app.model.Bookmark;
import com.mylittlelib.app.repository.BookmarkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return bookmarkRepository.save(bookmark);
    }
    public Bookmark updateBookmark(BookmarkDTO bookmarkDTO) {
        String title = bookmarkDTO.getBookmarkTitle();
        try{
            titleIsNull(title);
            bookmark = bookmarkRepository.findBookmarkByBookmarkTitle(title);
            bookmark.setBookmarkTitle(bookmarkDTO.getNewbookmarkTitle());
            bookmark.setDescription(bookmarkDTO.getNewdescription());
            bookmark.setBookmarkurl(bookmarkDTO.getBookmarkUrl());
        }catch(NullPointerException e) {
            throw new RuntimeException("Not found title");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        return bookmarkRepository.save(bookmark);
    }

    public List<Bookmark> deleteBookmark(BookmarkDTO bookmarkDTO) {
        String title = bookmarkDTO.getBookmarkTitle();
        try{
            titleIsNull(title);
            bookmark = bookmarkRepository.findBookmarkByBookmarkTitle(title);
            bookmarkRepository.delete(bookmark);
            return bookmarkRepository.findAll();
        }catch (NullPointerException e) {
            throw new RuntimeException("Not found title");
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void titleIsNull(String title){
        if(title == null || title.equals("")){
            log.error("bookmarktitle is null");
            throw  new RuntimeException("Invalid argument");
        }
    }

    public List<Bookmark> findAll() {
        return bookmarkRepository.findAll();
    }
}
