package com.omniwyse.dod.AppConstants;

/*
 *   api.dod.omniwyse.com/deals/v1/
 * 
 */
public class AppConstants {	
	public static final String REGISTER="/register";
	public static final String OTP_VALIDATE="/otpvalidate";
	public static final String CONSUMER_REGISTER="/consumerRegistration";
	public static final String CONSUMER_LOGIN="/consumerlogin";
	public static final String CONSUMER_EMAIL_LOGIN="/consumeremaillogin";
	public static final String CONSUMER_MOBILE_LOGIN="/consumermobilelogin";	
	public static final String CONSUMER_PROFILE="/consumerProfile";
	public static final String MERCHANT_REGISTER="/merchantRegistration";
	public static final String LIST_PROMOTIONS_CATEGORYID="/promotion/categoryId"; 	
	public static final String IDBASE_PROMOTIONS="/IdBasePromotions";	
	public static final String MERCHANT_EMAIL_LOGIN="/merchantemaillogin";
	public static final String MERCHANT_MOBILE_LOGIN="/merchantmobilelogin";	
	public static final String MERCHANT_PROFILE="/merchantProfile";	
	public static final String MERCHANT_LOGIN="/merchantlogin";
	public static final String PROMOTION_SUMMERY="/promotionsummary";	
	public static final String LIST_COUNTRIES="/countries";
	public static final String LIST_CITIES="/cities";
	public static final String LIST_LOCATIONS="/locations";
	public static final String MERCHANT_LIST="/merchantlist";	
	
	public static final String LIST_MERCHANT_PRODUCTS="/merchantproducts";
	public static final String LIST_BRANDID_CATEGORYID="/brandcatidpromotion"; 
	public static final String CREATE_PROMOTION="/promotion";
	public static final String LIST_BRANDID_PROMOTIONS="/promotion/brandId";
	public static final String MERCHANT_PROMOTION_MERCHANTID="/promotion/merchantid";
	public static final String LIST_CATEGORIES="/categories";
	public static final String CREATE_BRANDS="/createbrands";
	public static final String CREATE_PRODUCTS="/createproduct";
	public static final String CREATE_LOCATION="/createlocation";	
	public static final String LIST_BRANDS="/brands";
	public static final String LIST_All_BRANDS="/listbrands";
	public static final String LIST_PROMOTIONS="/promotions";
	public static final String PROMOTION_RESOURCE_URL="/promotion/{id}";
	
	public static final String MERCHANT_RESOURCE_URL="/merchant/{id}";
	public static final String PRODUCT_RESOURCE_URL="/product/{id}";
	public static final String CATEGORY_RESOURCE_URL="/category/{id}";
	
	public static final String BRAND_RESOURCE_URL="/brand/{id}";
	
	public static final String LOCATION_RESOURCE_URL="/location/{id}";
	public static final String LIST_AISLE="listaisle";
	public static final String LIST_BEACONS_PROMOTIONS_INFO="/getbeaconsinfo";
	public static final String LIST_MERCHANT_PROMOTION_BEACONS="/listmerchantpromotionbeacons";
	public static final String CREATE_MERCHANT_PROMOTION_BEACON="/createmerchantpromotionbeacon";
	
	public static final String MERCHANT_UPDATE_SUCCESS_MSG=" Merchant updated successfully ...";
	public static final String MERCHANT_UPDATE_ERROR_MSG=" Sorry , Please enter valid Email id / Mobile no  ... ";
	
	public static final String MERCHANT_DELETE_SUCCESS_MSG=" Merchant Deleted successfully ...";
	public static final String MERCHANT_DELETE_ERROR_MSG=" Sorry , Please enter valid merchant Id  ... ";
	
	public static final String LIST_MERCHANT_PRODUCTS_ERROR_MSG="Sorry , No Products are available right now ";
	public static final String PRODUCTS_SUCCESS_MSG=" Product details are ... ";
	public static final String PRODUCTS_ERROR_MSG=" Sorry , No Products are available right now ";
	
	public static final String UPDATE_PROMOTION_SUCCESS_MSG=" Promotion Updated successfully ... ";
	public static final String UPDATE_PROMOTION_ERROR_MSG=" Please enter existing Promotion Id / No Data Available on selected Promotion Id right now  ... ";
	public static final String DELETE_PROMOTION_SUCCESS_MSG="Promotion deleted successfully ... ";
	public static final String DELETE_PROMOTION_ERROR_MSG=" sorry , no Data available on given Promotion Id ... ";
	public static final String REGISTER_ERROR_MSG=" Sorry , Mobile no is alredy exist ... ";
	public static final String OTP="12345";
	public static final String OTP_VALIDATE_SUCCESS_MSG=" OTP Validation successfully ... ";
	public static final String OTP_VALIDATE_ERROR_MSG="Sorry , Wrong OTP No / Mobile no . ";	
	public static final String CONSUMER_REGISTER_SUCCESS_MSG="Consumer Registration successfully ...";
	public static final String CONSUMER_REGISTER_ERROR_MSG=" Sorry , Mobile no and Mail address is alredy exist ... ";
	public static final String CONSUMER_LOGIN_SUCCESS_MSG=" Login Succes ... ";
	public static final String CONSUMER_LOGIN_ERROR_MSG=" Sorry , Wrong Credentials ...";
	
