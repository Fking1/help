package club.fangqcloud.pojo;

public class Banner {
    private int banner_id;
    private String banner_title;
    private String banner_url;

    @Override
    public String toString() {
        return "Banner{" +
                "banner_id=" + banner_id +
                ", banner_title='" + banner_title + '\'' +
                ", banner_url='" + banner_url + '\'' +
                '}';
    }

    public int getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(int banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }
}
