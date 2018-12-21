package club.fangqcloud.pojo;

public class Worker extends Person{

    private String serviceState;

    private Integer monthServiceHours;

    private Integer wholeServiceHours;
    
   

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public Integer getMonthServiceHours() {
        return monthServiceHours;
    }

    public void setMonthServiceHours(Integer monthServiceHours) {
        this.monthServiceHours = monthServiceHours;
    }

    public Integer getWholeServiceHours() {
        return wholeServiceHours;
    }

    public void setWholeServiceHours(Integer wholeServiceHours) {
        this.wholeServiceHours = wholeServiceHours;
    }
    
}