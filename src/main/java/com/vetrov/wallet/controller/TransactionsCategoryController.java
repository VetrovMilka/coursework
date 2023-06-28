package com.vetrov.wallet.controller;

import com.vetrov.wallet.entity.dto.TransactionsCategoryDto;
import com.vetrov.wallet.service.TransactionsCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class TransactionsCategoryController {
    private final TransactionsCategoryService transactionsCategoryService;

    @GetMapping
    public String getCategories(Model model) {
        model.addAttribute("categories", transactionsCategoryService.findAllCategoriesOrderByIsIncome());

        return "categoryList";
    }

    @PostMapping
    public String addCategory(
            @RequestParam String category,
            @RequestParam(defaultValue = "false") Boolean isIncome
    ) {
        transactionsCategoryService.addCategory(category, isIncome);

        return "redirect:/categories";
    }

    @GetMapping("{categoryID}")
    public String categoryEditForm(@PathVariable Long categoryID, Model model) {
        model.addAttribute("category", transactionsCategoryService.findById(categoryID));

        return "categoryEdit";
    }

    @PostMapping("/edit")
    public String updateCategory(TransactionsCategoryDto categoryDto) {
        transactionsCategoryService.updateCategory(categoryDto);

        return "redirect:/categories";
    }

    @GetMapping("delete/{categoryID}")
    public String addCategory(@PathVariable Long categoryID) {
        transactionsCategoryService.deleteCategoryById(categoryID);

        return "redirect:/categories";
    }
}
