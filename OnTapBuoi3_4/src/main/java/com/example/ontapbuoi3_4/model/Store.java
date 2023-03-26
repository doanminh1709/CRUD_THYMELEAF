package com.example.ontapbuoi3_4.model;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<SinhVien> sinhViens = new ArrayList<>();

    static {
        sinhViens.add(new SinhVien("Nguyen Van A", "nguyenvana@gmail.com"));
        sinhViens.add(new SinhVien("Nguyen Van B", "nguyenvanb@gmail.com"));
        sinhViens.add(new SinhVien("Nguyen Van C", "nguyenvanc@gmail.com"));
        sinhViens.add(new SinhVien("Nguyen Van D", "nguyenvand@gmail.com"));
    }

    public static List<SinhVien> getSinhViens() {
        return sinhViens;
    }

    public static void setSinhViens(List<SinhVien> sinhViens) {
        Store.sinhViens = sinhViens;
    }
}
