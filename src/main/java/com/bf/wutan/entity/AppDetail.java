package com.bf.wutan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("appDetail")
public class AppDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String appname;

    private String detail;

    private String time;

    private Integer readCount;
}
