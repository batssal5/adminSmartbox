package com.vdcompany.adminSmartbox.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdcompany.adminSmartbox.bean.BrandVO;
import com.vdcompany.adminSmartbox.bean.CategoryVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencySearchVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreListVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyStoreVO;
import com.vdcompany.adminSmartbox.bean.agency.AgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsAgencyVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsDisplayVO;
import com.vdcompany.adminSmartbox.bean.goods.GoodsVO;
import com.vdcompany.adminSmartbox.service.AgencyService;
import com.vdcompany.adminSmartbox.service.CategoryService;
import com.vdcompany.adminSmartbox.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	@Autowired
	CategoryService cateService;
	@Autowired
	AgencyService agencyService;
	
	
	@RequestMapping("/goodsList")
	private String goodsList(Model model, HttpServletRequest request) {
	
		List<GoodsVO> goodsList = goodsService.getGoodsList();
		model.addAttribute("goodsList", goodsList);

		List<BrandVO> brandList = cateService.getBrandList();
		model.addAttribute("brandList", brandList);

		return "/goods/goodsList";
	}
	
	@RequestMapping("/ajax_search")
	private void ajax_search( HttpServletResponse response, HttpServletRequest request, GoodsVO search ) throws JsonProcessingException, IOException  {
		System.out.println("search : " + search );

		List<GoodsVO> goodsList = new ArrayList<>();
		goodsList = goodsService.getSearchGoodsList(search);

		System.out.println("goodsList : " + goodsList );

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/html;charset=UTF-8"); 
		response.getWriter().print(mapper.writeValueAsString(goodsList));
		
	}
	
	@RequestMapping("/goodsAdd")
	private String goodsAdd(Model model, HttpServletRequest request) {

		List<BrandVO> brandList = cateService.getBrandList();
		model.addAttribute("brandList", brandList);

		return "/goods/goodsAdd";
	}
	
	@RequestMapping(value="/ajax_Add", method=RequestMethod.POST)
	private void ajax_Add( HttpServletResponse response, HttpServletRequest request, GoodsVO goods ) throws JsonProcessingException, IOException  {
		response.setContentType("text/html;charset=UTF-8"); 
		
		System.out.println("goods : " +goods);

		String errorGoods = validGoods(goods);
		if(!errorGoods.equals("")) {		
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorGoods+"\"}");
			return;
		}
		
		// 파일 경로 및 이름 설정]
		String folderName = "/goodsImg";
		String filePath = request.getServletContext().getRealPath("/") + folderName;
		String extension = StringUtils.getFilenameExtension(goods.getImgFile().getOriginalFilename());
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss.").format(new Date());
		fileName += extension;

		
		String home = request.getRequestURL().toString().replace(request.getRequestURI(),"");
		// 파일 저장
		saveFile(goods.getImgFile(), filePath, fileName);
		goods.setImage(home+"/"+folderName+"/"+fileName);	// 파일저장후 해당이름 저장


		int goods_idx = goodsService.insertGoods(goods);
		
		if (goods_idx == 0) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"상품 DB등록중 오류가 생겼습니다.\"}");
		} else {
			response.getWriter().print("{\"ret\":0 }");
		}
	}
	
	
	@RequestMapping("/goodsModify")
	private String goodsModify(Model model, HttpServletRequest request) {

		List<BrandVO> brandList = cateService.getBrandList();
		model.addAttribute("brandList", brandList);

		
		String idx = request.getParameter("idx");
		GoodsVO goods = goodsService.getGoodsDetail(Integer.parseInt(idx));
		model.addAttribute("goods", goods);

		System.out.println("goods : " +goods);

		return "/goods/goodsModify";
	}

	
	@RequestMapping("/ajax_Modify")
	private void ajax_Modify( HttpServletResponse response, HttpServletRequest request, GoodsVO goods ) throws JsonProcessingException, IOException  {
		response.setContentType("text/html;charset=UTF-8"); 

		String errorGoods = validGoods(goods);
		if(!errorGoods.equals("")) {		
			response.getWriter().print("{\"ret\":-1  ,\"error\":\""+errorGoods+"\"}");
			return;
		}

		String idx = request.getParameter("idx");
		goods.setIdx(Integer.parseInt(idx));
		
		if(goods.getImgFile().getOriginalFilename() != null && !goods.getImgFile().getOriginalFilename().equals("")) {
			System.out.println("imagessssssssss : " +goods.getImgFile().getOriginalFilename());

			// 파일 경로 및 이름 설정]
			String folderName = "/goodsImg";
			String filePath = request.getServletContext().getRealPath("/") + folderName;
			String extension = StringUtils.getFilenameExtension(goods.getImgFile().getOriginalFilename());
			String fileName = new SimpleDateFormat("yyyyMMddHHmmss.").format(new Date());
			fileName += extension;
			
			String home = request.getRequestURL().toString().replace(request.getRequestURI(),"");
			// 파일 저장
			saveFile(goods.getImgFile(), filePath, fileName);
			goods.setImage(home+"/"+folderName+"/"+fileName);	// 파일저장후 해당이름 저장

		} else {
			goods.setImage(null);	
		}

		int goods_idx = goodsService.updateGoods(goods);
		
		if (goods_idx == 0) {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"상품 DB등록중 오류가 생겼습니다.\"}");
		} else {
			response.getWriter().print("{\"ret\":0 }");
		}
	}

	
	@RequestMapping("/goodsDisplay")
	private String goodsDisplay(Model model, HttpServletRequest request, GoodsVO search) {
	
		System.out.println("displayList Search : " +search);

		List<AgencyVO> agencyList = agencyService.getAgencyList();
		model.addAttribute("agencyList", agencyList);

		List<BrandVO> brandList = cateService.getBrandList();
		model.addAttribute("brandList", brandList);

		List<GoodsDisplayVO> displayList = goodsService.getGoodsDisplay(search, 0);
		model.addAttribute("displayList", displayList);

		
	
//		System.out.println("displayList : " +displayList);

		
		return "/goods/goodsDisplay";
	}

	@RequestMapping("/ajax_displaySearch")
	private void ajax_displaySearch( HttpServletResponse response, HttpServletRequest request, GoodsVO search ) throws JsonProcessingException, IOException  {
		System.out.println(request.getParameter("agency_idx") + " / search : " + search );

		
		int agency_idx = Integer.parseInt(request.getParameter("agency_idx"));
		
		List<GoodsDisplayVO> displayList = new ArrayList<>();
		displayList = goodsService.getGoodsDisplay(search, agency_idx);

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/html;charset=UTF-8"); 
		response.getWriter().print(mapper.writeValueAsString(displayList));
		
	}
	
	@RequestMapping("/ajax_displayEdit")
	private void ajax_displayEdit( HttpServletResponse response, HttpServletRequest request, GoodsVO search ) throws JsonProcessingException, IOException  {
		System.out.println(request.getParameter("agency_idx") + " / " + request.getParameter("gds_idx"));

		String agency_idx = request.getParameter("agency_idx");
		String gds_idx = request.getParameter("gds_idx");
		String used = request.getParameter("used");
		
		GoodsAgencyVO goodsAgency = new GoodsAgencyVO();
		goodsAgency.setAgency_idx(agency_idx);
		goodsAgency.setGds_idx(gds_idx);
		goodsAgency.setUsed(used);

		int ret = goodsService.insertGoodsDisplay(goodsAgency);

		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/html;charset=UTF-8");
		
		if(ret > 0) {
			response.getWriter().print("{\"ret\":1  ,\"error\":\"\"}");
		} else {
			response.getWriter().print("{\"ret\":-1  ,\"error\":\"진열데이터 업데이트중 오류가 발생했습니다\"}");
		}

	}

	
	public void saveFile(MultipartFile file, String directoryPath, String imgName) throws IOException {
		// parent directory를 찾는다.
		Path directory = Paths.get(directoryPath).toAbsolutePath().normalize();
		System.out.println("directory : " +directory);

		// directory 해당 경로까지 디렉토리를 모두 만든다.
		Files.createDirectories(directory);
		System.out.println("createDirectories");

		// 파일을 저장할 경로를 Path 객체로 받는다.
		Path targetPath = directory.resolve(imgName).normalize();

		// 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
		Assert.state(!Files.exists(targetPath), imgName + " File alerdy exists.");
		file.transferTo(targetPath);
	}

	
	private String validGoods(GoodsVO goods) {
		
		String errorLog = "";
		
		if(goods.getSkuid() == null || goods.getSkuid() == "") {
			errorLog = "skuid를 입력하세요.";
		} else if(goods.getBarcode() == null || goods.getBarcode() == ""){
			errorLog = "바코드를 입력하세요.";
		} else if(goods.getBrand() == null || goods.getBrand() == ""){
			errorLog = "브랜드를 선택하세요.";
		} else if(goods.getGcode() == null || goods.getGcode() == ""){
			errorLog = "상품코드를 입력하세요.";
		} else if(goods.getName() == null || goods.getName() == ""){
			errorLog = "상품명을 입력하세요.";
		} else if(goods.getPrice() == null || goods.getPrice() == ""){
			errorLog = "가격을 입력하세요.";
		} else if(goods.getImgFile() == null){
			errorLog = "이미지를 선택하세요.";
		}

		return errorLog;
	}


}













