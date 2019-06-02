package com.example.zemikone.retrofit.Interface;

import com.example.zemikone.retrofit.Model.ApiResponse;

public interface DataResultInterface {

    void dataReceived(ApiResponse apiResponse);
    void dataFailed();

}
