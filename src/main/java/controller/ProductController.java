package controller;


import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView listProduct(){
        ModelAndView modelAndView = new ModelAndView("/index");
        List<Product> productList = this.productService.findAll();
        modelAndView.addObject("productList", productList);
        return modelAndView;
    }

    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }
    @PostMapping("/create")
    public String create(Product product, RedirectAttributes redirect){
        product.setId((int) (Math.random() * 10000));
        this.productService.create(product);
        redirect.addFlashAttribute("success","Them moi thanh cong");
        return "redirect:/product";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable int id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect){
        this.productService.update(product.getId(),product);
        redirect.addFlashAttribute("success", "Sua thanh cong");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product,RedirectAttributes redirect ){
        this.productService.delete(product.getId());
        redirect.addFlashAttribute("success","xoa thanh cong");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String viewProduct(@PathVariable int id, Model model){
        Product product = this.productService.findById(id);
        model.addAttribute("product",product);
        return "/view";
    }





}
