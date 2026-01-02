package com.SpringBoot.JobTracker.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.JobTracker.Enums.JobStatus;
import com.SpringBoot.JobTracker.Model.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long>{
	
	List<JobApplication> findByCompanyNameContainingIgnoreCase(String companyName);
	List<JobApplication> findByStatus(JobStatus status);
	List<JobApplication> findByCompanyNameContainingIgnoreCaseAndStatus(String company, JobStatus status);

	
}
