package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProducttypeCustom;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    
    /**
     * 商品查询(包括商品名字模糊查询，也可以分页) 按照购买次数排序
     * @param custom 条件
     * @return
     */
    List<ProductCustom> selectPopularProductByCondition(ProductCustom custom);
    
    
    /**
     * 查询分店的全部商品数量
     * @param id
     * @return
     */
    int branchCountProducts(Integer id);
    
    /**
     * 查询分店的热销商品
     * @return
     */
    List<ProductCustom> branchHotProduct(Integer id);
    
    /**
     * 模糊查询,查询字段：名字，描述
     * @param condition
     * @return
     */
    List<ProductCustom> selectProductByBlurryCondition(String condition);
    
    
    //查询分店所有商品
    List<ProductCustom> quertyAllProduct(Integer branchid);
    
    //分店管理员查询
    EmployeeCustom selectAdminCustom(Integer employeeid);
    
    /**
     * 根据商品分类进行查询，可分页，模糊，根据购买次数，好评，价格排序
     * @param condition
     * @return 商品集合
     */
    List<ProductCustom> selectProductByCondition(ProductCustom condition);
    
    /**
     * 查询总数
     * @param condition
     * @return 总数
     */
    Integer selectProductSumByCondition(ProductCustom condition);
    
    /**
     * 查询商品详细信息，包括颜色，大小
     * @param id 产品id
     * @return
     */
    ProductCustom selectProductColourById(Integer id);
    
    /**
     * 查询商品详细信息，口味
     * @param id 产品id
     * @return
     */
    ProductCustom selectProductTasteById(Integer id);
    
    /**
     * 查询父类类型
     * @param id
     * @return
     */
    ProducttypeCustom selectProductFathertypeById(Integer id);
    
    /**
     * 根据产品类型id查询商品
     * @param id
     * @return
     */
    List<ProductCustom> selectProductByProducttypeId(ProductCustom condition);
    
    /**
     * 根据商品id和管理员id查询商品的总销售情况(分店)
     * @param productCustom
     * @return
     */
    public ProductCustom countBranchProduct(ProductCustom productCustom);
    
    
}