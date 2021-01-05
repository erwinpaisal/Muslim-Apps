package com.erwinpaisal.muslimapps.ui.jadwalsholat;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.erwinpaisal.muslimapps.model.JadwalSholat.Jadwal;
import com.erwinpaisal.muslimapps.model.JadwalSholat.ResponseJadwalSholat;
import com.erwinpaisal.muslimapps.model.KodeKota.ResponseKodeKota;
import com.erwinpaisal.muslimapps.repo.Repository;

public class JadwalSholatViewModel extends ViewModel {
    private Repository repository = new Repository();

    public LiveData<ResponseJadwalSholat> JadwalSholatData(String kota, String tgl){
        return repository.getInstance().getjadwalsholat(kota, tgl);
    }

    public LiveData<ResponseKodeKota> KodeKotaData(String kota){
        return repository.getInstance().getkodekota(kota);
    }

    public void onDestroy(){
        repository.getInstance().getNetwork();
    }
}
