package com.mylittlelib.app.DTO;


import com.mylittlelib.app.model.Bookmark;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDTO {

    private Long bookmarkIndex;
    private String bookmarkTitle;
    private String description;
    private String categorytitle;
    private String bookmarkUrl;
    //new
    private String newbookmarkTitle;
    private String newdescription;

    public BookmarkDTO(Bookmark bookmark){
        this.bookmarkIndex = bookmark.getBookmarkIndex();
        this.bookmarkTitle = bookmark.getBookmarkTitle();
        this.description = bookmark.getDescription();
        this.categorytitle = bookmark.getCategory().getCategoryTitle();
        this.bookmarkUrl = bookmark.getBookmarkurl();
    }
}