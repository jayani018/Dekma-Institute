package lk.ijse.StudentMS.model;

public class ResultDTO {
    private  String TID;
    private String SID;
    private String SUBID;
    private String result;

    public ResultDTO(String text, Object value, Object combSubIdValue, String txtResultText) {
    }

    public ResultDTO(String TID ,String SID, String SUBID, String result) {
        this.TID = TID;
        this.SID = SID;
        this.SUBID = SUBID;
        this.result = result;
    }

    public String getTID() {
        return TID;
    }

    public void setTID(String TID) {
        this.TID = TID;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getSUBID() {
        return SUBID;
    }

    public void setSUBID(String SUBID) {
        this.SUBID = SUBID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
