package ls.hvacaretaker.job;

import ls.hvacaretaker.device.Device;


import java.time.LocalDate;

public class JobDto {

    private Long id;
    private JobType jobType;
    private String jobDescription;
    private LocalDate jobAddTime;
    private String author;
    private LocalDate jobEndTime;
    private Device device;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public LocalDate getJobAddTime() {
        return jobAddTime;
    }

    public void setJobAddTime(LocalDate jobAddTime) {
        this.jobAddTime = jobAddTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getJobEndTime() {
        return jobEndTime;
    }

    public void setJobEndTime(LocalDate jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
