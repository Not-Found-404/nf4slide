package cn.org.nf404.slide.server.component.sequence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author dx DingXing
 * @since 2020-10-22
 */
@Data
@Entity
@Table(name = "shard_sequence")
public class SharedSequenceDO implements Serializable {
    private static final long serialVersionUID = -596345520485088184L;

    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "value", nullable = false)
    private Long value;

    @Column(name = "update_at", nullable = false)
    private Date updatedAt;
}
