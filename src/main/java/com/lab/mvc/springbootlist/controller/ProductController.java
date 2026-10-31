package com.lab.mvc.springbootlist.controller;

import com.lab.mvc.springbootlist.dto.ProductRequestDTO;
import com.lab.mvc.springbootlist.dto.ProductResponseDTO;
import com.lab.mvc.springbootlist.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public String listProducts(Model model) {
        List<ProductResponseDTO> products = service.listAll();
        model.addAttribute("listProducts", products);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new ProductRequestDTO(null, "", "", "", null));
        model.addAttribute("isEdit", false);
        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(
            @Valid @ModelAttribute("product") ProductRequestDTO product,
            BindingResult result,
            RedirectAttributes attr) {
        if (result.hasErrors()) {
            return product.id() == null ? "new_product" : "edit_product";
        }

        service.save(product);
        attr.addFlashAttribute("success", "Registro salvo com sucesso!");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductPage(@PathVariable("id") Long id, Model model) {
        ProductResponseDTO response = service.get(id);
        ProductRequestDTO product = new ProductRequestDTO(
                response.id(),
                response.nome(),
                response.marca(),
                response.paisFabricacao(),
                response.preco()
        );
        model.addAttribute("product", product);
        model.addAttribute("isEdit", true);
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id, RedirectAttributes attr) {
        service.delete(id);
        attr.addFlashAttribute("success", "Registro excluído com sucesso!");
        return "redirect:/products";
    }
}
