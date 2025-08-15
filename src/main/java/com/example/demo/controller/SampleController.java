package com.example.demo.controller;

import com.example.demo.model.PersonalInfo;
import com.example.demo.repository.PersonalInfoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SampleController {

    @Autowired
    private PersonalInfoRepository repository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("personalInfo", new PersonalInfo());
        return "form";
    }

    @PostMapping("/form")
    public String confirmForm(@Valid @ModelAttribute("personalInfo") PersonalInfo personalInfo,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        model.addAttribute("personalInfo", personalInfo);
        return "confirm";
    }

    @PostMapping("/form/confirm")
    public String saveData(@Valid @ModelAttribute PersonalInfo personalInfo,
                           BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        repository.save(personalInfo);
        model.addAttribute("message", "登録が完了しました！");
        return "result";
    }

    // 一覧表示＋検索
    @GetMapping("/list")
    public String listData(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<PersonalInfo> list;
        if (keyword != null && !keyword.isEmpty()) {
            list = repository.findByNameContaining(keyword);
        } else {
            list = repository.findAll();
        }
        model.addAttribute("list", list);
        model.addAttribute("keyword", keyword);
        return "list";
    }
}
