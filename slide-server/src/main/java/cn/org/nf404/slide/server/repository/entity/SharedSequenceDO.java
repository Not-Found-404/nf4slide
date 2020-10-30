package cn.org.nf404.slide.server.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class SharedSequenceDO implements Serializable {
    private static final long serialVersionUID = -596345520485088184L;

    @Id
    @Column(name = "name", nullable = false,columnDefinition = "varchar(32) not null")
    private String name;

    @Column(name = "value", nullable = false)
    private Long value;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
