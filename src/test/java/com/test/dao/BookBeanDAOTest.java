/**
 * 
 */
package com.test.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.test.data.BookBean;

/**
 * Sample JUnit Test with Mockito
 * 
 * @author emondelo
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookBeanDAOTest {

    static {
        ObjectifyService.register(BookBean.class);
    }

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    @Mock
    private BookBean bookBean;

    private BookBeanDAO bookBeanDAO;

    @Before
    public void setup() {

        helper.setUp();
        bookBeanDAO = new BookBeanDAO();
    }

    @Test
    public void test1() {

        // TODO
        assert (true);
    }

    @After
    public void tearDown() {

        helper.tearDown();
    }
}
