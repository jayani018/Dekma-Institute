package lk.ijse.StudentMS.model;

public class PaymentsDTO {
    private String SID;
    private String CarID;
    private String amount;
    private String payment_months;
    private String time;
    private String date;

    public PaymentsDTO() {
    }

    public PaymentsDTO(String SID, String carID, String amount, String payment_months, String time, String date) {
        this.SID = SID;
        this.CarID = carID;
        this.amount = amount;
        this.payment_months = payment_months;
        this.time = time;
        this.date = date;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getCarID() {
        return CarID;
    }

    public void setCarID(String carID) {
        CarID = carID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment_months() {
        return payment_months;
    }

    public void setPayment_months(String payment_months) {
        this.payment_months = payment_months;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "PaymentsDTO{" +
                "SID='" + SID + '\'' +
                ", CarID='" + CarID + '\'' +
                ", amount='" + amount + '\'' +
                ", payment_months='" + payment_months + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}