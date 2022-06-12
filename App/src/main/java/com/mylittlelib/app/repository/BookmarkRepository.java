package com.mylittlelib.app.repository;

import com.mylittlelib.app.model.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    Bookmark findBookmarkByBookmarkTitle(String title);
}
