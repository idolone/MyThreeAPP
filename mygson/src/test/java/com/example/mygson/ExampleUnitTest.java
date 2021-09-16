package com.example.mygson;

import com.google.gson.Gson;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testObject(){
        User u1 = new User("idol","123",18,true);

        Gson gson = new Gson();
        //序列化
        String json = gson.toJson(u1);
        System.out.println("序列化:"+ json);

        //反序列化
        User u2 = gson.fromJson(json,User.class);
        System.out.println("反序列化"+ u2.getUserName() +"----"+u2.getPassword());
    }

    @Test  public void testObject1(){
        User u1 = new User("idol","123",18,true);
        Job job = new Job("gong","xin");
        u1.setJob(job);

        Gson gson = new Gson();
        //序列化
        String json = gson.toJson(u1);
        System.out.println("序列化:"+ json);

        //反序列化
        User u2;
        u2 = gson.fromJson(json,User.class);
        System.out.printf("反序列化:%s%s%n", u2.getUserName(), u2.getJob());
    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}