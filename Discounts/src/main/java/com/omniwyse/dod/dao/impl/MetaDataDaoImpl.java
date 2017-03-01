package com.omniwyse.dod.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.omniwyse.dod.DTO.BrandComparator;
import com.omniwyse.dod.DTO.BrandVO;
import com.omniwyse.dod.DTO.CategoryBrandVO;
import com.omniwyse.dod.DTO.MerchantProductVO;
import com.omniwyse.dod.DTO.ProductVO;
import com.omniwyse.dod.config.AppConfiguration;
import com.omniwyse.dod.dao.MetaDataDao;
import com.omniwyse.dod.model.Brand;
import com.omniwyse.dod.model.Category;
import com.omniwyse.dod.model.MerchantProfile;
import com.omniwyse.dod.model.Product;

@Repository
public class MetaDataDaoImpl implements MetaDataDao {

	private static final Logger logger = Logger.getLogger(AppConfiguration.class);

	@Autowired
	SessionFactory sessionFactory;

	public List<Category> fetchCategories() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = (Query) session.createQuery("from Category c order by c.categoryRank desc");
		List<Category> categories = (List<Category>) query.list();

		return categories;
	}

	public List<CategoryBrandVO> fetchBrands() {
		List<Object> objects = null;
		final String METHOD_NAME = "fetchBrands";
		Session session = null;
		Set<String> categoryName = new HashSet<String>();
		BrandVO brandVO;
		CategoryBrandVO categoryVO = null;
		List<CategoryBrandVO> categoryVOs = new ArrayList<CategoryBrandVO>();
		boolean duplicateFlag;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
		try {

			session = this.sessionFactory.openSession();
			Query query = (Query) session.createQuery("from Category c join c.brands b order by c.categoryId");
			objects = query.list();
			Iterator iterator = objects.iterator();
			while (iterator.hasNext()) {
				duplicateFlag = false;
				Object[] obj = (Object[]) iterator.next();
				Category category = (Category) obj[0];
				Set<Brand> brands = category.getBrands();
				if (!categoryVOs.isEmpty()) {
					for (CategoryBrandVO categoryVOLocal : categoryVOs) {
						if (categoryVOLocal.getCategoryName().equalsIgnoreCase(category.getCategoryName())) {
							duplicateFlag = true;
							break;
						}

					}
				}
				if (!duplicateFlag) {
					categoryName.add(category.getCategoryName());
					categoryVO = new CategoryBrandVO();
					categoryVO.setCategoryId(category.getCategoryId().toString());
					categoryVO.setCategoryName(category.getCategoryName());
					calendar.setTimeInMillis( category.getCreateddate().getTime() );
					Date date = calendar.getTime();
			        String formattedDate = DATE_FORMAT.format(date);
					categoryVO.setCreatedDate(formattedDate);

					for (Brand brand : brands) {
						brandVO = new BrandVO();
						Date dateBrand = calendar.getTime();
				        String formattedDateBrand = DATE_FORMAT.format(dateBrand);
						brandVO.setBrandDescription(brand.getBrandDescription());
						brandVO.setBrandId(brand.getBrandid().intValue());
						brandVO.setBrandImage(brand.getBrandImage());
						brandVO.setBrandName(brand.getBrandName());
						brandVO.setBrandRating(brand.getBrandRating());
						brandVO.setCreated(formattedDateBrand);
						categoryVO.getBrands().add(brandVO);
					}
					categoryVOs.add(categoryVO);
					
					for(CategoryBrandVO categoryBrandVO:categoryVOs){
						Collections.sort(categoryBrandVO.getBrands(),new BrandComparator());
					}


				}
			
			}

		} catch (Exception exception) {
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		} finally {
			session.close();
		}
		return categoryVOs;
	}

	public List<ProductVO> fetchMerchantProducts(ProductVO productVO) {
		Session session;
		Query query;
		List<MerchantProfile> merchantProfiles = null;
		final String METHOD_NAME="fetchMerchantProducts";
		List<Object> objects = null;
		boolean duplicateFlag;
		ProductVO productVOData;
		List<ProductVO> productVOs=new ArrayList<ProductVO>();
		MerchantProductVO merchantProduct;
		try
		{
		session = this.sessionFactory.getCurrentSession();
		query =  (Query)session.createQuery(" from MerchantProfile m where m.id=:merchantId ");
		query.setParameter("merchantId",Integer.valueOf(productVO.getMerchantId()));
		objects = query.list();
		Iterator iterator = objects.iterator();
		while (iterator.hasNext()) {
			duplicateFlag = false;
			MerchantProfile merchantProfile = (MerchantProfile) iterator.next();
			Set<Product> products = merchantProfile.getProducts();
			productVOData=new ProductVO();
			productVOData.setMerchantId(String.valueOf(merchantProfile.getId()));
			
			
			for(Product product:products){
		        merchantProduct=new MerchantProductVO();
				merchantProduct.setProductId(String.valueOf(product.getProductId()));
				merchantProduct.setProductDescription(product.getProductDescription());
				merchantProduct.setProductImage(product.getProductImageLocation());
				merchantProduct.setCreatedDate(product.getProductCreatedDate().toString());
				productVOData.getMerchantProducts().add(merchantProduct);
			
			}
			
			productVOs.add(productVOData);
			
			
		}
		}
		catch(Exception exception){
			logger.error("Exception in " + METHOD_NAME + "" + exception.getMessage());
		}
		
		return productVOs;
	}

}
