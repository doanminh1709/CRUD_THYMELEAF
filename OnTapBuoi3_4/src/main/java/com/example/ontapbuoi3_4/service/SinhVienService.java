package com.example.ontapbuoi3_4.service;

import com.example.ontapbuoi3_4.model.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien> danhSachSv();//Hien thi ra list sinh vien

    SinhVien getSvById(int id);

    void themSinhVien(SinhVien sinhVien);

    void suaThongTinSv(SinhVien sinhVien);

    void xoaSinhVien(int id);

    List<SinhVien> timTheoKeyWord(String keyWord);
}
