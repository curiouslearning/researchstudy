package org.curiouslearning.container.presentation.viewmodals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

import org.curiouslearning.container.MainActivity;
import org.curiouslearning.container.data.model.WebApp;
import org.curiouslearning.container.data.respository.WebAppRepository;

import java.util.List;

public class HomeViewModal extends AndroidViewModel {

    private WebAppRepository webAppRepository;
    private Application application;
    private LifecycleOwner lifecycleOwner;

    public HomeViewModal(@NonNull Application application, LifecycleOwner lifecycleOwner) {
        super(application);
        this.application = application;
        this.lifecycleOwner = lifecycleOwner;
        webAppRepository = new WebAppRepository(application);
    }

    public LiveData<List<WebApp>> getSelectedlanguageWebApps(String selectedLanguage) {
        return webAppRepository.getSelectedlanguageWebApps(selectedLanguage, lifecycleOwner);
    }
    public LiveData<List<String>> getAllLanguagesInEnglish() {
        return webAppRepository.getAllLanguagesInEnglish();
    }

    public LiveData<List<WebApp>> getAllWebApps() {
        return webAppRepository.getAllWebApps(lifecycleOwner);
    }

    public void getUpdatedAppManifest(String manifestVersion) {
        webAppRepository.getUpdatedAppManifest(manifestVersion);
    }
}
