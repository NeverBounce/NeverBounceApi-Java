package com.neverbounce.api.model;

import com.google.api.client.util.Key;

import java.util.Set;

/**
 * https://developers.neverbounce.com/v4.0/reference#single-check
 *
 * @author Laszlo Csontos
 * @since 4.0.0
 */
public class SingleCheckResponse extends BaseResponse {

    @Key
    private Result result;

    @Key
    private Set<Flag> flags;

    @Key("suggested_correction")
    private String suggestedCorrection;

    @Key("retry_token")
    private String retryToken;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Set<Flag> getFlags() {
        return flags;
    }

    public void setFlags(Set<Flag> flags) {
        this.flags = flags;
    }

    public String getSuggestedCorrection() {
        return suggestedCorrection;
    }

    public void setSuggestedCorrection(String suggestedCorrection) {
        this.suggestedCorrection = suggestedCorrection;
    }

    public String getRetryToken() {
        return retryToken;
    }

    public void setRetryToken(String retryToken) {
        this.retryToken = retryToken;
    }

}
