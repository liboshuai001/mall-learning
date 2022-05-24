package asia.rtx3090.mall.tiny.controller;

import asia.rtx3090.mall.tiny.common.api.CommonPage;
import asia.rtx3090.mall.tiny.common.api.CommonResult;
import asia.rtx3090.mall.tiny.model.PmsBrand;
import asia.rtx3090.mall.tiny.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "商品品牌管理")
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {

    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @Autowired
    public PmsBrandController(PmsBrandService pmsBrandService) {
        this.pmsBrandService = pmsBrandService;
    }

    public PmsBrandController() {
    }

    /**
     * 查询全部的产品数据
     *
     * @return 全部的产品数据
     */
    @ApiOperation(value = "查询全部的产品数据", httpMethod = "GET")
    @RequestMapping(value = "/listAllBrand", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> listAllBrand() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    /**
     * 创建商品
     *
     * @param pmsBrand 产品数据
     * @return 创建的产品信息
     */
    @ApiOperation(value = "创建商品", httpMethod = "POST")
    @RequestMapping(value = "/createBrand", method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
        } else {
            commonResult = CommonResult.failed("创建产品失败");
        }
        return commonResult;
    }

    /**
     * 更新指定id的产品
     *
     * @param id       产品id
     * @param pmsBrand 产品数据
     * @return 更新的产品信息
     */
    @ApiOperation(value = "更新指定id的产品", httpMethod = "GET")
    @RequestMapping(value = "/updateBrandById/{id}", method = RequestMethod.GET)
    public CommonResult updateBrandById(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = pmsBrandService.updateBrandById(id, pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
        } else {
            commonResult = CommonResult.failed("更新产品失败");
        }
        return commonResult;
    }

    /**
     * 删除指定id的产品
     *
     * @param id 产品id
     * @return 删除的产品信息
     */
    @ApiOperation(value = "删除指定id的产品", httpMethod = "GET")
    @RequestMapping(value = "/deleteBrandById/{id}", method = RequestMethod.GET)
    public CommonResult deleteBrandById(@PathVariable("id") Long id) {
        CommonResult commonResult;
        int count = pmsBrandService.deleteBrandById(id);
        if (count == 1) {
            commonResult = CommonResult.success(null);
        } else {
            commonResult = CommonResult.failed("产品删除失败");
        }
        return commonResult;
    }

    /**
     * 分页查询产品
     *
     * @param pageNum 当前页
     * @param pageSiz 每页的数量
     * @return 分页查询得到的产品数据
     */
    @ApiOperation(value = "分页查询产品", httpMethod = "GET")
    @RequestMapping(value = "/pagingListBrand", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> pagingListBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                              @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSiz) {
        List<PmsBrand> pmsBrands = pmsBrandService.pagingListBrand(pageNum, pageSiz);
        return CommonResult.success(CommonPage.restPage(pmsBrands));
    }

    /**
     * 根据产品id查询产品
     *
     * @param id 产品id
     * @return 根据产品id查询到的产品数据
     */
    @ApiOperation(value = "根据产品id查询产品", httpMethod = "GET")
    @RequestMapping(value = "/getBrandById/{id}", method = RequestMethod.GET)
    public CommonResult<PmsBrand> getBrandById(@PathVariable(value = "id") Long id) {
        return CommonResult.success(pmsBrandService.getBrandById(id));
    }
}
