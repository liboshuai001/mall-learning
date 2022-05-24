package asia.rtx3090.mall.tiny.service.impl;

import asia.rtx3090.mall.tiny.common.api.CommonResult;
import asia.rtx3090.mall.tiny.service.RedisService;
import asia.rtx3090.mall.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Random;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/24 19:40
 * @Description:
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.seconds}")
    private Long REDIS_KEY_EXPIRE_SECONDS;

    @Autowired
    public UmsMemberServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    public UmsMemberServiceImpl() {
    }

    /**
     * 生成验证码
     *
     * @param telephone 电话号码
     * @return 生成的验证码
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, stringBuilder.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, REDIS_KEY_EXPIRE_SECONDS);
        return CommonResult.success("获取验证码成功", stringBuilder.toString());
    }

    /**
     * 判断验证码和手机号码是否匹配
     *
     * @param telephone 电话号码
     * @param authCode  验证码
     * @return 匹配结果
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = Objects.equals(realAuthCode, authCode);
        if (result) {
            return CommonResult.success("验证码效验成功", null);
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }
}
