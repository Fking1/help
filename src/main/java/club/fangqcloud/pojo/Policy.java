package club.fangqcloud.pojo;

import java.util.Date;

public class Policy {
    private String policyId; //保单号

    private String companyId; //公司号

    private String openid1; //投保人openid

    private String openid2; //被保人openid

    private String policyState; //保单状态

    private String policyType; //保单类型  独立、分离

    private String paymentType;//付费方式 月缴，年缴

    private Integer policyLevel;//保险档次

    private String name1;//投保人姓名

    private String name2;//被保人姓名

    private String description; //保单申明
    
    private Date effectiveDate; //生效日期
    
    private Date continueDate; //续费日期

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getOpenid1() {
        return openid1;
    }

    public void setOpenid1(String openid1) {
        this.openid1 = openid1;
    }

    public String getOpenid2() {
        return openid2;
    }

    public void setOpenid2(String openid2) {
        this.openid2 = openid2;
    }

    public String getPolicyState() {
        return policyState;
    }

    public void setPolicyState(String policyState) {
        this.policyState = policyState;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPolicyLevel() {
        return policyLevel;
    }

    public void setPolicyLevel(Integer policyLevel) {
        this.policyLevel = policyLevel;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getEffectiveDate() {
        return effectiveDate;
    }
    
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    
    public Date getContinueDate() {
        return continueDate;
    }
    
    public void setContinueDate(Date continueDate) {
        this.continueDate = continueDate;
    }
}