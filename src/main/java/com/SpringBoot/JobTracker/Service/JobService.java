package com.SpringBoot.JobTracker.Service;

import java.util.List;

import com.SpringBoot.JobTracker.Enums.JobStatus;
import com.SpringBoot.JobTracker.Model.JobApplication;

public interface JobService {
    List<JobApplication> getJobs(String username, String company, JobStatus status);
    void save(JobApplication job, String username);
    void delete(Long id);
    JobApplication getById(Long id);
}