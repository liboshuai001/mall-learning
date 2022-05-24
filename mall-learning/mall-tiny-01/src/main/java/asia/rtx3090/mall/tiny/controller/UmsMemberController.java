package asia.rtx3090.mall.tiny.controller;

import asia.rtx3090.mall.tiny.common.api.CommonResult;
import asia.rtx3090.mall.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/24 19:21
 * @Description: 会员登录注册管理Controller
 */
@Api(tags = "会员登录注册管理")
@RestController
@RequestMapping(value = "/UmsMember")
public class UmsMemberController {

    private UmsMemberService umsMemberService;

    @Autowired
    public UmsMemberController(UmsMemberService umsMemberService) {
        this.umsMemberService = umsMemberService;
    }

    public UmsMemberController() {
    }

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @RequestMapping(value = "/generateAuthCode", method = RequestMethod.GET)
    public CommonResult generateAuthCode(@RequestParam String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "判断验证码是否正确", httpMethod = "POST")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    public CommonResult verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }

}
