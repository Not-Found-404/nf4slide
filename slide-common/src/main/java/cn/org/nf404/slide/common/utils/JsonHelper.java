package cn.org.nf404.slide.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author dx DingXing
 * @date 2020-01-01
 */
@Slf4j
@SuppressWarnings("unused")
public class JsonHelper {
    private static JsonHelper INSTANCE;
    private final ObjectMapper mapper;
    private final TypeReference MAP_TYPE = new TypeReference<Map<String, Object>>() {
    };

    private JsonHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    private static JsonHelper getInstance() {
        if (null == INSTANCE) {
            ObjectMapper mapper = new ObjectMapper();
            // 设置mapper策略
            mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            INSTANCE = new JsonHelper(mapper);
        }
        return INSTANCE;
    }

    private Map<String, Object> innerToMap(Object o) {
        try {
            if (null == o) {
                return null;
            }
            String json = this.mapper.writeValueAsString(o);
            return this.mapper.readValue(json, MAP_TYPE);
        } catch (Exception e) {
            log.error("failed to converter object to map, object:{},cause:{}", e, Throwables.getStackTraceAsString(e));
            return Maps.newHashMap();
        }
    }

    private String innerToJson(Object o) {
        try {
            if (null == o) {
                return null;
            }
            return this.mapper.writeValueAsString(o);
        } catch (Exception e) {
            log.error("failed to converter object to json, object:{},cause:{}", e, Throwables.getStackTraceAsString(e));
            return null;
        }
    }

    @SuppressWarnings("Duplicates")
    private <T> T innerToObject(String json, Class<T> clazz) {
        try {
            if (null == json || json.isEmpty()) {
                return null;
            }
            return this.mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("failed to converter json to object, json:{},cause:{}", e, Throwables.getStackTraceAsString(e));
            return null;
        }
    }

    @SuppressWarnings("Duplicates")
    private <T> T innerToObject(String json, TypeReference<T> clazz) {
        try {
            if (null == json || json.isEmpty()) {
                return null;
            }
            return this.mapper.readValue(json, clazz);
        } catch (Exception e) {
            log.error("failed to converter json to object, json:{},cause:{}", e, Throwables.getStackTraceAsString(e));
            return null;
        }
    }


    /**
     * object to map
     *
     * @param o Object
     * @return Map<String, Object>
     */
    public static Map<String, Object> toMap(Object o) {
        return getInstance().innerToMap(o);
    }

    /**
     * json string to object
     *
     * @param json  json string
     * @param clazz class
     * @param <T>   class
     * @return instance of class
     */
    public static <T> T toObject(String json, Class<T> clazz) {
        return getInstance().innerToObject(json, clazz);
    }

    /**
     * json string to object
     *
     * @param json           json string
     * @param tTypeReference class
     * @param <T>            class
     * @return instance of class
     */
    public static <T> T toObject(String json, TypeReference<T> tTypeReference) {
        return getInstance().innerToObject(json, tTypeReference);
    }


    /**
     * object to json
     *
     * @param o Object
     * @return json string
     */
    public static String toJson(Object o) {
        return getInstance().innerToJson(o);
    }
}
