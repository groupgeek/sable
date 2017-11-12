package com.xiaohe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.AddShopCartVo;
import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.EvaluationVo;
import com.xiaohe.bean.IntegralCustom;
import com.xiaohe.bean.IntegraltoarticleCuntom;
import com.xiaohe.bean.IntegraltoarticleVo;
import com.xiaohe.bean.MessageCustom;
import com.xiaohe.bean.OrdersCountVo;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductVo;
import com.xiaohe.bean.ProductrecommendCustom;
import com.xiaohe.bean.ProducttransactionreportCustom;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.bean.ShippingAddVo;
import com.xiaohe.bean.ShippingAddressCustom;
import com.xiaohe.bean.Shoppingcar;
import com.xiaohe.bean.ShoppingcarCustom;
import com.xiaohe.bean.ShowMessage;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.EvaluationService;
import com.xiaohe.service.IntegralService;
import com.xiaohe.service.IntegraltoarticleService;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ProductTypeService;
import com.xiaohe.service.ProducttransactionreportService;
import com.xiaohe.service.ShippingAddressService;
import com.xiaohe.service.UserService;


@Controller
@RequestMapping("/product")
public class MallController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;
	
	@Autowired
	@Qualifier("producttransactionreportService")
	private ProducttransactionreportService producttransactionreportService;
	
	@Autowired
	@Qualifier("productTypeService")
	private ProductTypeService productTypeService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("shippingAddressService")
	private ShippingAddressService shippingAddressService;
	
	@Autowired
	@Qualifier("evaluationService")
	private EvaluationService evaluationService;
	
	@Autowired
	@Qualifier("integralService")
	private IntegralService integralService;
	
	@Autowired
	@Qualifier("integraltoarticleService")
	private IntegraltoarticleService integraltoarticleService;
	
	
	public User getUser(HttpServletRequest request){
		
		return (User) request.getSession().getAttribute("user");
	}
	
	/**
	 * 商城主页
	 * @param model
	 * @return
	 */
	@RequestMapping("mallIndex")
	public String mallIndex(Model model,HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return "redirect:/jsp/logReg/login.jsp";
		/**
		 * 变量区
		 * 产品类型 productTypes
		 * 推荐商品 productrecommends
		 * 优惠商品 productDiscountCustoms
		 * 分类的产品 allTypeProducts
		 */
		List<ProducttypeCustom> productTypes = new ArrayList<ProducttypeCustom>();
		List<ProductCustom> productrecommends = new ArrayList<ProductCustom>();
		List<ProductCustom> productDiscounts = new ArrayList<ProductCustom>();
		Map<ProducttypeCustom, List<ProductCustom>> allTypeProducts = new HashMap<ProducttypeCustom, List<ProductCustom>>();
		
		
		//查询所有商品类型
		productTypes = productTypeService.querySimallProducttype();
		
		//查询推荐商品
		productrecommends = productService.queryProductrecommend(user.getUserid());
		
		//查询优惠商品
		productDiscounts = productService.queryDiscountProduct(user.getUserid());
		
		//开始查询所有分类的产品
		ProductCustom condition = new ProductCustom();
		condition.setBegin(0);
		condition.setTotal(7);
		condition.setUserid(user.getUserid());
		allTypeProducts = productService.queryProductByAllType(condition);
		
		
		model.addAttribute("productTypes", productTypes);
		model.addAttribute("productrecommends", productrecommends);
		model.addAttribute("productDiscounts", productDiscounts);
		model.addAttribute("allTypeProducts", allTypeProducts);
		return "mall/home/home";
	}
	
	
	/**
	 * 搜索框
	 * @param model
	 * @param searchCondition
	 * @return
	 */
	@RequestMapping("/search")
	public String search(Model model,String searchCondition){
		
		/**
		 * 变量
		 * 模糊查询商品 blurryProductCustoms
		 * 产品类型 producttypeCustoms
		 * 当前页 currentPage
		 */
		List<ProductCustom> blurryProductCustoms = new ArrayList<ProductCustom>();
		List<ProducttypeCustom> producttypeCustoms = new ArrayList<ProducttypeCustom>();
		Integer currentPage = 1;
		
		
		//开始模糊查询
		ProductCustom condition = new ProductCustom();
		condition.setSearch(searchCondition);
		condition.setTotal(1);
		condition.setCurrentPage(currentPage);
		int tempSum = productService.queryProductSumByCondition(condition);
		int sum = tempSum / condition.getTotal();
		
		if(tempSum % condition.getTotal() != 0){
			sum += 1;
		}
		blurryProductCustoms = productService.queryProductByCondition(condition);
		
		
		
		//开始查询商品类型
		ProducttypeCustom producttype = new ProducttypeCustom();
		producttype.setFatherid(0);
		producttypeCustoms = productService.queryProductTypeByCondition(producttype);
		
		
		
		model.addAttribute("blurryProductCustoms", blurryProductCustoms);
		//传递模糊查询参数
		model.addAttribute("searchCondition", searchCondition);
		model.addAttribute("producttypeCustoms", producttypeCustoms);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("sum", sum);
		return "mall/home/search";
	}
	
	/**
	 * 局部更新商品类型
	 * @param producttype json数据
	 * @param request
	 * @return  List<ProducttypeCustom> json数据
	 */
	@RequestMapping("/queryProducttype_json.action")
	public @ResponseBody List<ProducttypeCustom> queryProducttype_json(@RequestBody ProducttypeCustom producttype,
			HttpServletRequest request){
		return producttypeMapper.selectProductTypeByFatherId(producttype);
	}
	
	/**
	 * 更新商品
	 * @param condition
	 * @return json数据 
	 */
	@RequestMapping("/queryProduct_json")
	public @ResponseBody List<ProductCustom> queryProduct_json(@RequestBody ProductCustom condition){
		condition.setTotal(1);
		List<ProductCustom> products = productService.queryProductByCondition(condition);
		return products;
	}
	
	/**
	 * 返回总页数
	 * @param condition
	 * @return
	 */
	@RequestMapping("/queryProductSum_json")
	public @ResponseBody int  queryProductSum(@RequestBody ProductCustom condition){
		condition.setTotal(1);
		int tempSum = productService.queryProductSumByCondition(condition);
		int sum = tempSum / condition.getTotal();
		
		if(tempSum % condition.getTotal() != 0){
			sum += 1;
		}
		return sum;
	}
	
	/**
	 * value="/productInfo",method = RequestMethod.POST
	 * 加载商品详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/productInfo")
	public String productInfo(Model model,Integer id){
		
		/**
		 * productInfo 产品详细信息
		 * similarProducts 同类商品
		 * salesThisMonth 本月销量
		 * sales 总销量
		 */
		/**
		 * 后面更改到错误页面
		 */
		if(id == null) return "mall/home/introduction";
		
		
		ProductCustom productInfo = new ProductCustom();
		
		List<ProductCustom> similarProducts = new ArrayList<ProductCustom>();
		
		/*if(productInfo == null){
			return 商品丢失页面
		}*/
		
		/**
		 * 开始查询商品详细信息
		 */
		productInfo = productService.queryProductInfoById(id);
		
		/**
		 * 开始查询商品同类产品
		 */
		ProductCustom condition = new ProductCustom();
		condition.setProductid(id);
		condition.setBegin(0);
		condition.setTotal(4);
		similarProducts = productService.querySimilarProductsByProductId(condition);
		
		/**
		 * 开始查询本月销量
		 */
		ProducttransactionreportCustom conditionSales = new ProducttransactionreportCustom();
		Date end = new Date();
		Date start = new Date();
		start.setYear(end.getYear());
		start.setMonth(end.getMonth());
		start.setDate(1);
		start.setHours(0);
		start.setMinutes(0);
		end.setDate(31);
		end.setHours(0);
		end.setMinutes(0);
		
		conditionSales.setStartingTime(start);
		conditionSales.setEndTime(end);
		
		conditionSales.setProductid(id);
		ProducttransactionreportCustom salesThisMonth = producttransactionreportService.statisticsProductSalesByIdAndTime(conditionSales);
		
		/**
		 * 开始查询总销量
		 */
		ProducttransactionreportCustom sales = producttransactionreportService.statisticsProductSalesByProductId(id);
		
		/**
		 * 查询总评价数
		 */
		EvaluationCustom allEvaluationCustom = productService.queryEvaluationLevalByProductId(id);
		Integer allEvaluation = allEvaluationCustom.getPraise()+allEvaluationCustom.getAverage()+allEvaluationCustom.getBadReview();
		
		
		model.addAttribute("productInfo", productInfo);
		model.addAttribute("similarProducts", similarProducts);
		model.addAttribute("salesThisMonth", salesThisMonth);
		model.addAttribute("sales", sales);
		model.addAttribute("allEvaluation", allEvaluation);
		return "mall/home/introduction";
	}
	
	/**
	 * 无用
	 * @param id
	 * @return
	 */
	@RequestMapping("/clickBuyBasket")
	public @ResponseBody int sendMessage(Integer id){
		System.out.println("**************************");
		System.out.println(id);
		return id;
	}
	
	/**
	 * 查询评价
	 * @param evaluationCustom
	 * @return
	 */
	@RequestMapping("/queryEvaluation")
	public @ResponseBody EvaluationVo queryEvaluation(@RequestBody EvaluationCustom evaluationCustom){
		EvaluationVo evaluationVo = new EvaluationVo();
		evaluationVo.setEvaluationsList(productService.queryEvaluationByProductId(evaluationCustom));
		evaluationVo.setPageSum(productService.queryEvaluationSum(evaluationCustom.getProductid()));
		evaluationVo.setEvaluation(productService.queryEvaluationLevalByProductId(evaluationCustom.getProductid()));
		return evaluationVo;
	}
	
	/**
	 * 商城首页的分类导航商品展示
	 * @param producttype
	 * @return
	 */
	@RequestMapping("/quereyProduct_json")
	public @ResponseBody List<ProductCustom> quereyProductByProductTypeId_json(@RequestBody ProducttypeCustom producttype , HttpServletRequest request){
		User user = new User();
		user = getUser(request);
		if(user == null || producttype == null) return null;
		if(producttype.getProducttypeid() == null) return null;
		List<ProductCustom> pList = new ArrayList<ProductCustom>();
		ProductCustom condition = new ProductCustom();
		condition.setBegin(0);
		condition.setTotal(20);
		condition.setProducttypeid(producttype.getProducttypeid());
		condition.setUserid(user.getUserid());
		pList = productService.queryProductByTypeId(condition);
		return pList;
	}
	
	/**
	 * 添加商品到购物车
	 * @param shoppingcar
	 * @param request
	 * @return
	 */
	@RequestMapping("/addShopCart")
	public @ResponseBody ShowMessage addShopCart(@RequestBody ShoppingcarCustom shoppingcar ,HttpServletRequest request){
		User user = getUser(request);
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(user == null){
			message = "未登录";
			showMessage.setMessage(message);
			return showMessage;
		}
		
		shoppingcar.setUserid(user.getUserid());		
		if(productService.addShopCart(shoppingcar)){
			message = "添加成功";
			showMessage.setFlag(true);
		}else{
			message = "添加失败,登录失效,请重新 登录";
			showMessage.setFlag(false);
		}
		
		showMessage.setMessage(message);
		return showMessage;
	}
	
	/**
	 * 显示购物车
	 * @return
	 */
	@RequestMapping("/queryAllShopCartByUserid")
	public @ResponseBody List<ShoppingcarCustom> queryAllShopCartByUserid(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		List<ShoppingcarCustom> list = new ArrayList<ShoppingcarCustom>();
		list = productService.queryAllShopCart(user.getUserid());
		//list = productService.queryAllShopCart(12);
		return list;
	}
	
	/**
	 * 删除某一条
	 * @return
	 */
	@RequestMapping("/deleteShop")
	public @ResponseBody ShowMessage deleteShop(HttpServletRequest request,@RequestBody Integer shoppingcarid){
		ShowMessage message = new ShowMessage();
		if(productService.deleteShoppingcarById(shoppingcarid)){
			message.setMessage("删除成功");
			message.setFlag(true);
		}else{
			message.setMessage("删除失败");
			message.setFlag(false);
		}
		
		return message;
	}
	
	/**
	 * 查看商品颜色或者口味
	 * @return
	 */
	@RequestMapping("/queryColourOrTaste")
	public @ResponseBody ProductCustom queryColourOrTaste(@RequestBody Integer productid){
		
		if(productid == null) return null;
		ProductCustom data = new ProductCustom();
		data = productService.queryColourOrTasteByProductid(productid);
		
		return data;
	}
	
	/**
	 * 查看商品颜色或者口味
	 * @return
	 */
	@RequestMapping("/updateColourOrTaste")
	public @ResponseBody ShowMessage updateColourOrTaste(@RequestBody ShoppingcarCustom info){
		ShowMessage message = new ShowMessage();
		if(info == null) return null;
		
		if(productService.updateColourOrTasteByShopcarid(info)){
			message.setMessage("ok");
		}
		
		return message;
	}
	
	
	/**
	 * 立即购买
	 * @return
	 */
	@RequestMapping("/buyNow")
	public @ResponseBody String buyNow(@RequestBody ProductCustom info,HttpServletRequest request){
		User user = getUser(request);
		if(info == null || user == null) return null;
		if(user.getUserid() == null || info.getProductid() == null) return null;
		info.setUserid(user.getUserid());
		String orderId = productService.buyNow(info);
		
		return orderId;
	}
	
	
	
	
	
	
	
	/**
	 * 添加订单
	 * @return
	 */
	@RequestMapping("/addOrders")
	public @ResponseBody String[] addOrders(@RequestBody ShoppingcarCustom payArr[],HttpServletRequest request){
		User user = getUser(request);
		
		Map<UserCustom, ShoppingcarCustom[]> data = new HashMap<UserCustom, ShoppingcarCustom[]>();
		data.put((UserCustom) user, payArr);
		String[] ordersId = productService.addOrders(data);
		
		return ordersId;
	}
	
	/**
	 * 显示订单
	 * @return
	 */
	@RequestMapping("/showOrders")
	public @ResponseBody List<OrdersCustom> showOrders(@RequestBody String ordersArr[],HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		Map<User, String[]> data = new HashMap<User, String[]>();
		List<OrdersCustom> all = new ArrayList<OrdersCustom>();
		
		data.put(user, ordersArr);
		
		all = productService.queryAllOrdersByOrdersId(data);
		
		return all;
	}
	
	/**
	 * 更新订单(地址，电话 ，名字)
	 * @return
	 */
	@RequestMapping("/updateUserOrderInfo")
	public @ResponseBody ShowMessage updateUserOrderInfo(@RequestBody OrdersCustom info,HttpServletRequest request){
		User user = getUser(request);
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(user == null){
			message = "未登录";
			showMessage.setFlag(false);
			showMessage.setMessage(message);
			return showMessage;
		}
		
		info.setUserid(user.getUserid());
		if(productService.updateOrderById(info)){
			message = "更新成功";
			showMessage.setFlag(true);
		}else{
			message = "更新失败,登录失效,请重新 登录";
			showMessage.setFlag(false);
		}
		
		showMessage.setMessage(message);
		return showMessage;
	}
	
	
	/**
	 * 更新订单(产品数量)
	 * @return
	 */
	@RequestMapping("/updateUserOrderNumber")
	public @ResponseBody ShowMessage updateUserOrderNumber(@RequestBody OrdersCustom orderInfo,HttpServletRequest request){
		User user = getUser(request);
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(user == null){
			message = "未登录";
			showMessage.setFlag(false);
			showMessage.setMessage(message);
			return showMessage;
		}
		
		if(productService.updateOrderNumberById(orderInfo)){
			message = "更新成功";
			showMessage.setFlag(true);
		}else{
			message = "更新失败,登录失效,请重新 登录";
			showMessage.setFlag(false);
		}
		
		showMessage.setMessage(message);
		return showMessage;
	}
	
	/**
	 * 删除订单
	 * @return
	 */
	@RequestMapping("/deleteOrder")
	public @ResponseBody ShowMessage deleteOrder(@RequestBody String oid,HttpServletRequest request){
		
		User user = getUser(request);
		ShowMessage showMessage = new ShowMessage();
		String message = null;
		if(user == null){
			message = "未登录";
			showMessage.setFlag(false);
			showMessage.setMessage(message);
			return showMessage;
		}
		
		if(productService.deleteOrderByOid(oid)){
			message = "删除成功";
			showMessage.setFlag(true);
		}else{
			message = "删除失败,登录失效,请重新 登录";
			showMessage.setFlag(false);
		}
		
		showMessage.setMessage(message);
		return showMessage;
	}
	
	/**
	 * 获取到当前登录的用户详细信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/getLoginUser")
	public @ResponseBody UserCustom getLoginUser(HttpServletRequest request){
		UserCustom user = (UserCustom) getUser(request);
		if(user == null) return null;
		user = userService.queryUserInfoById(user.getUserid());
		
		return user;
	}
	
	/**
	 * 更新当前登录的用户详细信息
	 * @param 
	 * @return
	 */
	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(UserCustom userInfo,MultipartFile pictureUpload){
		if(userService.UpdateUserInfoByUser(userInfo, pictureUpload)){
		}
		return "redirect:/jsp/mall/person/information.jsp";
	}
	
	/**
	 * 查询当前用户的收货地址
	 * @param 
	 * @return
	 */
	@RequestMapping("/queryAllAddressByUserid")
	public @ResponseBody ShippingAddVo queryAllAddressByUserid(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		if(user.getUserid() == null) return null;
		ShippingAddVo vo = new ShippingAddVo();
		vo = userService.queryAllAddressByUserid(user.getUserid());
		return vo;
	}
	
	/**
	 * 删除当前用户的收货地址
	 * @param 
	 * @return
	 */
	@RequestMapping("/delShippingAddress")
	public @ResponseBody ShowMessage delShippingAddress(@RequestBody Integer id){
		ShowMessage message = new ShowMessage();
		if(id == null) {
			message.setFlag(false);
			return message;
		}
		
		if(shippingAddressService.deleteAddress(id)){
			message.setFlag(true);
		}
		
		return message;
	}
	
	/**
	 * 修改当前用户的默认地址
	 * @param 
	 * @return
	 */
	@RequestMapping("/updateDefaultAddress")
	public @ResponseBody ShippingAddressCustom updateDefaultAddress(@RequestBody ShippingAddressCustom condition, HttpServletRequest request){
		User user = getUser(request);
		ShippingAddressCustom  record = new ShippingAddressCustom();
		if(user == null) return null;
		condition.setUserid(user.getUserid());
		
		record = userService.updateDefaultReturnOld(condition);
		
		return record;
	}
	
	/**
	 * 修改当前用户的默认地址
	 * @param 
	 * @return
	 */
	@RequestMapping("/addAddress")
	public @ResponseBody ShippingAddressCustom addAddress(@RequestBody ShippingAddressCustom condition, HttpServletRequest request){
		User user = getUser(request);
		ShippingAddressCustom  record = new ShippingAddressCustom();
		if(user == null) return null;
		condition.setUserid(user.getUserid());
		
		record = userService.addAddressReturnAddress(condition);
		
		return record;
	}
	
	/**
	 * 根据标识查询订单
	 * @param 
	 * @return
	 */
	@RequestMapping("/queryOrders")
	public @ResponseBody List<OrdersCustom> queryOrders(@RequestBody String logo , HttpServletRequest request){
		User user = getUser(request);
		if(user == null || logo == null) return null;
		logo = logo.substring(1,logo.length()-1);
		
		List<OrdersCustom> list = new ArrayList<OrdersCustom>();
		list = userService.queryOrdersByLogo(logo, user);
		
		return list;
	}
	
	/**
	 * 查询订单总数
	 * @param 
	 * @return
	 */
	@RequestMapping("/queryCountByOrders")
	public @ResponseBody OrdersCountVo queryCountByOrders(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		
		OrdersCountVo sum = new OrdersCountVo();;
		
		
		sum = userService.queryCountByLogo(user);
		
		return sum;
	}
	
	/**
	 * 查询全部评价
	 * @param 
	 * @return
	 */
	@RequestMapping("/queryAllEvaluation")
	public @ResponseBody List<EvaluationCustom> queryAllEvaluation(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		
		List<EvaluationCustom> all = new ArrayList<EvaluationCustom>();
		all = userService.queryAllEvaluationByUserid(user.getUserid());
		
		return all;
	}
	
	@RequestMapping("/queryOneEvaluation")
	public @ResponseBody EvaluationCustom queryEvaluationById(@RequestBody Integer evaluationid,HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		if(evaluationid == null) return null;
		EvaluationCustom info = new EvaluationCustom();
		info = evaluationService.queryEvaluationByPrimaryKey(evaluationid);
		
		return info;
	}
	
	@RequestMapping("/addEvaluatiao")
	public @ResponseBody ShowMessage addEvaluationByUser(@RequestBody EvaluationCustom info ,HttpServletRequest request){
		User user = getUser(request);
		ShowMessage message = new ShowMessage();
		if(user == null || info == null){
			message.setFlag(false);
			return message;
		}
		info.setUserid(user.getUserid());
		message.setFlag(true);
		if(!evaluationService.addEvaluationByUser(info)){
			message.setFlag(false);
		}
		
		return message;
	}
	
	/**
	 * 查询当前用户的最新记录
	 * @return
	 */
	@RequestMapping("/queryUserUpToDate")
	public @ResponseBody IntegralCustom queryUserUpToDate(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		IntegralCustom condition = new IntegralCustom();
		IntegralCustom info = new IntegralCustom();
		condition.setUserid(user.getUserid());
		info = integralService.queryUpToDateRecord(condition);
		
		return info;
	}
	
	/**
	 * 查询当前用户的全部积分记录
	 * @return
	 */
	@RequestMapping("/queryUserAllRecord")
	public @ResponseBody List<IntegralCustom> queryUserAllRecord(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		IntegralCustom condition = new IntegralCustom();
		List<IntegralCustom> info = new ArrayList<IntegralCustom>();
		condition.setUserid(user.getUserid());
		info = integralService.queryAllByCondition(condition);
		return info;
	}
	
	/**
	 * 查询出一件热门的商品 某用户
	 * @return
	 */
	@RequestMapping("/queryPersonHotProduct")
	public @ResponseBody ProductCustom queryPersonHotProduct(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		ProductCustom info = new ProductCustom();
		info = productService.queryPersonHotProduct(user.getUserid());
		return info;
	}
	
	/**
	 * 查询出一件推荐商品（个人中心）某用户
	 * @return
	 */
	@RequestMapping("/queryPersonProductrec")
	public @ResponseBody ProductCustom queryPersonProductrecommend(HttpServletRequest request){
		User user = getUser(request);
		if(user == null) return null;
		ProductCustom info = new ProductCustom();
		info = productService.queryPersonProductrecommend(user.getUserid());
		return info;
	}
	
	
	/**
	 * 查询出某一类所有商品 某分店
	 * @return
	 */
	@RequestMapping("/queryAllProduct")
	public @ResponseBody ProductVo queryAllProduct(@RequestBody ProductCustom condition,HttpServletRequest request){
		User user = getUser(request);
		if(user == null || condition == null) return null;
		ProductVo vo = new ProductVo();
		condition.setUserid(user.getUserid());
		
		vo = productService.queryAllProductByProductTypeId(condition);
		return vo;
	}
	
	/**
	 * 查询出积分所有商品 某分店
	 * @return
	 */
	@RequestMapping("/queryAllIntegralProduct")
	public @ResponseBody IntegraltoarticleVo queryAllIntegralProduct(@RequestBody IntegraltoarticleCuntom condition,HttpServletRequest request){
		User user = getUser(request);
		if(user == null || condition == null) return null;
		IntegraltoarticleVo vo = new IntegraltoarticleVo();
		condition.setUserid(user.getUserid());
		
		vo = integraltoarticleService.queryAllProductIntegralByProductTypeId(condition);
		return vo;
	}
	
	/**
	 * 购买积分商品
	 * @return
	 */
	@RequestMapping("/addIntegralOrder")
	public String addIntegralOrder(IntegraltoarticleCuntom info,HttpServletRequest request,Model model){
		User user = getUser(request);
		if(user == null || info == null) return null;
		info.setUserid(user.getUserid());
		if(integraltoarticleService.addIntegralOrder(info)){
			model.addAttribute("message", "交易成功");
		}else{
			model.addAttribute("message", "交易失败");
		}
		
		
		return "redirect:/jsp/mall/person/pointsMall.jsp";
	}
}
