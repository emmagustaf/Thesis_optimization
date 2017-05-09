import java.util.Date;

public class Disposal {

    private String logId, inletAddress;
    private Date logDate;

    public Disposal(String logId, Date logDate, String inletAddress){
        this.logDate = logDate;
        this.logId = logId;
        this.inletAddress = inletAddress;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getInletAddress() {
        return inletAddress;
    }

    public void setInletAddress(String inletAddress) {
        this.inletAddress = inletAddress;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }
}
