package com.test.dao;

import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.ObjectifyService;
import com.test.data.BaseBean;

/**
 * The DAO for beans.
 * 
 * @author emondelo
 * 
 */
public class BaseBeanDAO<T extends BaseBean> {

    private static final Logger LOGGER = Logger.getLogger(BaseBeanDAO.class.getName());

    /**
     * The prefix for descending sort.
     */
    private static final String DESC_PREFIX = "-";

    /**
     * The ID field name.
     */
    private static final String ID_FIELD_NAME = "id";

    /**
     * The class type.
     */
    private final Class<T> classType;

    /**
     * Constructor
     * 
     * @param classType
     *            The class of the object.
     */
    public BaseBeanDAO(Class<T> classType) {

        this.classType = classType;
    }

    /**
     * Returns the stored list of beans according the possible sort criteria.
     * 
     * @param fieldToSortBy
     *            The field name to sort the result list.
     * @param descendingSort
     *            True to apply descending sort, false to apply ascending sort.
     * 
     * @return The list of beans.
     */
    public List<T> list(String fieldToSortBy, Boolean descendingSort) {

        LOGGER.info("Retrieving list of ordered beans");
        StringBuilder sortCriteria = new StringBuilder();

        if (descendingSort != null && descendingSort) {
            sortCriteria.append(DESC_PREFIX);
        }

        if (fieldToSortBy == null || fieldToSortBy.equals("")) {
            sortCriteria.append(ID_FIELD_NAME);
        } else {
            sortCriteria.append(fieldToSortBy);
        }

        LOGGER.info("sortCriteria: " + sortCriteria.toString());
        return ObjectifyService.ofy().load().type(classType).order(sortCriteria.toString()).list();
    }

    /**
     * Returns given bean.
     * 
     * @param id
     *            The id to retrieve the bean.
     * @return The bean with given id.
     */
    public T get(Long id) {

        LOGGER.info("Retrieving bean " + id);
        return ObjectifyService.ofy().load().type(classType).id(id).now();
    }

    /**
     * Saves given bean.
     * 
     * @param bean
     *            The bean to store.
     */
    public void save(T bean) {

        if (bean == null) {
            throw new IllegalArgumentException("null bean object");
        }
        LOGGER.info("Saving bean " + bean.getId());
        ObjectifyService.ofy().save().entity(bean).now();
    }

    /**
     * Deletes given bean
     * 
     * @param bean
     *            The bean to delete.
     */
    public void delete(T bean) {

        if (bean == null) {
            throw new IllegalArgumentException("null bean object");
        }
        LOGGER.info("Deleting bean " + bean.getId());
        ObjectifyService.ofy().delete().entity(bean);
    }
}
