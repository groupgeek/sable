package com.xiaohe.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.xiaohe.bean.EvaluationCustom;
import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.ProductVo;
import com.xiaohe.bean.Productcolour;
import com.xiaohe.bean.ProductcolourCustom;
import com.xiaohe.bean.Producttaste;
import com.xiaohe.bean.ProducttasteCustom;
import com.xiaohe.bean.Producttype;
import com.xiaohe.bean.ProducttypeCustom;
import com.xiaohe.mapper.DiscountMapper;
import com.xiaohe.mapper.EvaluationMapper;
import com.xiaohe.mapper.ProductMapper;
import com.xiaohe.mapper.ProductcolourMapper;
import com.xiaohe.mapper.ProductrecommendMapper;
import com.xiaohe.mapper.ProducttasteMapper;
import com.xiaohe.mapper.ProducttypeMapper;
import com.xiaohe.service.ProductService;
import com.xiaohe.util.FileUpload;

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

	public List<ProductCustom> queryPopularProductByCondition(ProductCustom productCustom) {
		
		return productMapper.selectPopularProductByCondition(productCustom);
	}

	public List<ProducttypeCustom> queryProductTypeByCondition(
			ProducttypeCustom producttype) {
		return producttypeMapper.selectProductTypeBycondition(producttype);
	}

	public List<ProductCustom> queryProductrecommend(Integer total) {
		return productrecommendMapper.selectProductrecommend(total);
	}

	public List<ProductCustom> queryDiscountProduct(Integer total) {
		return discountMapper.selectDiscountProducts(total);
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
			String fmt = dt.format(evaluation.getCommentdate());
			evaluation.setStringDate(fmt);
		}
		
		return evaluationList;
	}

	public EvaluationCustom queryEvaluationLevalByProductId(Integer id) {
		List<EvaluationCustom> evaluation = evaluationMapper.selectEvaluationLevalSum(id);
		Integer badReview = 0;
		Integer average = 0;
		Integer praise = 0;
		String praiseOf;
		EvaluationCustom evaluationCustom = new EvaluationCustom();
		for(EvaluationCustom temp : evaluation){
			if(temp.getEvaluationleval() == 1 || temp.getEvaluationleval() == 2){
				
				badReview +=  temp.getEvaluationLevalSum();
			}else if(temp.getEvaluationleval() == 3){
				
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
		
		Integer sum = evaluationMapper.selectEvaluationSum(id);
		Integer pageSum = sum / 3;
		if(sum % 3 != 0){
			pageSum += 1;
		}
		return pageSum;
	}

	public List<ProductCustom> querySimilarProductsByProductId(ProductCustom condition) {
		
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
			for(String temp : productInfo.getTasteString().split(",")){
				record.setProducttaste(temp);
				if(producttasteMapper.insertSelective(record) < 0) return false;
			}
		}
		
		Productcolour recordColor = new Productcolour();
		recordColor.setProductid(productInfo.getProductid());
		if(productInfo.getColorString() != null){
			if(productcolourMapper.deleteColorByProductId(recordColor.getProductid()) < 0) return false;
			for(String temp : productInfo.getColorString().split(",")){
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
			for(String temp : productInfo.getTasteString().split(",")){
				record.setProducttaste(temp);
				if(producttasteMapper.insertSelective(record) < 0) return false;
			}
		}
		
		Productcolour recordColor = new Productcolour();
		recordColor.setProductid(productInfo.getProductid());
		if(productInfo.getColorString() != null || !"".endsWith(productInfo.getColorString())){
			for(String temp : productInfo.getColorString().split(",")){
				recordColor.setProductcolour(temp);
				if(productcolourMapper.insert(recordColor) < 0) return false;
			}
		}
		
		return true;
	}


}