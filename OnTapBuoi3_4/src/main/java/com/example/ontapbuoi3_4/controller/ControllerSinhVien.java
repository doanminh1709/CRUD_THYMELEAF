package com.example.ontapbuoi3_4.controller;

import com.example.ontapbuoi3_4.model.SinhVien;
import com.example.ontapbuoi3_4.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ControllerSinhVien {

    @Autowired
    public SinhVienService sinhVienService;

    //Hien thi danh sach tat ca sinh vien
    @GetMapping("/sinhViens")
    public String getAllSinhVien(Model model) {
        List<SinhVien> sinhViens = sinhVienService.danhSachSv();
        model.addAttribute("sinhviens", sinhViens);
        return "students";
    }

    //Tạo mới 1 sinh viên thêm vào list hiển thị danh sach
    @GetMapping("/sinhViens/new")
    public String addSinhVien(Model model) {
        SinhVien newSv = new SinhVien();
        model.addAttribute("sinhVien", newSv);
        return "add";
    }

    @PostMapping("/sinhViens")
    public String saveTtSv(@ModelAttribute("sinhVien") SinhVien sinhVien) {
        sinhVienService.themSinhVien(sinhVien);
        return "redirect:/sinhViens";
    }

    //Sua thong tin cua sinh vien
    //Sua theo id minh se dung path , tim kiem get , request param nhap du lieu vao
    @GetMapping("/sinhViens/edit/{id}")//@PathVariable , @RequestParam : lấy dữ liệu ở trên đường dẫn
    public String suaThongTinSv(@PathVariable("id") int id, Model model) {
        //Tìm ra được sinh viên đấy theo id
        SinhVien sv = sinhVienService.getSvById(id);
        model.addAttribute("sinhVien", sv);
        return "edit";
    }

    @PostMapping("/sinhViens/save")
    public String luuTtSVDaSua(@ModelAttribute("sinhVien") SinhVien sinhVien) {
        sinhVienService.suaThongTinSv(sinhVien);
        return "redirect:/sinhViens";
    }

    //Xoa thong tin cua sinh vien theo id
    @GetMapping("/students/delete/{id}")
    public String xoaThongTinSv(@PathVariable("id") int id) {
        sinhVienService.xoaSinhVien(id);
        return "redirect:/sinhViens";
    }

    @GetMapping("/students/search")
    public String timKiemSv(@RequestParam(value = "keyword", required = false) String keyWord , Model model) {
        List<SinhVien> list =  sinhVienService.timTheoKeyWord(keyWord);
        model.addAttribute("sinhviens",list);
        return "students";
    }

}
