package com.example.redistest.redis.Entity;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Data
public class UserInfo implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
}