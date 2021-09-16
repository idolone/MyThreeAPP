package com.example.mygson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayTest {

    @Test
    public void TestArray(){

        User[] users1 = new User[3];

        users1[0] = new User("kin","123",18,true);
        users1[1] = new User("ido","345",19,true);

        Gson gson = new Gson();

        String json = gson.toJson(users1);
        System.out.println("序列化"+json);

        User[] users2 = gson.fromJson(json,User[].class);
        System.out.println("反序列化0: "+ users2[0].getUserName());
        System.out.println("反序列化1: "+ users2[1].getUserName());
//        System.out.println("反序列化0"+ users2[0]);
//        System.out.println("反序列化1"+users2[1]);
//        System.out.println("反序列化2"+users2[2]);
    }

    @Test
    public void TestList(){
        List<User> list1 = new ArrayList<>();

        list1.add(new User("kin","123",18,true));
        list1.add(new User("ido","345",18,true));
        list1.add(new User("kk","456",18,true));

        Gson gson = new Gson();
        //序列化
        String json = gson.toJson(list1);

        System.out.println("序列化: "+json);

        //反序列化
        Type type = new TypeToken<List<User>>(){}.getType();
        List<User>  list2 = gson.fromJson(json,type);
       // List<User>  list2 = gson.fromJson(json,List.class); //这种写法是不行的，无法知道泛型User
        System.out.println("反序列化0: "+ list2.get(0).getUserName());
        System.out.println("反序列化1: "+ list2.get(1).getUserName());
        System.out.println("反序列化2: "+ list2.get(2).getUserName());

        System.out.println("反序列化0: "+ list2.get(0));
        System.out.println("反序列化1: "+ list2.get(1));
        System.out.println("反序列化2: "+ list2.get(2));

    }
    @Test
    public void TestMap(){

        Map<String,User> map1 = new HashMap<>();

        map1.put("1",new User("kin","123",18,true));
        map1.put("2",new User("kin","123",18,true));
        map1.put("3",null);
        map1.put(null,null);

        Gson gson = new Gson();
        String json = gson.toJson(map1);

        System.out.println("序列化: "+json);

        Type type = new TypeToken<Map<String,User>>(){}.getType();

        Map<String,User> map2 = gson.fromJson(json,type);

        System.out.println("反序列化0: "+ map2.get("1").getUserName());
        System.out.println("反序列化1: "+ map2.get("2").getUserName());

        System.out.println("反序列化0: "+ map2.get(null));
        System.out.println("反序列化1: "+ map2.get("1"));
        System.out.println("反序列化2: "+ map2.get("2"));

    }

}
