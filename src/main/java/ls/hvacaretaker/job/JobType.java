package ls.hvacaretaker.job;

public enum JobType {
    HERMETICTEST("Kontrola szczelności"),
    SERVICEJOB("Praca serwisowa");

    private final String jobName;

    JobType(String jobName) {
        this.jobName = jobName;
    }

    public String getJobName() {
        return jobName;
    }
}
