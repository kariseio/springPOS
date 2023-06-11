package com.example.springpos.controller;

import com.example.springpos.entity.Sale;
import com.example.springpos.service.ProductService;
import com.example.springpos.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StatisticsController {
    ProductService productService;
    SaleService saleService;

    @Autowired
    public StatisticsController(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
    }

    @GetMapping("/statistics")
    public String statistics() {
        return "statistics/statistics";
    }

    // 하루 판매량 Get
    @GetMapping("/day")
    public String dayGet(Model model) {
        List<Sale> list = saleService.getSaleListByDay();
        String bestSeller = saleService.getBestSellerByDay();

        model.addAttribute("salesList", list);
        model.addAttribute("bestSeller", bestSeller);
        return "statistics/day";
    }

    // 일주일 판매량 Get
    @GetMapping("/week")
    public String weekGet(Model model) {
        List<Sale> list = saleService.getSaleListByWeek();
        String bestSeller = saleService.getBestSellerByWeek();

        model.addAttribute("salesList", list);
        model.addAttribute("bestSeller", bestSeller);
        return "statistics/week";
    }

    // 한달 판매량 Get
    @GetMapping("/month")
    public String monthGet(Model model) {
        List<Sale> list = saleService.getSaleListByMonth();
        String bestSeller = saleService.getBestSellerByMonth();

        model.addAttribute("salesList", list);
        model.addAttribute("bestSeller", bestSeller);
        return "statistics/month";
    }

    // 전체 판매량 Get
    @GetMapping("/allDay")
    public String allDayGet(Model model) {
        List<Sale> list = saleService.getSaleList();
        String bestSeller = saleService.getBestSeller();

        model.addAttribute("salesList", list);
        model.addAttribute("bestSeller", bestSeller);
        return "statistics/allDay";
    }
}
