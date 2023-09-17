package pack.controller.product;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component
public class ProductBean {
	private String product_id, category_id, brand, model, price, stock_quantity, description, release_date,
			specifications, warranty_period, weight, dimensions, pimage, dimage;
	
	private String searchName, searchValue;
	// pimage, dimge는 이미지 파일명

	// private MultipartFile pimage, dimage;
	// 이미지 조회경로
}