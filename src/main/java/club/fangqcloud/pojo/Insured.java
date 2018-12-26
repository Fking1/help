package club.fangqcloud.pojo;

import java.util.List;

public class Insured extends Person{
    private List<Policy> policyList;
    
    public List<Policy> getPolicyList() {
        return policyList;
    }
    
    public void setPolicyList(List<Policy> policyList) {
        this.policyList = policyList;
    }
    
    @Override
    public String toString() {
        return "Insured{" +
                "policyList=" + policyList +
                '}';
    }
}