package com.xiaohe.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductVo;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.bean.Shoppingcar;
import com.xiaohe.bean.ShoppingcarCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;

@Transactional
public interface ProductService {
	/**
	 * 查询出热门商品（根据购买次数排序）
	 * @param productCustom 查询条件
	 * @return
	 */
	List<ProductCustom> queryPopularProductByCondition(ProductCustom productCustom);
	
	/**
	 * 查询商品类型
	 * @param producttypes 条件
	 * @return 集合
	 */
	List<ProducttypeCustom> queryProductTypeByCondition(ProducttypeCustom producttype);
	
	/**
	 * 查询推荐商品  商城主页
	 * @param total 几条商品数据
	 * @return 商品集合
	 */
	List<ProductCustom> queryProductrecommend(Integer total);
	
	/**
	 * 查询优惠商品 商城主页 
	 * @param total 几条商品数据
	 * @return 商品集合
	 */
	List<ProductCustom> queryDiscountProduct(Integer total);
	
	/**
	 * 商品模糊查询 名字 描述字段
	 * @param condition
	 * @return
	 */
	List<ProductCustom> queryProductByBlurry(String condition);
	
	 /**
     * 根据商品分类进行查询，可分页，模糊，根据购买次数，好评，价格排序
     * @param condition
     * @return 商品集合
     */
	List<ProductCustom> queryProductByCondition(ProductCustom condition);
	
	/**
	 * 查询产品总数
	 * @param condition
	 * @return
	 */
	Integer queryProductSumByCondition(ProductCustom condition);
	
	/**
	 * 查询商品详细信息
	 * @param id
	 * @return
	 */
	ProductCustom queryProductInfoById(Integer id);
	
	
	/**
	 * 查询商品评价
	 * @param condition
	 * @return 评价集合
	 */
	List<EvaluationCustom> queryEvaluationByProductId(EvaluationCustom condition);
	
	/**
	 * 查询评价等级并且计算出好评度以及好评，中评，差评的个数
	 * @param id
	 * @return
	 */
	EvaluationCustom queryEvaluationLevalByProductId(Integer id);
	
	/**
	 * 查询商品评价的总页数
	 * @param id
	 * @return
	 */
	Integer queryEvaluationSum(Integer id); 
	
	/**
	 * 根据产品id查询出同类的产品 商品详情
	 * @param productid
	 * @return
	 */
	List<ProductCustom> querySimilarProductsByProductId(ProductCustom condition);
	
	/**
	 * 查询产品根据类型id
	 * @param typeid
	 * @return
	 */
	List<ProductCustom> queryProductByTypeId(ProductCustom condition);
	
	/**
	 * 查询所有分类的一部分产品ProducttypeCustom:产品类型id，List<ProductCustom>产品集合
	 * @param ProductCustom condition每一个分类查询多少条数据里面的begin和total 一般begin为0
	 * @return map集合
	 */
	Map<ProducttypeCustom, List<ProductCustom>> queryProductByAllType(ProductCustom condition);
	
	/**
	 * 查询所有商品的信息（管理员）
	 * @param condition
	 * @return
	 */
	public ProductVo queryAllProductByCondition(ProductCustom condition);
	
	/**
	 *  缺货查询
	 * @return 缺货的信息
	 */
	List<ProductCustom> quertyStockout();


	/**
	 * 	分店非推荐商品查询 
	 * @param branchid
	 * @return 分店非推荐商品
	 */
	List<ProductCustom> quertyNoBranchRecommendProduct(Integer branchid);


	
	/**
	 * 查询商品的所有信息（管理员）
	 * @return
	 */
	public ProductCustom queryProductInfoByProductid(Integer productid);
	
	/**
	 * 加载修改商品的数据
	 * @param condition
	 * @return
	 */
	public ProductVo updateProductView(Integer productid);
	
	/**
	 * 修改商品数据
	 * @param productInfo
	 * @return
	 */
	public boolean updateProduct(ProductCustom productInfo,MultipartFile pictureUpload);
	
	/**
	 * 添加商品
	 * @param info
	 * @param pictureUpload
	 * @return
	 */
	public boolean addProduct(ProductCustom productInfo,MultipartFile pictureUpload);
	
	/**
	 * 添加到购物车
	 * @param addShopCartVo
	 * @return
	 */
	public boolean addShopCart(Shoppingcar shoppingcar);
	
	/**
	 * 查询购物车根据用户id
	 * @param userid
	 * @return
	 */
	public List<ShoppingcarCustom> queryAllShopCart(Integer userid);
	
	/**
	 * 删除一条数据
	 * @param id
	 * @return
	 */
	public boolean deleteShoppingcarById(Integer id);
	
	/**
	 * 添加订单
	 * @param ordersInfo
	 * @return
	 */
	public String[] addOrders(Map<UserCustom, ShoppingcarCustom[]> shoppingcar);
	
	/**
	 * 根据用户和订单id查询订单
	 * @param Orders
	 * @return
	 */
	public List<OrdersCustom> queryAllOrdersByOrdersId(Map<User, String[]> orders);
	
	/**
	 * 更新订单
	 * @param info 用户id 更新信息
	 * @return
	 */
	public boolean updateOrderById(OrdersCustom info);
	
	/**
	 * 跟新订单(产品数量)
	 * @param orderInfo 订单id 产品数量
	 * @return
	 */
	public boolean updateOrderNumberById(OrdersCustom orderInfo);
	
	/**
	 * 删除某一个订单
	 * @param oid
	 * @return
	 */
	public boolean deleteOrderByOid(String oid);
	
	/**
	 * 查询商品的颜色或者口味
	 * @param Pid
	 * @return
	 */
	public ProductCustom queryColourOrTasteByProductid(Integer pid);
	
}