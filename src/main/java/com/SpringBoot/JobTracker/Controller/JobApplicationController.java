package com.SpringBoot.JobTracker.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.JobTracker.Enums.JobStatus;
import com.SpringBoot.JobTracker.Model.JobApplication;
import com.SpringBoot.JobTracker.Repository.JobApplicationRepository;

@Controller
@RequestMapping("/jobs")
public class JobApplicationController {

    private final JobApplicationRepository repository;

    public JobApplicationController(JobApplicationRepository repository) {
        this.repository = repository;
    }

    // Show add job form
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("job", new JobApplication());
        model.addAttribute("statuses", JobStatus.values());
        return "add-job";
    }

    @PostMapping
    public String saveJob(@ModelAttribute JobApplication job) {

        // Set appliedDate to today if not provided
        if (job.getAppliedDate() == null) {
            job.setAppliedDate(LocalDate.now());
        }

        // Business rule: if INTERVIEW → interview date required
        if (job.getStatus() == JobStatus.INTERVIEW && job.getInterviewDate() == null) {
            job.setInterviewDate(LocalDate.now());
        }

        repository.save(job);
        return "redirect:/jobs";
    }

    // Delete job
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/jobs";
    }
    
    //edit job form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        JobApplication job = repository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("Invalid Job ID: " + id));
        model.addAttribute("job", job);
        model.addAttribute("statuses", JobStatus.values());
        return "edit-job";
    }

    //Update job
    @PostMapping("/update/{id}")
    public String updateJob(@PathVariable Long id, @ModelAttribute JobApplication job) {

        if (job.getStatus() == JobStatus.INTERVIEW && job.getInterviewDate() == null) {
            job.setInterviewDate(LocalDate.now());
        }

        job.setId(id);
        repository.save(job);
        return "redirect:/jobs";
    }
    
    @GetMapping
    public String listJobs(
            @RequestParam(required = false) String company,
            @RequestParam(required = false) JobStatus status,
            Model model) {

        List<JobApplication> jobs;

        if (company != null && !company.isBlank() && status != null) {
            jobs = repository
                .findByCompanyNameContainingIgnoreCaseAndStatus(company, status);
        } 
        else if (company != null && !company.isBlank()) {
            jobs = repository.findByCompanyNameContainingIgnoreCase(company);
        } 
        else if (status != null) {
            jobs = repository.findByStatus(status);
        } 
        else {
            jobs = repository.findAll();
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("company", company);
        model.addAttribute("statuses", JobStatus.values());
        model.addAttribute("selectedStatus", status);

        return "jobs";
    }




}
