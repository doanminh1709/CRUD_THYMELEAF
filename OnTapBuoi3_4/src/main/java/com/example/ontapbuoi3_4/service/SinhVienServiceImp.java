package com.example.ontapbuoi3_4.service;

import com.example.ontapbuoi3_4.model.SinhVien;
import com.example.ontapbuoi3_4.model.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinhVienServiceImp implements SinhVienService {
    static List<SinhVien> sinhViens = Store.getSinhViens();

    @Override
    public List<SinhVien> danhSachSv() {
        return sinhViens;
    }

    @Override
    public SinhVien getSvById(int id) {
        for (SinhVien sv : sinhViens) {
            if (sv.getId() == id) {
                return sv;
            }
        }
        return null;
    }

    @Override
    public void themSinhVien(SinhVien sinhVien) {
        sinhViens.add(sinhVien);
    }

    @Override
    public void suaThongTinSv(SinhVien sinhVien) {
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getId() == sinhVien.getId()) {
                sinhViens.set(i, sinhVien);
                break;
            }
        }
    }

    @Override
    public void xoaSinhVien(int id) {
        sinhViens.removeIf(item -> item.getId() == id);

//        for (int i = 0; i < sinhViens.size(); i++) {
//            if (sinhViens.get(i).getId() == id) {
//                sinhViens.remove(sinhViens.get(i));
//                sinhViens.remove(i);
//                break;
//            }
        }

    @Override
    public List<SinhVien> timTheoKeyWord(String keyWord) {
        List<SinhVien> svs = new ArrayList<>();
        for (SinhVien sv : sinhViens) {
            if (sv.getName().contains(keyWord) || sv.getEmail().contains(keyWord)) {
                svs.add(sv);
            }
        }
        return svs;
    }
}
