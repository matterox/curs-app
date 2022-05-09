package com.publishing.curs.ui.contact;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.publishing.curs.ui.base.BaseViewModel;

public class ContactViewModel extends BaseViewModel {

    private final MutableLiveData<Boolean> messageSentLiveData;

    public ContactViewModel() {
        messageSentLiveData = new MutableLiveData<>();
    }

    public void sendMessage(String name, String email, String message) {
        if (!name.isEmpty() && !email.isEmpty() && !message.isEmpty()) {
            messageSentLiveData.setValue(true);
        } else {
            messageSentLiveData.setValue(false);
        }
    }

    public LiveData<Boolean> getMessageSent() {
        return messageSentLiveData;
    }
}