	public static final String CONSUMER_PROFILE_SUCCESS_MSG=" Consumer Details is , ";
	public static final String CONSUMER_PROFILE_ERROR_MSG=" Sorry , No data available on selected mobile no ... ";	
		
	public static final String MERCHANT_REGISTER_SUCCESS_MSG=" Merchant Registration successfully";
	public static final String MERCHANT_REGISTER_ERROR_MSG=" Sorry , Mobile no and Mail address is alredy exist ... ";	
	 
	public static final String MERCHANT_LOGIN_SUCCESS_MSG=" Login successfully ... ";
	public static final String MERCHANT_LOGIN_ERROR_MSG=" Sorry , Wrong Credentials "; 	
	 
	public static final String PROMOTION_SUCCESS_MSG=" Promotions are , ";
	public static final String PROMOTION_ERROR_MSG=" Sorry , No Promotions are available right now ";	
	public static final String MERCHANT_PROFILE_SUCCESS_MSG=" Success , Merchant Details found ";
	public static final String MERCHANT_PROFILE_ERROR_MSG=" Sorry , no details found on selected mobile no ... ";	
	public static final String MERCHANT_LIST_SUCCESS_MSG=" all merchants details are ,";
	public static final String MERCHANT_LIST_ERROR_MSG=" Sorry , merchants are not found right now  ...  "; 	
		
	public static final String MERCHANT_PROMOTION_SUCCESS_MSG=" Promotions are , ";
	public static final String MERCHANT_PROMOTION_ERROR_MSG="Sorry , No Promotion found on selected Merchantid ... ";
	
	public static final String CATEGORY_SUCCESS_MSG=" Category information is , ";
	public static final String CATEGORY_ERROR_MSG=" Sorry , No data found on Selected Category Id ";
	
	public static final String BRAND_SUCCESS_MSG=" Brand information is , ";
	public static final String BRAND_ERROR_MSG=" Sorry , No data found on Selected Brand Id ";
	
	public static final String LOCATION_SUCCESS_MSG=" Location information is , ";
	public static final String LOCATION_ERROR_MSG=" Sorry , No data found on Selected Location Id ";


	public static final String LIST_COUNTRIES_SUCCESS_MSG=" available Countries are ,";
	public static final String LIST_COUNTRIES_ERROR_MSG="Sorry , No Countries are available right now ";
	public static final String LIST_CITIES_SUCCESS_MSG=" available Cities are ,";
	public static final String LIST_CITIES_ERROR_MSG="Sorry , No Cities are available right now ";
	public static final String LIST_LOCATIONS_SUCCESS_MSG=" available locations are ,";
	public static final String LIST_LOCATIONS_ERROR_MSG="Sorry , No Locations are available right now ";
	
	public static final String LIST_CATEGORIES_SUCCESS_MSG=" available Categories are ,";
	public static final String LIST_CATEGORIES_ERROR_MSG="Sorry , No Categories are available right now ";
	
	public static final String CREATE_BRAND_SUCCESS_MSG=" brand created successfully ... ";
	public static final String CREATE_BRAND_ERROR_MSG=" brand name is already exist ... ";

	public static final String LIST_BRANDS_SUCCESS_MSG=" available Categories with Brands are ,";
	public static final String LIST_ALL_BRANDS_SUCCESS_MSG=" available Brands are ,";
	public static final String LIST_ALL_BRANDS_ERROR_MSG=" Sorry , No brands are available right now ";
	public static final String LIST_BRANDS_ERROR_MSG="Sorry , No Categories are available right now ";
	public static final String LIST_MERCHANT_PRODUCTS_SUCCESS_MSG=" available Products are";
	public static final String PROMOTIONS_SUCCESS_MSG=" Promotion Posted successfully ... ";
	public static final String PROMOTIONS_ERROR_MSG="Sorry , Please check categoryId/brandId/merchantId ...  "; 
	 
	public static final String AVAILABE_PROMOTIONS_SUCCESS_MSG=" available promotions are ... ";
	public static final String AVAILABE_PROMOTIONS_ERROR_MSG="Sorry , No Promotions are available right now ";
	public static final String CREATE_PRODUCTS_SUCCESS_MSG="Product Created";
	public static final String CREATE_PRODUCTS_ERROR_MSG="Product Cannot be Created ";

	
	public static final String CREATE_MERCHANT_PROMOTION_BEACON_SUCCESS_MSG="Merchant Promotion Beacon Created";
	public static final String CREATE_MERCHANT_PROMOTION_BEACON_ERROR_MSG="Merchant Promotion Beacon Cannot be Created ";
	
	public static final String LIST_MERCHANT_PROMOTION_BEACONS_SUCCESS_MSG="available Merchant Promotion Beacon's are";

	public static final String LIST_BEACONS_PROMOTIONS_INFO_SUCCESS_MSG="available Beacons Information";
	public static final String LIST_BEACONS="listbeacons";
	public static final String LIST_BEACONS_SUCCESS_MSG="available Beacons Information";
	
	public static final String LIST_AISLE_SUCCESS_MSG="available Aisle Information";
	public static final String LIST_BEACONS_INFO="listbeaconsbyuidmajorminor";
	public static final String LIST_BEACONS__INFO_SUCCESS_MSG="available Beacons Information";
	public static final String LIST_BEACONS_BY_MERCHANTIS="listbeaconsbymerchantid";
	public static final String LIST_BEACONS_INFO_SUCCESS_MSG="available Beacons Information";
	
}

