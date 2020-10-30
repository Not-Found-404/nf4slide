package cn.org.nf404.slide.server.component.sequence;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author dx DingXing
 * @since 2020-10-22
 */
@SuppressWarnings("WeakerAccess")
public class SequenceRange {
    private final long max;
    private final AtomicLong value;

    public SequenceRange(long min, long max) {
        this.max = max;
        this.value = new AtomicLong(min);
    }

    public long getAndIncrement() {
        long current = this.value.getAndIncrement();
        if (current > this.max) {
            return -1L;
        }
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SequenceRange that = (SequenceRange) o;
        return max == that.max &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, value);
    }
}
