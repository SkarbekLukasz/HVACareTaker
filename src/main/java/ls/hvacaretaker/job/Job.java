package ls.hvacaretaker.job;

import ls.hvacaretaker.device.Device;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Encja obiektu Job
 *
 * Reprezentuje wykonaną czynność serwisową.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets job type.
     *
     * @return the job type
     */
    public JobType getJobType() {
        return jobType;
    }

    /**
     * Sets job type.
     *
     * @param jobType the job type
     */
    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    /**
     * Gets job description.
     *
     * @return the job description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * Sets job description.
     *
     * @param jobDescription the job description
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * Gets job add time.
     *
     * @return the job add time
     */
    public LocalDate getJobAddTime() {
        return jobAddTime;
    }

    /**
     * Sets job add time.
     *
     * @param jobAddTime the job add time
     */
    public void setJobAddTime(LocalDate jobAddTime) {
        this.jobAddTime = jobAddTime;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets job end time.
     *
     * @return the job end time
     */
    public LocalDate getJobEndTime() {
        return jobEndTime;
    }

    /**
     * Sets job end time.
     *
     * @param jobEndTime the job end time
     */
    public void setJobEndTime(LocalDate jobEndTime) {
        this.jobEndTime = jobEndTime;
    }

    /**
     * Gets device.
     *
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * Sets device.
     *
     * @param device the device
     */
    public void setDevice(Device device) {
        this.device = device;
    }
}
