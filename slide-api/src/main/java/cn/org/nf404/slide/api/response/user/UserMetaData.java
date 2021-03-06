package cn.org.nf404.slide.api.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author DingXing wildhunt_geralt@foxmail.com
 * @since 2019/5/4
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMetaData implements Serializable {
    private static final long serialVersionUID = -8446995074613168705L;
    private Long userId;

    private Integer level;
}
