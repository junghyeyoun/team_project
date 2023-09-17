package pack.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.product.ProductDao;
import pack.model.product.ProductDto;

@Controller
public class ProductUpdateController {
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("update")
	public String edit(@RequestParam("product_id")String product_id, @RequestParam("page")String page, Model model) {
		// 수정 대상 자료 읽기
		ProductDto dto = productDao.detail(product_id);
		
		model.addAttribute("data", dto);
		model.addAttribute("page", page);
		
		return "productupdate";
	}
	
	@PostMapping("update")
	public String editProcess(ProductBean bean, Model model) {
			boolean b = productDao.update(bean);
			if(b) {
				return "redirect:productdetail?product_id=" +bean.getProduct_id();
			}else {
				return "redirect:error";
			}
	}
	
	
}