package cn.org.nf404.slide.common.model.request;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 基础分页model
 *
 * @author dx DingXing
 * @date 2020-01-01
 */
@Data
@SuppressWarnings({"unused", "unchecked"})
public class Paging<T> implements Serializable {
    private static final long serialVersionUID = -7236584153535008879L;

    private Integer total;
    private List<T> data;

    public Paging(Integer total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public static Paging empty() {
        return new Paging(0, Lists.newArrayListWithCapacity(0));
    }
}