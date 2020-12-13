package cn.csfz.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class PushExchange {
    private String tenantId;
    private String bankCode;
    private String bankName;
    private String organCode;
    private String serialNo;
    private String cnyAccount;
    private String ForexAccount;
    private String curr;
    private String amount;
    private String tradeRate;
    private String exgUSDAmount;
    private String discountRate;
    private String currentRate;
    private String rmbAmount;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date tradeDate;


    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCnyAccount() {
        return cnyAccount;
    }

    public void setCnyAccount(String cnyAccount) {
        this.cnyAccount = cnyAccount;
    }

    public String getForexAccount() {
        return ForexAccount;
    }

    public void setForexAccount(String forexAccount) {
        ForexAccount = forexAccount;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTradeRate() {
        return tradeRate;
    }

    public void setTradeRate(String tradeRate) {
        this.tradeRate = tradeRate;
    }

    public String getExgUSDAmount() {
        return exgUSDAmount;
    }

    public void setExgUSDAmount(String exgUSDAmount) {
        this.exgUSDAmount = exgUSDAmount;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(String currentRate) {
        this.currentRate = currentRate;
    }

    public String getRmbAmount() {
        return rmbAmount;
    }

    public void setRmbAmount(String rmbAmount) {
        this.rmbAmount = rmbAmount;
    }

    public Date getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }
}
