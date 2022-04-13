package ls.hvacaretaker.job;

/**
 * Klasa enum rodzaju czynności serwisowej
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
public enum JobType {
    /**
     * Kontrola szczelności
     */
    HERMETICTEST("Kontrola szczelności"),
    /**
     * Prace serwisowe
     */
    SERVICEJOB("Praca serwisowa");

    private final String jobName;

    JobType(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Gets job name.
     *
     * @return the job name
     */
    public String getJobName() {
        return jobName;
    }
}
