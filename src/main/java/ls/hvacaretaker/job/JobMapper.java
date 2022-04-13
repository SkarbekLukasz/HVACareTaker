package ls.hvacaretaker.job;

import org.springframework.stereotype.Service;

/**
 * Klasa mapująca encje do obiektów DTO i na odwrót.
 *
 * @author Luke
 * @version 1.0
 * @since 1.0
 */
@Service
public class JobMapper {

    /**
     * Metoda zamieniająca obiekt encji do obiektu DTO
     *
     * @param job obiekt typu Job
     * @return jobDto obiekt typu JobDto
     */
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

    /**
     * Zamienia obiekt typu DeviceDto na obiekt encji.
     *
     * @param jobDto obiekt typu JobDto
     * @return job obiekt typu Job
     */
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
