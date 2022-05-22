package asia.rtx3090.mall.tiny.service;

import asia.rtx3090.mall.tiny.model.PmsBrand;

import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/22 15:20
 * @Description:
 */
public interface PmsBrandService {
    /**
     * 查询全部产品数据
     *
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 插入产品数据
     *
     * @param pmsBrand 产品数据
     * @return 插入成功的行数
     */
    int createBrand(PmsBrand pmsBrand);

    /**
     * 更新指定id的产品数据
     *
     * @param id       产品id
     * @param pmsBrand 产品数据
     * @return 更新成功的行数
     */
    int updateBrand(Long id, PmsBrand pmsBrand);

    /**
     * 删除指定id的产品数据
     *
     * @param id 产品id
     * @return 删除成功的行数
     */
    int deleteBrand(Long id);

    /**
     * 分页查询产品数据
     *
     * @param pageNum  起始页码
     * @param pageSize 数据数量
     * @return 分页查询得到的产品数据
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 根据产品id查询产品数据
     *
     * @param id 产品id
     * @return 查询得到的产品数据
     */
    PmsBrand getBrand(Long id);
}
