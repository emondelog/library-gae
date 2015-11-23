package com.test.dao;

import com.test.data.BookBean;

/**
 * The DAO for books.
 * 
 * @author emondelo
 * 
 */
public class BookBeanDAO extends BaseBeanDAO<BookBean> {

    /**
     * Constructor
     */
    public BookBeanDAO() {

        super(BookBean.class);
    }
}
