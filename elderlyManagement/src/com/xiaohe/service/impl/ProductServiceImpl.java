package com.xiaohe.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.AddShopCartVo;
import com.xiaohe.bean.Branch;
import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.OrdersCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductVo;
import com.xiaohe.bean.Productcolour;
import com.xiaohe.bean.ProductcolourCustom;
import com.xiaohe.bean.Producttaste;
import com.xiaohe.bean.ProducttasteCustom;
import com.xiaohe.bean.Producttype;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.bean.ShippingAddVo;
import com.xiaohe.bean.ShippingAddressCustom;
import com.xiaohe.bean.Shoppingcar;
import com.xiaohe.bean.ShoppingcarCustom;
import com.xiaohe.bean.User;
import com.xiaohe.bean.UserCustom;
import com.xiaohe.mapper.BranchMapper;
import com.xiaohe.mapper.DiscountMapper;
import com.xiaohe.mapper.EvaluationMapper;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProductcolourMapper;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.mapper.ProducttasteMapper;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.mapper.ShoppingcarMapper;
import com.xiaohe.mapper.UserMapper;
import com.xiaohe.service.ProductService;
import com.xiaohe.service.ShippingAddressService;
import com.xiaohe.service.UserService;
import com.xiaohe.util.FileUpload;
import com.xiaohe.util.GetStringByDate;

