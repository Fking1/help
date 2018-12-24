package club.fangqcloud.pojo;

import java.util.List;

public class Person {
    private String openid; //openid

    private String id; //身份证号

    private String name; //姓名

    private String sex; //性别

    private String code; //邮编

    private String address; //地址

    private String telephone; //电话号码

    private String healthState; //健康状况

    private String avatarUrl; //头像地址
    
    private String personType; //人员类型
    
    private List<Task> taskList;//任务列表

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getHealthState() {
        return healthState;
    }

    public void setHealthState(String healthState) {
        this.healthState = healthState;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
    
    public String getPersonType() {
        return personType;
    }
    
    public void setPersonType(String personType) {
        this.personType = personType;
    }
    
    public List<Task> getTaskList() {
        return taskList;
    }
    
    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "openid='" + openid + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", healthState='" + healthState + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", personType='" + personType + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}