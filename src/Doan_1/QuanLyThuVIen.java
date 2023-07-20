package Doan_1;

import java.util.Scanner;
//import java.text.DecimalFormat;

public class QuanLyThuVIen {
    private static final int MAX_SACH = 100;
    private Sach[] danhSachSach;
    private int soLuongSach;

    public QuanLyThuVIen() {
        danhSachSach = new Sach[MAX_SACH];
        soLuongSach = 0;
    }
  

    public static void main(String[] args) {
        QuanLyThuVIen quanLyThuVien = new QuanLyThuVIen();
        quanLyThuVien.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        
        int luaChon;
        do {
        	System.out.println("                                          ");
        	System.out.println("                                          ");
        	
            System.out.println("\t\t**************** MENU ****************");
            System.out.println("\t\t*********     1. Nhap sach  **********");
            System.out.println("\t\t********      2. Them sach    ********");
            System.out.println("\t\t*****         3. Xoa sach      *******");
            System.out.println("\t\t***           4. Sua sach          ***");
            System.out.println("\t\t*             5. Sap xep sach        *");
            System.out.println("\t\t***           6. Tim kiem sach     ***");
            System.out.println("\t\t*****         7. In sach          ****");
            System.out.println("\t\t********      8. Tong Thanh Tien *****");
            System.out.println("\t\t********      0. Thoat         *******");
            
            System.out.println("\t\t**************************************");
            System.out.println("Nhap lua chon: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự '\n'

            switch (luaChon) {
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;
                case 1:
                    nhapSach(scanner);
                    break;
                case 2:
                    themSach(scanner);
                    break;
                case 3:
                    xoaSach(scanner);
                    break;
                case 4:
                    suaSach(scanner);
                    break;
                case 5:
                    sapXepSach();
                    break;
                case 6:
                    timKiemSach(scanner);
                    break;
                case 7:
                    inSach();
                    break;
                    
                case 8:
                	tinhTongTienSach();
                	break;
                default:
                    System.out.println("Lua chon khong hop le!.");
                    break;
            }
        } while (luaChon != 0);
    }

    public void nhapSach(Scanner scanner) {
    	
    	int soLuongNhap = 0;

        while (true) {
            try {
                System.out.print("Nhap so luong sach: ");
                soLuongNhap = Integer.parseInt(scanner.nextLine());
                if (soLuongNhap <= 0) {
                    System.out.println("So luong sach phai lon hon 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("So luong sach phai la mot chu so hoac day so.");
            }
        }
       
        for (int i = 0; i < soLuongNhap; i++) {
            int namXuatBan;
            String tenSach;
            do {
                System.out.print("\tNhap ten sach: ");
                tenSach = scanner.nextLine().trim(); // Xóa khoảng trắng ở đầu và cuối chuỗi

                // Kiểm tra nếu tên sách chỉ chứa chữ cái, dấu, hoặc khoảng trắng
                if (!tenSach.matches("^[\\p{L}\\s]+$")) {
                    System.out.println("Ten sach khong hop le.");
                }
            } while (!tenSach.matches("^[\\p{L}\\s]+$")); // Lặp lại cho đến khi đúng điều kiện


            

            System.out.print("\tNhap ma sach: ");
            String maSach = scanner.nextLine();
          
            do {
                System.out.print("\tNhap nam xuat ban: ");
                namXuatBan = scanner.nextInt();

                if (namXuatBan > 2023) {
                    System.out.println("Sai nam xuat ban, vui long nhap lai.");
                }
            } while (namXuatBan > 2023);

            double giaSach = 0;

            while (true) {
                try {
                    System.out.print("\tNhap gia sach: ");
                    String inputGiaSach = scanner.nextLine().replace(",","");
                    giaSach = Double.parseDouble(inputGiaSach);
                    if (giaSach <= 0) {
                        System.out.println("Gia sach phai lon hon 0.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Gia sach phai la mot so hoac day so.");
                }
            }

            System.out.print("\tNhap so luong: ");
            int soLuong = Integer.parseInt(scanner.nextLine());
            Sach sach = new Sach(tenSach, maSach, namXuatBan, giaSach, soLuong);
            danhSachSach[soLuongSach] = sach;
            soLuongSach++;
        }

        System.out.println("\t\t\tDanh sach sach sau khi nhap.");
        System.out.println("----------------------------------------------------------------------------------------------");
        inSach();
    }



    public void themSach(Scanner scanner) {
        if (soLuongSach >= MAX_SACH) {
            System.out.println("Da vuot qua so luong toi da cho phep.");
            return;
        }

        System.out.print("Nhap vi tri muon them sach (0 - " + soLuongSach + "): ");
        int viTri = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự '\n'
        if (viTri < 0 || viTri > soLuongSach) {
            System.out.println("Vi tri khong hop le. Sach se duoc them vao cuoi danh sach.");
            viTri = soLuongSach;
        }

        System.out.println("Nhap thong tin sach can them:");
        System.out.print("\tNhap ten sach: ");
        String tenSach = scanner.nextLine();

        System.out.print("\tNhap ma sach: ");
        String maSach = scanner.nextLine();

        int namXuatBan;
        do {
            System.out.print("\tNhap nam xuat ban: ");
            namXuatBan = scanner.nextInt();
            if (namXuatBan > 2023) {
                System.out.println("Sai nam xuat ban, vui long nhap lai.");
            }
        } while (namXuatBan > 2023);

        double giaSach = 0;
        while (true) {
            try {
                System.out.print("\tNhap gia sach: ");
                String inputGiaSach = scanner.nextLine().replace(",", "");
                giaSach = Double.parseDouble(inputGiaSach);
                if (giaSach <= 0) {
                    System.out.println("Gia sach phai lon hon 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia sach phai la mot so hoac day so.");
            }
        }

        System.out.print("\tNhap so luong: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự '\n'

        Sach sach = new Sach(tenSach, maSach, namXuatBan, giaSach, soLuong);

        // Dịch chuyển các sách từ vị trí viTri đến cuối danh sách
        for (int i = soLuongSach; i > viTri; i--) {
            danhSachSach[i] = danhSachSach[i - 1];
        }

        danhSachSach[viTri] = sach;
        soLuongSach++;

        System.out.println("\t\t\tDanh sach sau khi duoc them.");
        System.out.println("----------------------------------------------------------------------------------------------");
        inSach();
    }
    

    public void xoaSach(Scanner scanner) {
        if (soLuongSach == 0) {
            System.out.println("Danh sach trong. khong the xoa sach");
            return;
        }
        System.out.print("Nhap vi tri muon xoa sach (0 - " + soLuongSach + "): ");
        int viTri = scanner.nextInt();
        if (viTri < 0 || viTri >= soLuongSach) {
            System.out.println("Vi tri khong hop le csnbx.");
            return;
        }

        for (int i = viTri; i < soLuongSach - 1; i++) {
            danhSachSach[i] = danhSachSach[i + 1];
        }
        danhSachSach[soLuongSach - 1] = null;
        soLuongSach--;

        System.out.println("\t\t\tDanh sach sau khi duoc xoa.");
        System.out.println("----------------------------------------------------------------------------------------------");
        inSach();
    }

    public void suaSach(Scanner scanner) {
        if (soLuongSach == 0) {
            System.out.println("Danh sach trong khong the sua sach.");
            return;
        }
        System.out.print("Nhap vi tri muon sua thong tin sach (0 - " + (soLuongSach - 1) + "): ");
        int viTri = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự '\n'
        if (viTri < 0 || viTri >= soLuongSach) {
            System.out.println("Vi tri khong hop le.");
            return;
        }

        System.out.println("Nhap thong tin sach can sua (bo trong neu khong muon sua):");
        System.out.print("\tNhap ten sach: ");
        String tenSach = scanner.nextLine();

        System.out.print("\tNhap ma sach: ");
        String maSach = scanner.nextLine();

        int namXuatBan;
        do {
            System.out.print("\tNhap nam xuat ban: ");
            namXuatBan = scanner.nextInt();
            if (namXuatBan > 2023) {
                System.out.println("Sai nam xuat ban, vui long nhap lai.");
            }
        } while (namXuatBan > 2023);

        double giaSach = 0;
        while (true) {
            try {
                System.out.print("\tNhap gia sach: ");
                String inputGiaSach = scanner.nextLine().replace(",", "");
                giaSach = Double.parseDouble(inputGiaSach);
                if (giaSach <= 0) {
                    System.out.println("Gia sach phai lon hon 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Gia sach phai la mot so hoac day so.");
            }
        }

        System.out.print("\tNhap so luong: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự '\n'

        // Chỉnh sửa thông tin sách tại vị trí viTri
        Sach sach = danhSachSach[viTri];
        if (!tenSach.isEmpty()) {
            sach.setTenSach(tenSach);
        }
        if (!maSach.isEmpty()) {
            sach.setMaSach(maSach);
        }
        if (namXuatBan != 0) {
            sach.setNamXuatBan(namXuatBan);
        }
        if (giaSach != 0) {
            sach.setGiaSach(giaSach);
        }
        if (soLuong != 0) {
            sach.setSoLuong(soLuong);
        }

        System.out.println("\t\t\tDanh sach sau khi da sua.");
        System.out.println("----------------------------------------------------------------------------------------------");
        inSach();
    }
    
    public void sapXepSach() {
        if (soLuongSach == 0) {
            System.out.println("Danh sach trong. Khong the sap xep.");
            return;
        }
        // Sắp xếp sách theo tên sách (sử dụng thuật toán sắp xếp chọn)
        for (int i = 0; i < soLuongSach - 1; i++) {
            int viTriMax = i;
            for (int j = i + 1; j < soLuongSach; j++) {
                if (danhSachSach[j].getTenSach().compareToIgnoreCase(danhSachSach[viTriMax].getTenSach()) < 0) {
                    viTriMax = j;
                }
            }

            Sach temp = danhSachSach[i];
            danhSachSach[i] = danhSachSach[viTriMax];
            danhSachSach[viTriMax] = temp;
        }

        // Sắp xếp sách theo năm xuất bản giảm dần
        for (int i = 0; i < soLuongSach - 1; i++) {
            int viTriMax = i;
            for (int j = i + 1; j < soLuongSach; j++) {
                if (danhSachSach[j].getNamXuatBan() > danhSachSach[viTriMax].getNamXuatBan()) {
                    viTriMax = j;
                }
            }

            Sach temp = danhSachSach[i];
            danhSachSach[i] = danhSachSach[viTriMax];
            danhSachSach[viTriMax] = temp;
        }

        System.out.println("\t\t\tDanh sach sau khi da sap xep theo nam xuat ban giam dan.");
        System.out.println("----------------------------------------------------------------------------------------------");
        inSach();
    }


    public void timKiemSach(Scanner scanner) {
        if (soLuongSach == 0) {
            System.out.println("Danh sach trong khong the tim kiem sach.");
            return;
        }

        System.out.print("Nhap ten sach can tim: ");
        String tenSach = scanner.nextLine();

        boolean timThay = false;
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSachSach[i].getTenSach().equalsIgnoreCase(tenSach)) {//so sánh tên sách không phân biệt chữ cái hoa và thường
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay sach voi ten sach \"" + tenSach + "\".");
        }
        System.out.println("\t\t\tDanh sach sach tim thay thao yeu cau");
        System.out.println("----------------------------------------------------------------------------------------------");
        inSach();
        
    }
 // Các phương thức khác của lớp

    public void tinhTongTienSach() {
        if (soLuongSach == 0) {
            System.out.println("Danh sach trong khong the tinh tong thanh tien.");
            return;
        }

        double tongTien = 0;
        for (int i = 0; i < soLuongSach; i++) {
            double giaSach = danhSachSach[i].getGiaSach();
            int soLuong = danhSachSach[i].getSoLuong();
            double thanhTien = giaSach * soLuong;
            tongTien += thanhTien;
        }

        String formattedTongTien = String.format("%.3f", tongTien);
        formattedTongTien += "";

        System.out.println("Tong la: " + formattedTongTien);
    }


    public void inSach() {
      
        if (soLuongSach == 0) {
            System.out.println("Danh sach trong khong the in sach.");
            return;
        }
   
        System.out.println("\tSTT\tMA SACH\t\tTEN SACH\tNAM XUAT BAN\tGIA SACH\tSO LUONG SACH");
        
        System.out.println("+--------------------------------------------------------------------------------------------+");
        for (int i = 0; i < soLuongSach; i++) {
            System.out.print("\t"+(i + 1) + "\t");
            System.out.print( danhSachSach[i].getMaSach() + "\t\t");
            System.out.print(danhSachSach[i].getTenSach() + "\t\t");
            System.out.print(danhSachSach[i].getNamXuatBan() + "\t\t");
            System.out.print(danhSachSach[i].getGiaSach() + "00\t\t");
            System.out.println(danhSachSach[i].getSoLuong()+" cuon");
            System.out.println("+--------------------------------------------------------------------------------------------+");
        }
    }
}


class Sach {
    private String tenSach;
    private String maSach;
    private int namXuatBan;
    private double giaSach;
    private int soLuong;

    public Sach(String tenSach, String maSach, int namXuatBan, double giaSach, int soLuong) {
        this.tenSach = tenSach;
        this.maSach = maSach;
        this.namXuatBan = namXuatBan;
        this.giaSach = giaSach;
        this.soLuong = soLuong;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getGiaSach() {
        return giaSach;
    }

    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
