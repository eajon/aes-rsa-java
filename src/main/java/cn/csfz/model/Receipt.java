package cn.csfz.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.Date;

public class Receipt {


    private String bankBusinessId;

    private String bankCode;

    private String bankName;

    private BigDecimal amount;

    private String curr;

    private String payerName;

    private String payerCountryCode;

    private String payerCountryName;

    private Integer isPrivate;

    private String payeeForexAccount;

    private String payeeName;

    private String payeeCode;


    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date receiptDate;

    private Integer isConfirm;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date confirmDate;

    private String confirmRemark;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date rejectDate;

    private String rejectRemark;


    private String foreignIncomeNumber;

    public String getBankBusinessId() {
        return bankBusinessId;
    }

    public void setBankBusinessId(String bankBusinessId) {
        this.bankBusinessId = bankBusinessId;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerCountryCode() {
        return payerCountryCode;
    }

    public void setPayerCountryCode(String payerCountryCode) {
        this.payerCountryCode = payerCountryCode;
    }

    public String getPayerCountryName() {
        return payerCountryName;
    }

    public void setPayerCountryName(String payerCountryName) {
        this.payerCountryName = payerCountryName;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getPayeeForexAccount() {
        return payeeForexAccount;
    }

    public void setPayeeForexAccount(String payeeForexAccount) {
        this.payeeForexAccount = payeeForexAccount;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeCode() {
        return payeeCode;
    }

    public void setPayeeCode(String payeeCode) {
        this.payeeCode = payeeCode;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Integer getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Integer isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getForeignIncomeNumber() {
        return foreignIncomeNumber;
    }

    public void setForeignIncomeNumber(String foreignIncomeNumber) {
        this.foreignIncomeNumber = foreignIncomeNumber;
    }

    public String getConfirmRemark() {
        return confirmRemark;
    }

    public void setConfirmRemark(String confirmRemark) {
        this.confirmRemark = confirmRemark;
    }

    public Date getRejectDate() {
        return rejectDate;
    }

    public void setRejectDate(Date rejectDate) {
        this.rejectDate = rejectDate;
    }

    public String getRejectRemark() {
        return rejectRemark;
    }

    public void setRejectRemark(String rejectRemark) {
        this.rejectRemark = rejectRemark;
    }
}
