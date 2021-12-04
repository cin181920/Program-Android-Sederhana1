package com.example.fixed;

import java.util.ArrayList;

public class DataKomik {
    private static String[] judulkomik = {
            "Soul",
            "Boruto",
            "Doraemon",
            "Conan",
            "Marvel",
            "Spiderman"
    };

    private static String[] detailkomik = {
            "Soul Land IV adalah sebuah seri manga Jepang yang ditulis dan diilustrasikan oleh Tang Jia San Shao. Soul Land IV – The Ultimate Combat bercerita tentang Mengikuti dengan Binatang Buas Roh dan Guru Jiwa yang hampir punah. Kekuatan bersama dan pengarsipan perdamaian.",
            "Komik ini membuka pertempuran sengit antara Sasuke Uchiha dan musuh yang tidak disebutkan namanya dalam dimensi es reruntuhan istana Kaguya Ōtsutsuki, sementara sosok misterius mengamati dari atas.",
            "Doraemon adalah judul sebuah manga populer yang dikarang Fujiko F. Fujio sejak tahun 1969 dan berkisah tentang kehidupan seorang anak pemalas kelas 5 SD yang bernama Nobi Nobita (野比のび太) yang didatangi oleh sebuah robot kucing bernama Doraemon yang datang dari abad ke 22.",
            "Shinichi Kudo, seorang detektif SMA berusia 17 tahun yang biasanya membantu polisi memecahkan kasus, diserang oleh 2 anggota sindikat misterius ketika mengawasi sebuah pemerasan.",
            "Captain Marvel adalah superhero Amerika Serikat tahun 2019 yang disutradarai oleh Anna Boden dan Ryan Fleck dan diproduseri oleh Kevin Feige.",
            "Serial Spider-Man memecahkan masalah dengan menampilkan Peter Parker, siswa SMA di balik identitas rahasia Spider-Man dan dengan \"obsesi diri dengan penolakan, ketidakmampuan, dan kesepian\" sehingga pembaca muda bisa berhubungan"
    };

    private static int[] imagerkomik = {
            R.drawable.soul,
            R.drawable.boruto,
            R.drawable.doraemon,
            R.drawable.conan,
            R.drawable.marvel,
            R.drawable.spiderman
    };

    static ArrayList<KomponenKomik> getListData() {
        ArrayList<KomponenKomik> list = new ArrayList<>();
        for (int position = 0; position < judulkomik.length; position++) {
            KomponenKomik komponenKomik = new KomponenKomik();
            komponenKomik.setName(judulkomik[position]);
            komponenKomik.setDetail(detailkomik[position]);
            komponenKomik.setPhoto(imagerkomik[position]);
            list.add(komponenKomik);
        }
        return list;
    }
}
