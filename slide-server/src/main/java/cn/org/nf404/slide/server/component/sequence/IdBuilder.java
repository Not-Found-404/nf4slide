package cn.org.nf404.slide.server.component.sequence;

import com.google.common.base.CaseFormat;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dx DingXing
 * @since 2020-10-23
 */
@Component
@AllArgsConstructor
public class IdBuilder {
    private Map<String, SequenceRange> nameToRange = new ConcurrentHashMap<>();
    private SharedSequenceRepository repository;

    public Long nextId(Class clazz, Long routeValue) {
        String name = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, clazz.getSimpleName());
        long value = this.nextValue(name);
        String route = Strings.padStart(String.valueOf(Optional.ofNullable(routeValue).orElse(0L) % 1000), 3, '0');
        return Long.parseLong(value + route);
    }

    private long nextValue(String name) {
        SequenceRange sequenceRange = nameToRange.computeIfAbsent(name, this.repository::nextRange);


        return sequenceRange.getAndIncrement();
    }


}
