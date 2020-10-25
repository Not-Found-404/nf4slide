package cn.org.nf404.slide.api.response.roster;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Data
public class RosterInfo implements Serializable {
    private static final long serialVersionUID = -8213244865542305866L;

    /**
     * 组信息
     */
    private RosterGroupInfo group;

    /**
     * 姓名
     */
    private String name;

    /**
     * 编号
     */
    private String rosterNo;
}
