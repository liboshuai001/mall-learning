package asia.rtx3090.mall.tiny.common.api;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2022/5/22 17:44
 * @Description: 分页数据封装类
 */
public class CommonPage<T> {
    // 当前页
    private Integer pageNum;
    // 每页的数量
    private Integer pageSize;
    // 总页数
    private Integer totalPage;
    // 总记录数
    private Long total;
    // 结果集
    private List<T> list;

    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalPage(pageInfo.getPages());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    // setter and getter

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
