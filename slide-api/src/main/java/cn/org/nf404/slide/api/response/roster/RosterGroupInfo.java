package cn.org.nf404.slide.api.response.roster;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-10-25
 */
@Data
public class RosterGroupInfo implements Serializable {
    private static final long serialVersionUID = -419888489616610528L;


    /**
     * 所属组id
     */
    private String groupId;

    /**
     * 所属组名字
     */
    private String groupName;
}
