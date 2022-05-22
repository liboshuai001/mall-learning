package asia.rtx3090.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/22 16:42
 * @Description: MyBatis配置类
 */
@Configuration
@MapperScan("asia.rtx3090.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
