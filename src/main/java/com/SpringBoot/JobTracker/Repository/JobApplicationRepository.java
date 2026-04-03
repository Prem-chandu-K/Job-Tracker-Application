package com.SpringBoot.JobTracker.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.JobTracker.Enums.JobStatus;
import com.SpringBoot.JobTracker.Model.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByUserUsername(String username);

    List<JobApplication> findByUserUsernameAndCompanyNameContainingIgnoreCase(String username, String company);

    List<JobApplication> findByUserUsernameAndStatus(String username, JobStatus status);

    List<JobApplication> findByUserUsernameAndCompanyNameContainingIgnoreCaseAndStatus(
            String username, String company, JobStatus status);
}