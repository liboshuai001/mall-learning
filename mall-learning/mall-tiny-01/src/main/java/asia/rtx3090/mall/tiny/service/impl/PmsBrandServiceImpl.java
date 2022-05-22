package asia.rtx3090.mall.tiny.service.impl;

import asia.rtx3090.mall.tiny.mapper.PmsBrandMapper;
import asia.rtx3090.mall.tiny.model.PmsBrand;
import asia.rtx3090.mall.tiny.model.PmsBrandExample;
import asia.rtx3090.mall.tiny.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/23 05:05
 * @Description:
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {

    private PmsBrandMapper pmsBrandMapper;

    @Autowired
    public PmsBrandServiceImpl(PmsBrandMapper pmsBrandMapper) {
        this.pmsBrandMapper = pmsBrandMapper;
    }

    /**
     * 查询全部产品数据
     *
     * @return
     */
    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    /**
     * 插入产品数据
     *
     * @param pmsBrand 产品数据
     * @return 插入成功的行数
     */
    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    /**
     * 更新指定id的产品数据
     *
     * @param id       产品id
     * @param pmsBrand 产品数据
     * @return 更新成功的行数
     */
    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    /**
     * 删除指定id的产品数据
     *
     * @param id 产品id
     * @return 删除成功的行数
     */
    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页查询产品数据
     *
     * @param pageNum  起始页码
     * @param pageSize 数据数量
     * @return 分页查询得到的产品数据
     */
    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    /**
     * 根据产品id查询产品数据
     *
     * @param id 产品id
     * @return 查询得到的产品数据
     */
    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
