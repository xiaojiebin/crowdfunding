package top.xiao.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 肖
 * @version 1.0
 * @Package priv.xiao.entity
 * @data 2019/9/29 19:24
 */
@Data
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordSalt;
}
