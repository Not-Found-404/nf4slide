package cn.org.nf404.slide.server.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@Data
public class AddressTable implements Serializable {
    private static final long serialVersionUID = -1141927642726927638L;

    private Long id;

    private Long pid;

    private String name;

    private Integer level;

    private String pinyin;

    private String englishName;

    private String unicodeCode;

    private Integer orderNo;

    @JsonIgnore
    private List<AddressTable> child;
}
