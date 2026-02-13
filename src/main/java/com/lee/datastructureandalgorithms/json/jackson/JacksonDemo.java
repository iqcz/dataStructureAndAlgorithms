package com.lee.datastructureandalgorithms.json.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDemo {

    public static void main(String[] args) throws JsonProcessingException {
        String str = "{\"id\":1,\"name\":\"haha\",\"elements\":[{\"age\":1,\"elName\":\"zll\"},{\"age\":2,\"elName\":\"zll1\"}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(str);
        //获取name字段值
        JsonNode name = jsonNode.get("name");
        String s = name.asText();
        System.out.println(s);
        //获取elements字段下数组第二个对象的age
        JsonNode elements = jsonNode.get("elements");
        JsonNode object2 = elements.get(1);//从0开始哦
        JsonNode age = object2.get("age");
        int i = age.asInt();
        System.out.println(i);

    }
}
