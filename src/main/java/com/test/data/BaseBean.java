package com.test.data;

import com.googlecode.objectify.annotation.Id;

/**
 * Base data bean
 * 
 * @author emondelo
 * 
 */
public class BaseBean {

    /**
     * The id of the bean.
     */
    @Id
    private Long id;

    /**
     * Returns the id attribute.
     *
     * @return id
     */
    public Long getId() {

        return id;
    }

    /**
     * Stores the id attribute.
     *
     * @param id
     *            id to store
     */
    public void setId(Long id) {

        this.id = id;
    }

}
