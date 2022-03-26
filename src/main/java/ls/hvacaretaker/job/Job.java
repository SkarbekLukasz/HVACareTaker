package ls.hvacaretaker.job;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "job_type")
    private JobType jobType;
    @Column(length = 1024, name = "job_description")
    private String jobDescription;
    @Column(name = "add_time")
    private LocalDate jobAddTime;
    private String author;
    @Column(name = "end_time")
    private LocalDate jobEndTime;
    @ManyToOne
    @JoinColumn(name = "device_id")
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
