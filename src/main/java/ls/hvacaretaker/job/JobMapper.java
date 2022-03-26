package ls.hvacaretaker.job;

import org.springframework.stereotype.Service;

@Service
public class JobMapper {

    public JobDto toDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setJobType(job.getJobType());
        jobDto.setAuthor(job.getAuthor());
        jobDto.setJobDescription(job.getJobDescription());
        jobDto.setJobAddTime(job.getJobAddTime());
        jobDto.setJobEndTime(job.getJobEndTime());
        jobDto.setDevice(job.getDevice());
        return jobDto;
    }

    public Job toEntity(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setJobType(jobDto.getJobType());
        job.setAuthor(jobDto.getAuthor());
        job.setJobDescription(jobDto.getJobDescription());
        job.setJobAddTime(jobDto.getJobAddTime());
        job.setJobEndTime(jobDto.getJobEndTime());
        job.setDevice(jobDto.getDevice());
        return job;
    }
}
