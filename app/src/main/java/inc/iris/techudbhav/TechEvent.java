package inc.iris.techudbhav;

/**
 * Created by Sud on 2/28/18.
 */

public class TechEvent {
    public static final String EVENT_NAME = "NAME";
    public static final String EVENT_PRIZE = "PRIZE";
    public static final String EVENT_IMG = "IMG";
    private String name;
    private String prize;
    private int imgRes;
    private String about;
    private String regLink;
    private String classname;

    public TechEvent(String name, String prize, int imgRes,String classname) {
        this.name = name;
        this.prize = prize;
        this.imgRes = imgRes;
        this.classname=classname;
    }


    public TechEvent(String name, String prize, int imgRes, String about, String regLink) {
        this.name = name;
        this.prize = prize;
        this.imgRes = imgRes;
        this.about = about;
        this.regLink = regLink;
    }

    public String getClassname() {
        return classname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRegLink() {
        return regLink;
    }

    public void setRegLink(String regLink) {
        this.regLink = regLink;
    }
}
