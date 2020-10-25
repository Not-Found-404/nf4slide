package cn.org.nf404.slide.server.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Data
public class RosterGroup implements Serializable {
    private static final long serialVersionUID = 6035774763556003433L;

    /**
     * 所属组id
     */
    private String groupId;

    /**
     * 所属组名字
     */
    private String groupName;

}
