package cn.org.nf404.slide.api.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dx DingXing
 * @since 2020-09-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginInfo implements Serializable {
    private static final long serialVersionUID = -1247352396749896013L;

    private Boolean matched;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * uuid
     */
    private String uuid;
}
