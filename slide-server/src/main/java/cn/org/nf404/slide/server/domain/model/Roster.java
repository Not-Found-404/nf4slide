package cn.org.nf404.slide.server.domain.model;

import cn.org.nf404.slide.common.model.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 花名册
 *
 * @author dx DingXing
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Roster extends BaseModel {
    private static final long serialVersionUID = -5785407784941988691L;

    private RosterGroup group;

    /**
     * 姓名
     */
    private String name;

    /**
     * 编号
     */
    private String rosterNo;
}
