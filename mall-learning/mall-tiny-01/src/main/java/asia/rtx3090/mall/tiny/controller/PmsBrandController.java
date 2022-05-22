package asia.rtx3090.mall.tiny.controller;

import asia.rtx3090.mall.tiny.common.api.CommonResult;
import asia.rtx3090.mall.tiny.model.PmsBrand;
import asia.rtx3090.mall.tiny.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/22 16:46
 * @Description: 品牌管理Controller
 */
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {

    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    public PmsBrandController(PmsBrandService pmsBrandService) {
        this.pmsBrandService = pmsBrandService;
    }

    /**
     * 查询全部的产品数据
     *
     * @return 全部的产品数据
     */
    @RequestMapping(value = "/listAllBrand", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> listAllBrand() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @RequestMapping(value = "/createBrand", method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand Success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("创建产品失败");
            LOGGER.debug("createBrand Failed:{}", pmsBrand);
        }
        return commonResult;
    }
}
