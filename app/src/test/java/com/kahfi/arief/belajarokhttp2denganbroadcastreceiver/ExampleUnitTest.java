package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.model.Users;
import com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.abstracts.MyUsersCrud;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }



    //@Test
    public void testDeleteData()throws Exception{
       MyUsersCrud crud = new MyUsersCrud();

       String response = crud.delete("08822453123");

       Assert.assertNotNull(response);


       System.out.println(response);

    }

    //@Test
    public void loadJsonFromPHP()throws Exception{
        MyUsersCrud crud = new MyUsersCrud();

        for(Users u : crud.getAll()){
            System.out.println(u);
        }

    }

}