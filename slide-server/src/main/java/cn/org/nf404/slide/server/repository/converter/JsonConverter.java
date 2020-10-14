package cn.org.nf404.slide.server.repository.converter;

import cn.org.nf404.slide.common.utils.JsonHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Component
@SuppressWarnings({"unused", "WeakerAccess"})
public class JsonConverter {
    private static final TypeReference<Map<String, Object>> STRING_OBJECT_MAP = new TypeReference<Map<String, Object>>() {
    };

    public Map<String, Object> toMap(String json) {
        Map<String, Object> map = JsonHelper.toObject(json, STRING_OBJECT_MAP);
        return map != null ? map : Maps.newHashMap();
    }

    public String toJson(Map<String, Object> map) {
        return JsonHelper.toJson(map);
    }

    public String setToString(Set<String> sets) {
        if (null == sets || sets.isEmpty()) {
            return null;
        } else {
            return Joiner.on("#").join(sets);
        }
    }

    public Set<String> stringToSet(String str) {
        if (null == str || str.isEmpty()) {
            return Sets.newHashSet();
        } else {
            return Sets.newHashSet(str.split("#"));
        }
    }
}
