package ls.hvacaretaker.job;

import ls.hvacaretaker.device.Device;


import java.time.LocalDate;

/**
 * Obiekt DTO typu Job
 */
public class JobDto {

    private Long id;
    private JobType jobType;
    private String jobDescription;
    private LocalDate jobAddTime;
    private String author;
    private LocalDate jobEndTime;
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