@Repository("productService")
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	@Qualifier("productMapper")
	private ProductMapper productMapper;
	
	@Autowired
	@Qualifier("producttypeMapper")
	private ProducttypeMapper producttypeMapper;
	
	@Autowired
	@Qualifier("productrecommendMapper")
	private ProductrecommendMapper productrecommendMapper;
	
	@Autowired
	@Qualifier("discountMapper")
	private DiscountMapper discountMapper;
	
	@Autowired
	@Qualifier("evaluationMapper")
	private EvaluationMapper evaluationMapper;
	
	@Autowired
	@Qualifier("producttasteMapper")
	private ProducttasteMapper producttasteMapper;
	
	@Autowired
	@Qualifier("productcolourMapper")
	private ProductcolourMapper productcolourMapper;
	
	@Autowired
	@Qualifier("shoppingcarMapper")
	private ShoppingcarMapper shoppingcarMapper;
	
	@Autowired
	@Qualifier("branchMapper")
	private BranchMapper branchMapper;
	
	@Autowired
	@Qualifier("ordersMapper")
	private OrdersMapper ordersMapper;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Autowired
	@Qualifier("shippingAddressService")
	private ShippingAddressService shippingAddressService;
	
	@Autowired
	@Qualifier("userMapper")
	private UserMapper userMapper;

	public List<ProductCustom> queryPopularProductByCondition(ProductCustom productCustom) {
		
		return productMapper.selectPopularProductByCondition(productCustom);
	}

	public List<ProducttypeCustom> queryProductTypeByCondition(
			ProducttypeCustom producttype) {
		return producttypeMapper.selectProductTypeBycondition(producttype);
	}

	public List<ProductCustom> queryProductrecommend(Integer userid) {
		return productrecommendMapper.selectProductrecommend(userid);
	}

	public List<ProductCustom> queryDiscountProduct(Integer usetid) {
		return discountMapper.selectDiscountProducts(usetid);
	}

	public List<ProductCustom> queryProductByBlurry(String condition) {
		return productMapper.selectProductByBlurryCondition(condition);
	}

	public List<ProductCustom> queryProductByCondition(ProductCustom condition) {
		List<ProductCustom> listTemp = new ArrayList<ProductCustom>();
		if(condition != null){
			if(condition.getCurrentPage() >= 1){
				 Integer tempBegin = (condition.getCurrentPage()-1) * condition.getTotal();
				condition.setBegin(tempBegin);
				/*condition.setSort(null);
				condition.setProducttypename(null);*/
			}else{
				condition.setBegin(0);
			}
			if(condition.getProducttypename() == "" || "null".equals(condition.getProducttypename())  ){
				condition.setProducttypename(null);
			}
			if(condition.getSort() == "" || "null".equals(condition.getSort())){
				condition.setSort(null);
			}
		}
		
		listTemp = productMapper.selectProductByCondition(condition);
		return listTemp;
	}

	public Integer queryProductSumByCondition(ProductCustom condition) {
		if(condition == null) return null;

		if(condition.getProducttypename() == "" || "null".equals(condition.getProducttypename())  ){
			condition.setProducttypename(null);
		}
		if(condition.getSort() == "" || "null".equals(condition.getSort())){
			condition.setSort(null);
		}
		Integer sum = productMapper.selectProductSumByCondition(condition);
		return sum;
	}

	public ProductCustom queryProductInfoById(Integer id) {
		if(id == null) return null;
		ProductCustom product= new ProductCustom();
		Product temp = productMapper.selectByPrimaryKey(id);
		if(temp != null){
			
			if(temp.getEdiblemethod() != null){
				
				product = productMapper.selectProductTasteById(id);
				product.setColourList(null);
			}else{
				product = productMapper.selectProductColourById(id);
				if(product != null){
					product.setTasteList(null);
				}
			}
		}
		
		return product;
	}

	public List<EvaluationCustom> queryEvaluationByProductId(EvaluationCustom condition) {
		if(condition == null) return null;
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		condition.setPageNum(3);
		if(condition.getCurrentPage() > 0){
			Integer beginTemp = (condition.getCurrentPage() - 1) * condition.getPageNum();
			condition.setBegin(beginTemp);
		}else{
			condition.setBegin(0);
		}
		
		List<EvaluationCustom> evaluationList = evaluationMapper.selectEvaluationsByProdutId(condition);
		for(EvaluationCustom evaluation : evaluationList){
			if(evaluation.getCommentdate() == null) continue;
			String fmt = dt.format(evaluation.getCommentdate());
			evaluation.setStringDate(fmt);
		}
		
		return evaluationList;
	}

	public EvaluationCustom queryEvaluationLevalByProductId(Integer id) {
		if(id == null) return null;
		List<EvaluationCustom> evaluation = evaluationMapper.selectEvaluationLevalSum(id);
		
		if(evaluation == null) return null;
		Integer badReview = 0;
		Integer average = 0;
		Integer praise = 0;
		String praiseOf;
		EvaluationCustom evaluationCustom = new EvaluationCustom();
		for(EvaluationCustom temp : evaluation){
			if(temp.getEvaluationleval() == null) continue;
			if(temp.getEvaluationleval() == 1){
				
				badReview +=  temp.getEvaluationLevalSum();
			}else if(temp.getEvaluationleval() == 2){
				
				average +=  temp.getEvaluationLevalSum();
			}else{
				praise += temp.getEvaluationLevalSum();
			}
			
		}
		double a = praise* 100;
		double b = (average + badReview + praise)* 100;
		double c = (a / b) * 100;
		DecimalFormat df = new DecimalFormat("#.00");
		praiseOf = df.format(c);
		
		evaluationCustom.setBadReview(badReview);
		evaluationCustom.setAverage(average);
		evaluationCustom.setPraise(praise);
		evaluationCustom.setPraiseOf(praiseOf);
		
		
		return evaluationCustom;
	}

	public Integer queryEvaluationSum(Integer id) {
		if(id == null) return null;
		Integer sum = evaluationMapper.selectEvaluationSum(id);
		Integer pageSum = sum / 3;
		if(sum % 3 != 0){
			pageSum += 1;
		}
		return pageSum;
	}

	public List<ProductCustom> querySimilarProductsByProductId(ProductCustom condition) {
		if(condition == null) return null;
		Product product = productMapper.selectByPrimaryKey(condition.getProductid());
		if(product != null){
			condition.setProducttypeid(product.getProducttypeid());
		}
		List<ProductCustom> products = productMapper.selectProductByProducttypeId(condition);
		return products;
	}

	public List<ProductCustom> queryProductByTypeId(ProductCustom condition) {
		return productMapper.selectProductBytypeId(condition);
	}

	public Map<ProducttypeCustom, List<ProductCustom>> queryProductByAllType(
			ProductCustom condition) {
		//容器
		List<ProducttypeCustom> allType = new ArrayList<ProducttypeCustom>();
		List<ProductCustom> products = new ArrayList<ProductCustom>();
		Map<ProducttypeCustom, List<ProductCustom>> allTypeProducts = new HashMap<ProducttypeCustom, List<ProductCustom>>();
		
		//开始查询所有的类型
		allType = producttypeMapper.selectSmallProductType(null);
		//开始查询某一类类型的产品
		if(allType != null){
			for(ProducttypeCustom type: allType){
				condition.setProducttypeid(type.getProducttypeid());
				products = productMapper.selectProductBytypeId(condition);
				//把查询出来的产品和类型加入到容器中
				allTypeProducts.put(type, products);
			}
		}
		
		return allTypeProducts;
	}

	public ProductVo queryAllProductByCondition(ProductCustom condition) {
		
		ProductVo productVo = new ProductVo();
		List<ProductCustom> allProducts = new ArrayList<ProductCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		if(condition != null){
			if(condition.getProducttypeid() == -1){
				condition.setProducttypeid(null);
			}
			
			if(condition.getCurrentPage() >= 1){
				Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
				condition.setBegin(tempBegin);
			}else{
				condition.setBegin(0);
			}
			
		}
		if(condition.getBranchid() != null)
		if(condition.getBranchid() == -1){
			condition.setBranchid(null);
		}
		allProducts = productMapper.selectAllProductByCondition(condition);
		sum = productMapper.selectAllProductSumByCondition(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		productVo.setProductList(allProducts);
		productVo.setProductSum(sum);
		productVo.setPageSum(pageSum);
		
		
		return productVo;
	}


	public List<ProductCustom> quertyStockout() {
			
			return productMapper.quertyStockout();
		}

	public ProductCustom queryProductInfoByProductid(Integer productid) {
		if(productid == null || productid < 0) return null;
		ProductCustom productInfo = new ProductCustom();
		ProducttypeCustom producttype = productMapper.selectProductFathertypeById(productid);
		Producttype father = producttypeMapper.selectByPrimaryKey(producttype.getFatherid());
		if(father == null) return null;
		if("服装".equals(father.getProducttypename())){
			productInfo = productMapper.selectProductAndColorById(productid);
		}else if("食品".equals(father.getProducttypename())){
			productInfo = productMapper.selectProductAndTasteById(productid);
		}else{
			productInfo = productMapper.selectProductAndOtherById(productid);
		}
		
		
		return productInfo;
	}

	public ProductVo updateProductView(Integer productid) {
		if(productid == null || productid < 0) return null;
		
		ProductVo productVo = new ProductVo();
		List<ProducttypeCustom> fatherTypeList = new ArrayList<ProducttypeCustom>();
		ProductCustom productInfo = new ProductCustom();
		
		ProducttypeCustom producttype = productMapper.selectProductFathertypeById(productid);
		Producttype father = producttypeMapper.selectByPrimaryKey(producttype.getFatherid());
		if(father == null) return null;
		if("服装".equals(father.getProducttypename())){
			productInfo = productMapper.selectProductAndColorById(productid);
		}else if("食品".equals(father.getProducttypename())){
			productInfo = productMapper.selectProductAndTasteById(productid);
		}else{
			productInfo = productMapper.selectProductAndOtherById(productid);
		}
		
		fatherTypeList = producttypeMapper.selectAllFatherType();
		productVo.setFatherTypeList(fatherTypeList);
		productVo.setProductInfo(productInfo);
		
		return productVo;
	}


public List<ProductCustom> quertyNoBranchRecommendProduct(Integer branchid) {
	
	return productMapper.quertyNoBranchRecommendProduct(branchid);
}


	public boolean updateProduct(ProductCustom productInfo,MultipartFile pictureUpload) {
		if(productInfo == null) return false;
		if(productInfo.getProductid() == null || productInfo.getProductid() < 0) return false;
		/*List<ProducttasteCustom> allTaste = new ArrayList<ProducttasteCustom>();
		List<ProductcolourCustom> allColor = new ArrayList<ProductcolourCustom>();*/
		
		if(!pictureUpload.isEmpty()){
			try {
				productInfo.setPicture(FileUpload.oneFileUpload(pictureUpload,productInfo.getPicture(), "picture"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(productMapper.updateByPrimaryKeySelective(productInfo) < 0) return false;
		
		
		
		Producttaste record = new Producttaste();
		record.setProductid(productInfo.getProductid());
		
		if(productInfo.getTasteString() != null){
			if(producttasteMapper.deleteProducttasteByProductid(record.getProductid()) < 0) return false;
			for(String temp : productInfo.getTasteString().split(" ")){
				record.setProducttaste(temp);
				if(producttasteMapper.insertSelective(record) < 0) return false;
			}
		}
		
		Productcolour recordColor = new Productcolour();
		recordColor.setProductid(productInfo.getProductid());
		if(productInfo.getColorString() != null){
			if(productcolourMapper.deleteColorByProductId(recordColor.getProductid()) < 0) return false;
			for(String temp : productInfo.getColorString().split(" ")){
				recordColor.setProductcolour(temp);
				if(productcolourMapper.insert(recordColor) < 0) return false;
			}
		}
		
		
		
		return true;
	}

	public boolean addProduct(ProductCustom productInfo, MultipartFile pictureUpload) {
		if(productInfo == null) return false;
		if(!pictureUpload.isEmpty()){
			try {
				productInfo.setPicture(FileUpload.oneFileUpload(pictureUpload,null, "picture"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(productMapper.insertSelective(productInfo) < 0) return false;
		
		Producttaste record = new Producttaste();
		record.setProductid(productInfo.getProductid());
		
		if(productInfo.getTasteString() != null ||  !"".endsWith(productInfo.getTasteString())){
			for(String temp : productInfo.getTasteString().split(" ")){
				record.setProducttaste(temp);
				if(producttasteMapper.insertSelective(record) < 0) return false;
			}
		}
		
		Productcolour recordColor = new Productcolour();
		recordColor.setProductid(productInfo.getProductid());
		if(productInfo.getColorString() != null || !"".endsWith(productInfo.getColorString())){
			for(String temp : productInfo.getColorString().split(" ")){
				recordColor.setProductcolour(temp);
				if(productcolourMapper.insert(recordColor) < 0) return false;
			}
		}
		
		return true;
	}

	public boolean addShopCart(Shoppingcar shoppingcar) {
		if(shoppingcar == null) return false;
		if(shoppingcar.getProductid() == null || shoppingcar.getProductid() < 0 ) return false;
		Product product = new ProductCustom();
		product = productMapper.selectByPrimaryKey(shoppingcar.getProductid());
		
		shoppingcar.setPrice(product.getPrice());
		shoppingcar.setProductname(product.getProductname());
		if(shoppingcarMapper.insertSelective(shoppingcar) < 0) return false;
		
		
		return true;
	}

	public List<ShoppingcarCustom> queryAllShopCart(Integer userid) {
		if(userid == null) return null;
		List<ShoppingcarCustom> all = new ArrayList<ShoppingcarCustom>();
		List<ShoppingcarCustom> food = new ArrayList<ShoppingcarCustom>();
		List<ShoppingcarCustom> clothes = new ArrayList<ShoppingcarCustom>();
		List<ShoppingcarCustom> other = new ArrayList<ShoppingcarCustom>();
		
		food = shoppingcarMapper.selectAllShopCartFoodByUserid(userid);
		for(ShoppingcarCustom temp : food){
			temp.setType(1);
		}
		clothes = shoppingcarMapper.selectAllShopCartClothesByUserid(userid);
		for(ShoppingcarCustom temp : clothes){
			temp.setType(2);
		}
		other = shoppingcarMapper.selectAllShopCartOtherByUserid(userid);
		for(ShoppingcarCustom temp : other){
			temp.setType(0);
		}
		if(food != null) all.addAll(food);
		if(clothes != null) all.addAll(clothes);
		if(other != null) all.addAll(other);
		
		return all;
	}

	public String[] addOrders(Map<UserCustom, ShoppingcarCustom[]> shoppingcar) {
		if(shoppingcar == null) return null;
		if(shoppingcar.isEmpty()) return null;
		ShoppingcarCustom[] shoppingcarCustoms = null;
		
		
		UserCustom user = new UserCustom();
		Shoppingcar car = new ShoppingcarCustom(); 
		List<Shoppingcar> listShop = new ArrayList<Shoppingcar>();
		OrdersCustom info = new OrdersCustom();
		ShippingAddressCustom shippingAddress = new ShippingAddressCustom();
		
		
		
		
		Iterator<UserCustom> it =  shoppingcar.keySet().iterator();
		while (it.hasNext()){
			user = it.next();
			shoppingcarCustoms = shoppingcar.get(user);
		}
		
		if(user == null) return null;
		if(user.getUserid() == null || user.getUserid() < 0) return null;
		if(shoppingcarCustoms == null) return null;
		
		//查询默认地址
		ShippingAddVo svo = userService.queryAllAddressByUserid(user.getUserid());
		for(ShippingAddressCustom temp : svo.getAddresssList()){
			if(temp.getDefaultaddress()) shippingAddress = temp;
		}
		
		//返回值 返回订单id
		String[] ordersId = new String[shoppingcarCustoms.length];
		int index = 0;
				
		for(ShoppingcarCustom one : shoppingcarCustoms){
			if(one.getShoppingcarid() == null) return null;
			//更新数量
			shoppingcarMapper.updateByPrimaryKeySelective(one);
			//查询购物车
			car = shoppingcarMapper.selectByPrimaryKey(one.getShoppingcarid());
			if(car == null) return null;
			if(car.getUserid() != user.getUserid()) return null;
			
			//生成订单
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String orderid = df.format(new Date())+(ordersMapper.selectCountOrder()+1) + UUID.randomUUID().toString().split("-")[0];
			
			info.setOrderid(orderid);
			info.setUserid(user.getUserid());
			info.setProductid(car.getProductid());
			info.setProductname(car.getProductname());
			info.setUsername(shippingAddress.getReceiver());
			info.setResaddress(shippingAddress.getShippingaddress());
			info.setProductnumber(car.getNumber());
			info.setPrice(car.getPrice());
			//运算总价
			BigDecimal number = new BigDecimal(car.getNumber());
			BigDecimal totalprice = new BigDecimal(0);
			totalprice = number.multiply(car.getPrice());
			info.setTotalprice(totalprice);
			info.setOrdertime(new Date());
			info.setPhone(shippingAddress.getPhone()+"");
			
			
			//添加颜色型号口味或者其他
			Producttaste producttaste = producttasteMapper.selectByPrimaryKey(car.getTaste());
			Productcolour productcolour = productcolourMapper.selectByPrimaryKey(car.getColour());
			if(producttaste != null)
			info.setTaste(producttaste.getProducttaste());
			
			if(productcolour != null)
			info.setColour(productcolour.getProductcolour());
			
			info.setSize(car.getSziestring());
			
			
			//查询用户分店
			Branch branch = new Branch();
			branch = branchMapper.selectBranchByUserid(user.getUserid());
			info.setBranchid(branch.getBranchid());
			info.setOrderstatus("未付款");
			//info.setProductstatus("未发货");
			//info.setSignstatus("未签收");
			//info.setEvaluationstatus(false);
			if(ordersMapper.insertSelective(info) < 0) return null;
			ordersId[index] = orderid;
			index++;
			
			//删除购物车
			if(shoppingcarMapper.deleteByPrimaryKey(one.getShoppingcarid()) <= 0) return null;
		}
		
		
		
		return ordersId;
	}

	public List<OrdersCustom> queryAllOrdersByOrdersId(
			Map<User, String[]> orders) {
		if(orders == null) return null;
		if(orders.isEmpty()) return null;
		
		User user = new User();//key
		String[] value = null;//value
		OrdersCustom ordersData = new OrdersCustom();//单条订单
		List<OrdersCustom> all = new ArrayList<OrdersCustom>();//订单集合
		
		Iterator<User> it = orders.keySet().iterator();
		while(it.hasNext()){
			user = it.next();
			value = orders.get(user);
		}
		
		if(user == null) return null;
		if(user.getUserid() == null) return null;
		
		
		
		for(String id : value){
			ordersData = ordersMapper.selectOrdersByOrdersId(id);
			if(ordersData == null) return null;
			if(user.getUserid() != ordersData.getUserid()) return null;
			ordersData.setOrdertimeString(GetStringByDate.getString(ordersData.getOrdertime()));
			all.add(ordersData);
		}
		
		return all;
	}

	public boolean updateOrderById(OrdersCustom info) {
		
		if(info == null) return false;
		if(info.getUserid() == null || info.getOrdersid() == null) return false;
		
		//if(ordersMapper.updateByUseridSelective(info) <= 0) return false;
		//更新订单
		for(String oid : info.getOrdersid()){
			if("".equals(oid) || oid == null) continue;
			info.setOrderid(oid);
			if(ordersMapper.updateByPrimaryKeySelective(info) <= 0) return false;
		}
		
		return true;
	}

	public boolean updateOrderNumberById(OrdersCustom orderInfo) {
		
		if(orderInfo == null) return false;
		if(orderInfo.getOrderid() == null) return false;
		
		if(ordersMapper.updateByPrimaryKeySelective(orderInfo) < 0) return false;
		
		return true;
	}

	public boolean deleteOrderByOid(String oid) {
		if(oid == null) return false;
		oid = oid.substring(1, oid.length()-1);
		
		if(ordersMapper.deleteOrdersById(oid) <= 0) return false;
		
		return true;
	}

	public boolean deleteShoppingcarById(Integer id) {
		if(id == null) return false;
		if(shoppingcarMapper.deleteByPrimaryKey(id) <= 0) return false;
		return true;
	}

	public ProductCustom queryColourOrTasteByProductid(Integer pid) {
		if(pid == null) return null;
		ProductCustom colourOrTaste = new ProductCustom();
		List<ProducttasteCustom> tasteList = new ArrayList<ProducttasteCustom>();
	    List<ProductcolourCustom> colourList = new ArrayList<ProductcolourCustom>();
	    tasteList = producttasteMapper.selectasteByProductid(pid);
	    colourList = productcolourMapper.selectColourByProductid(pid);
	    if(tasteList != null) colourOrTaste.setTasteList(tasteList);
	    if(colourList != null) colourOrTaste.setColourList(colourList);
		
		return colourOrTaste;
	}

	public boolean updateColourOrTasteByShopcarid(ShoppingcarCustom info) {
		
		if(info == null) return false;
		if(info.getShoppingcarid() == null) return false;
		
		if(shoppingcarMapper.updateByPrimaryKeySelective(info) < 0) return false;
		
		return true;
	}

	public ProductCustom queryPersonHotProduct(Integer userid) {
		if(userid == null) return null;
		return productMapper.selectPersonHotProduct(userid);
	}

	public ProductCustom queryPersonProductrecommend(Integer userid) {
		if(userid == null) return null;
		return productMapper.selectPersonProductrecommend(userid);
	}

	public ProductVo queryAllProductByProductTypeId(ProductCustom condition) {
		if(condition == null) return null;
		if(condition.getUserid() == null) return null;
		if(condition.getProducttypeid() == null) return null;
		ProductVo productVo = new ProductVo();
		List<ProductCustom> allProducts = new ArrayList<ProductCustom>();
		Integer pageSum = 0;
		Integer sum = 0;
		
			
		if(condition.getCurrentPage() >= 1){
			Integer tempBegin = (condition.getCurrentPage()-1) * condition.getPageNum();
			condition.setBegin(tempBegin);
		}else{
			condition.setBegin(0);
		}
			
		
		
		allProducts = productMapper.selectAllProductByTypeId(condition);
		sum = productMapper.selectAllProductSumByTypeId(condition);
		pageSum = sum / condition.getPageNum();
		if(sum % condition.getPageNum() != 0){
			pageSum += 1;
		}
		productVo.setProductList(allProducts);
		productVo.setProductSum(sum);
		productVo.setPageSum(pageSum);
		return productVo;
	}

	public String buyNow(ProductCustom info) {
		UserCustom user = new UserCustom();
		OrdersCustom orders = new OrdersCustom();
		ShippingAddressCustom shippingAddress = new ShippingAddressCustom();
		
		
		//查询用户以及默认地址
		ShippingAddVo svo = userService.queryAllAddressByUserid(info.getUserid());
		user = svo.getUser();
		for(ShippingAddressCustom temp : svo.getAddresssList()){
			if(temp.getDefaultaddress()) shippingAddress = temp;
		}
		
		
		//生成订单
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderid = df.format(new Date())+(ordersMapper.selectCountOrder()+1) + UUID.randomUUID().toString().split("-")[0];
		
		orders.setOrderid(orderid);
		orders.setUserid(user.getUserid());
		orders.setProductid(info.getProductid());//
		orders.setProductname(info.getProductname());//
		orders.setUsername(shippingAddress.getReceiver());
		orders.setResaddress(shippingAddress.getShippingaddress());
		orders.setProductnumber(1);
		orders.setPrice(info.getPrice());//
		//运算总价
		//BigDecimal number = new BigDecimal(car.getNumber());
		//BigDecimal totalprice = new BigDecimal(0);
		//totalprice = number.multiply(car.getPrice());
		orders.setTotalprice(info.getPrice());
		orders.setOrdertime(new Date());
		orders.setPhone(shippingAddress.getPhone()+"");
		
		
		//添加颜色型号口味或者其他
		Producttaste producttaste = producttasteMapper.selectByPrimaryKey(info.getTaste());//
		Productcolour productcolour = productcolourMapper.selectByPrimaryKey(info.getColour());//
		if(producttaste != null)
			orders.setTaste(producttaste.getProducttaste());
		
		if(productcolour != null)
			orders.setColour(productcolour.getProductcolour());
		
		orders.setSize(info.getSizeString());//
		
		
		//查询用户分店
		Branch branch = new Branch();
		branch = branchMapper.selectBranchByUserid(user.getUserid());
		orders.setBranchid(branch.getBranchid());
		orders.setOrderstatus("未付款");
		//info.setProductstatus("未发货");
		//info.setSignstatus("未签收");
		//info.setEvaluationstatus(false);
		if(ordersMapper.insertSelective(orders) < 0) return null;
		return orderid;
	}

	public boolean deleteProduct(Integer productid) {
		
		if(productid == null) return false;
		
		if(productMapper.deleteByPrimaryKey(productid) <= 0) return false;
		
		return true;
	}

	public boolean productReceipt(UserCustom userInfo) {
		if(userInfo == null) return false;
		if(userInfo.getUserid() == null || userInfo.getPassword() == null || userInfo.getOrderid() == null) return false;
		
		UserCustom user = new UserCustom();
		user = userMapper.selectUserById(userInfo.getUserid());
		
		if(user == null) return false;
		if(!userInfo.getPassword().equals(user.getPassword())) return false;
		
		//修改订单
		OrdersCustom order = new OrdersCustom();
		order = ordersMapper.selectOrdersByOrdersId(userInfo.getOrderid());
		if(order == null) return false;
		
		order.setSignstatus("已签收");
		order.setSubmissiontime(new Date());
		if(ordersMapper.updateByPrimaryKeySelective(order) <= 0) return false;
		
		return true;
	}

	
	
}