package com.Finance.BankingApplication.Shared;

/**
 * @author Wayne Sidney
 * Created on {10/05/2022}
 */
public class SaveResponse {


    private boolean saved;
    private String error;

    public SaveResponse() {
    }

    public SaveResponse(boolean saved, String error) {
        this.saved = saved;
        this.error = error;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

