package com.test.data;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Book data bean
 * 
 * @author emondelo
 * 
 */
@Entity
@Cache
@ApiModel("Book object")
public class BookBean extends BaseBean {

    /**
     * Constant with the field values of the class.
     */
    public static final String FIELD_VALUES = "id,name,author,year,genre";

    /**
     * The title of the book.
     */
    @ApiModelProperty(required = true)
    @Index
    private String name;

    /**
     * The author of the book.
     */
    @Index
    private String author;

    /**
     * The year of the book.
     */
    @Index
    private Integer year;

    /**
     * The genre of the book.
     */
    @Index
    private String genre;

    /**
     * Returns the name attribute.
     *
     * @return name
     */
    public String getName() {

        return name;
    }

    /**
     * Stores the name attribute.
     *
     * @param name
     *            name to store.
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * Returns the author attribute.
     *
     * @return author
     */
    public String getAuthor() {

        return author;
    }

    /**
     * Stores the author attribute.
     *
     * @param author
     *            author to store.
     */
    public void setAuthor(String author) {

        this.author = author;
    }

    /**
     * Returns the year attribute.
     *
     * @return year
     */
    public Integer getYear() {

        return year;
    }

    /**
     * Stores the year attribute.
     *
     * @param year
     *            year to store.
     */
    public void setYear(Integer year) {

        this.year = year;
    }

    /**
     * Returns the genre attribute.
     *
     * @return genre
     */
    public String getGenre() {

        return genre;
    }

    /**
     * Stores the genre attribute
     *
     * @param genre
     *            genre to store.
     */
    public void setGenre(String genre) {

        this.genre = genre;
    }

}
