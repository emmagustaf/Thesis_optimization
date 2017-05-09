import java.time.LocalDateTime;
import java.util.Date;

public class Disposal {

    private String logId, inletAddress;
    private LocalDateTime logDate;

    public Disposal(String logId, LocalDateTime logDate, String inletAddress){
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

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
    }
}
