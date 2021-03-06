package com.george.unsplash.network.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.george.unsplash.localdata.AppPreferences;
import com.george.unsplash.network.models.Statistic.Statistic;
import com.george.unsplash.network.repository.StatisticRepository;

public class StatisticViewModel extends AndroidViewModel {

    StatisticRepository statisticRepository;
    AppPreferences appPreferences;

    public StatisticViewModel(@NonNull Application application) {
        super(application);

        appPreferences = new AppPreferences(application);
        String token = appPreferences.getToken();
        statisticRepository = new StatisticRepository(token);
    }

    public MutableLiveData<Statistic> getStatistic(String username) {
        return loadStatistic(username);
    }

    private MutableLiveData<Statistic> loadStatistic(String username) {
        return statisticRepository.getStatistic(username);
    }
}
