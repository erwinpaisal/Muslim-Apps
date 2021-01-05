package com.erwinpaisal.muslimapps.network;

import com.erwinpaisal.muslimapps.model.JadwalSholat.Jadwal;
import com.erwinpaisal.muslimapps.model.JadwalSholat.ResponseJadwalSholat;
import com.erwinpaisal.muslimapps.model.KodeKota.ResponseKodeKota;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("sholat/format/json/jadwal/kota/{kota}/tanggal/{tgl}")
    Flowable<ResponseJadwalSholat> getJadwalSholat(@Path("kota") String kota, @Path("tgl") String tgl);

    @GET("sholat/format/json/kota/nama/{kota}")
    Flowable<ResponseKodeKota> getKodeKota(@Path("kota") String kota);
}
