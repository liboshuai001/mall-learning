package asia.rtx3090.mall.tiny.service;

import asia.rtx3090.mall.tiny.common.api.CommonResult;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/24 19:33
 * @Description: 会员管理Service
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     *
     * @param telephone 电话号码
     * @return 生成的验证码消息
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     *
     * @param telephone  电话号码
     * @param authCode 验证码
     * @return 匹配结果
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
