package com.bf.wutan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2022-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("appType")
public class AppType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String typename;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String description;

    private String avatar;


}
