package com.erwinpaisal.muslimapps.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.erwinpaisal.muslimapps.model.JadwalSholat.Jadwal;
import com.erwinpaisal.muslimapps.model.JadwalSholat.ResponseJadwalSholat;
import com.erwinpaisal.muslimapps.model.KodeKota.ResponseKodeKota;
import com.erwinpaisal.muslimapps.network.ApiService;
import com.erwinpaisal.muslimapps.network.NetworkModule;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Repository {
    private Repository repository;
    private CompositeDisposable composite;

    public ApiService getNetwork(){
        NetworkModule networkModule = new NetworkModule();
        return  networkModule.getApiService();
    }

    public LiveData<ResponseJadwalSholat> getjadwalsholat(String kota, String tgl){
        final MutableLiveData data = new MutableLiveData<ResponseJadwalSholat>();
        composite = new CompositeDisposable();
        composite.add(getNetwork().getJadwalSholat(kota, tgl).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<ResponseJadwalSholat>() {
            @Override
            public void accept(ResponseJadwalSholat responseJadwalSholat) throws Exception {
                data.setValue(responseJadwalSholat);
            }
        }));

        return data;
    }

    public LiveData<ResponseKodeKota> getkodekota(String kota){
        final MutableLiveData data = new MutableLiveData<ResponseKodeKota>();
        composite = new CompositeDisposable();
        composite.add(getNetwork().getKodeKota(kota).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<ResponseKodeKota>() {
            @Override
            public void accept(ResponseKodeKota responseKodeKota) throws Exception {
                data.setValue(responseKodeKota);
            }
        }));

        return data;
    }

    public Repository getInstance(){
        repository = new Repository();
        return repository;
    }

    public void onDestroy(){
        composite.clear();
    }
}
