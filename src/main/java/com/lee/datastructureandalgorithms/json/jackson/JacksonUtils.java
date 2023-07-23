package com.lee.datastructureandalgorithms.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;


/**
 * Description : jackson工具类
 */
public class JacksonUtils {
    @SuppressWarnings("staticVariable")
    private static final Logger LOGGER = LoggerFactory.getLogger(JacksonUtils.class);
    @SuppressWarnings("staticVariable")
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        // 设置允许序列化空的实体类（否则会抛出异常）
        OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                // 设置 把java.util.Date, Calendar输出为数字（时间戳）
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                // 强制JSON 空字符串("")转换为null对象值
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                // 设置数字丢失精度问题
                .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                // 设置没有引号的字段名
                .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
                // 设置允许单引号
                .enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES)
                // 不对值为null的字段进行序列化
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                // 设置接受只有一个元素的数组的反序列化
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                // 设置允许尾随逗号
                .enable(JsonParser.Feature.ALLOW_TRAILING_COMMA)
                // 设置输出transient字段
                .enable(MapperFeature.PROPAGATE_TRANSIENT_MARKER)
                // 允许出现特殊字符和转义符
                .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true)
                // 支持LocalDateTime 序列化
                .registerModule(new JavaTimeModule())
                // 序列化日期格式为yyyy-MM-dd HH:mm:ss
                .registerModule(new SimpleModule().addSerializer(Date.class, new DateSerializer()))
                // 设置默认排序, 排序会影响序列化性能
                .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
    }

    /**
     * 对象转字符串
     *
     * @param object
     * @return
     */
    public static String toJSONString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error(">> convert to json failed ", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转对象
     *
     * @param json
     * @return
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            LOGGER.error(">> parseObject failed ", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转对象
     *
     * @param json
     * @return
     */
    public static <T> T parseObject(String json, TypeReference<T> typeReference) {
        if (json == null) {
            return null;
        }
        ObjectReader objectReader = OBJECT_MAPPER.readerFor(typeReference);
        try {
            return objectReader.readValue(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转ObjectNode (ObjectNode类似 fastjson 的 JSONObject)
     *
     * @param json
     * @return
     */
    public static ObjectNode parseObject(String json) {
        if (json == null) {
            return null;
        }
        try {
            return (ObjectNode) OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            LOGGER.error(">> parseObject to ObjectNode  failed ", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转对象列表
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        if (json == null) {
            return null;
        }
        try {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
            return OBJECT_MAPPER.readValue(json,javaType);
        } catch (Exception e) {
            LOGGER.error(">> parseArray failed ",e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 字符串转ArrayNode ,  (ArrayNode类似 fastjson 的 JSONArray)
     * @param json
     * @return
     */
    public static ArrayNode parseArray(String json){
        if (json == null) {
            return null;
        }
        try {
            return (ArrayNode) OBJECT_MAPPER.readTree(json);
        } catch (Exception e) {
            LOGGER.error(">> parseArray to ArrayNode  failed ",e);
            throw new RuntimeException(e);
        }
    }

}
