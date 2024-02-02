package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageProcessing {
    Map<String,String> map = new HashMap<>();
    {
        map.put("как,почему,подскажите,зачем","попробуй почитать документация на javadoc - " +
                "https://docs.oracle.com/en/java/javase/17/docs/api/index.html");

        map.put("привет,hello,приветы,прив","и тебе привет");
        // map.put("","");


    }
    public String processing(String text) {
        text = text.toLowerCase();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] split = entry.getKey().split(",");
            for (String s : split) {
                if (text.contains(s)){
                    return entry.getValue();
                }
            }


        }
            return null;
    }

}
