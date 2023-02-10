package lk.ijse.StudentMS.view.tdm;

public class SubjectTM {
    private String SUBID;
    private String SubName;

    public SubjectTM() {
    }

    public SubjectTM(String SUBID, String subName) {
        this.SUBID = SUBID;
        SubName = subName;
    }

    public String getSUBID() {
        return SUBID;
    }

    public void setSUBID(String SUBID) {
        this.SUBID = SUBID;
    }

    public String getSubName() {
        return SubName;
    }

    public void setSubName(String subName) {
        SubName = subName;
    }

    @Override
    public String toString() {
        return "SubjectTM{" +
                "SUBID='" + SUBID + '\'' +
                ", SubName='" + SubName + '\'' +
                '}';
    }
}
