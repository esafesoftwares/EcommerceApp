package com.ecommerce.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;


@ComponentScan(value="com.ecommerce.dao")
@Controller  
public class HomeController {  
	 @Autowired
	    private ProductDao productDao;
	 private Path path;



	@RequestMapping("/hello")  
	    public String redirect()  
	    {  
	        return "home"; 
	       
	    } 

@RequestMapping("/productList")
public String getProducts(Model model) {
    List<Product> products = productDao.getAllProducts();
    model.addAttribute("products", products);

    return "productList";
}

@RequestMapping("/productList/viewProduct/{productId}")
public String viewProduct(@PathVariable String productId, Model model) throws IOException{

    Product product = productDao.getProductById(productId);
    model.addAttribute(product);

    return "viewProduct";
}
@RequestMapping("/admin")
public String adminPage() {
    return "admin";
}

@RequestMapping("/admin/productInventory")
public String productInventory(Model model) {
    List<Product> products = productDao.getAllProducts();
    model.addAttribute("products", products);

    return "productInventory";
}


@RequestMapping("/admin/productInventory/addProduct")
public String addProduct(Model model) {
    Product pro = new Product();
    model.addAttribute("product1",pro);
return "addProduct1";
}

@RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST) 
public String addProductPost( @Valid @ModelAttribute("product1") Product pro,BindingResult br,
		Model model,HttpServletRequest request)throws IOException{
	
		if(br.hasFieldErrors())
		{
			return "addProduct1";
		}
	 
	
    productDao.addProduct(pro);
    List<Product> products = productDao.getAllProducts();
    model.addAttribute("product1", products);
    List<MultipartFile> productImage = pro.getProductImage();
    List<String> fileNames = new ArrayList<String>();
    int i=1;
    Path sourceLocation= Paths.get("/home/prasanna/Desktop/images/newfolder1/");
    Path targetLocation = Paths.get("/home/prasanna/Desktop/images/newfolder1/"+pro.getProductId()+"/");

    Files.copy(sourceLocation, targetLocation);

    if (null !=productImage  && productImage.size() > 0) 
    {
    	
        for (MultipartFile multipartFile : productImage) {

            String fileName = multipartFile.getOriginalFilename();
            fileName=pro.getProductId()+"png"+i;
            i=i+1;
           
           System.out.println(fileName);
            fileNames.add(fileName);
            System.out.println(fileNames.size());
            System.out.println("********************************");
            System.out.println(fileName);
            System.out.println(fileNames.size());
                File convertFile = new File("/home/prasanna/Desktop/images/newfolder1/"+pro.getProductId()+"/",fileName+".png");
	convertFile.createNewFile();
	System.out.println(fileName);
	try (FileOutputStream fout = new FileOutputStream(convertFile))
	{
		fout.write(multipartFile.getBytes());
	}
	catch (Exception exe)
	{
		exe.printStackTrace();
	}
    }
        }
    Path sourceLocation1= Paths.get("/home/prasanna/Desktop/images/newfolder1/"+pro.getProductId()+"/");
    Path targetLocation1 = Paths.get("/home/prasanna/EcommerceApplication/ECommerceApp/src/main/webapp/WEB-INF/resources/"+pro.getProductId()+"/");

    CustomFileVisitior fileVisitor = new CustomFileVisitior(sourceLocation1, targetLocation1);
    //You can specify your own FileVisitOption
    Files.walkFileTree(sourceLocation1, fileVisitor);
    
    return "redirect:/admin/productInventory";
}


@RequestMapping("/admin/productInventory/editProduct/{id}")
public String editProduct(@PathVariable String id,Model model,HttpServletRequest request) {
   
    Product product= productDao.getProductById(id) ;
    String id1=request.getParameter("productId");
    System.out.println(id);
    model.addAttribute("command",product);
    //productDao.editProduct(product);
    
    return "editProduct";
}
 
@RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST) 
public String editProductPost(@ModelAttribute("product") Product product,HttpServletRequest request){
	 //System.out.println(product.getProductId());
String id=request.getParameter("productId");
System.out.println(id);
  productDao.editProduct(product);
   
    
        return "redirect:/admin/productInventory";
}
@RequestMapping("/admin/productInventory/deleteProduct/{productId}")
public String deleteProduct(@PathVariable String productId, Model model)
{
//List<Product> products = productDao.getAllProducts();
//model.addAttribute("products", products);
//path=Paths.get("/home/prasanna/Desktop/images/newfolder1/"+productId+".png");
   // if (Files.exists(path)) {
       // try {
           // Files.delete(path);
       // } catch (IOException e) {
           // e.printStackTrace();
       // }
    

        productDao.deleteProduct(productId);

   // }
    return "redirect:/admin/productInventory";

}
}
