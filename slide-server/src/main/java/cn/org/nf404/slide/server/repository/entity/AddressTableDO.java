package cn.org.nf404.slide.server.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author dx DingXing
 * @date 2020-09-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "addresses",
        indexes = {@Index(name = "idx_pid", columnList = "pid")}
)
public class AddressTableDO extends BaseDO{
    private static final long serialVersionUID = -7513951088749986174L;

    @Id
    @Column(name = "id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pid", nullable = false)
    private Long pid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "pinyin", nullable = false)
    private String pinyin;

    @Column(name = "english_name", nullable = false)
    private String englishName;

    @Column(name = "unicode_code", nullable = false)
    private String unicodeCode;

    @Column(name = "order_no", nullable = false)
    private Integer orderNo;
}
