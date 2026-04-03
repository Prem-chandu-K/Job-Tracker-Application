package com.SpringBoot.JobTracker.Controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot.JobTracker.Enums.JobStatus;
import com.SpringBoot.JobTracker.Model.JobApplication;
import com.SpringBoot.JobTracker.Model.User;
import com.SpringBoot.JobTracker.Repository.JobApplicationRepository;
import com.SpringBoot.JobTracker.Repository.UserRepository;

@Controller
@RequestMapping("/jobs")
public class JobApplicationController {

    private final JobApplicationRepository jobRepo;
    private final UserRepository userRepo;

    public JobApplicationController(JobApplicationRepository jobRepo, UserRepository userRepo) {
        this.jobRepo = jobRepo;
        this.userRepo = userRepo;
    }

    // 👉 Show Add Form
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("job", new JobApplication());
        model.addAttribute("statuses", JobStatus.values());
        return "add-job";
    }

    // 👉 Save Job (USER LINKED 🔐)
    @PostMapping
    public String saveJob(@ModelAttribute JobApplication job, Principal principal) {

        String username = principal.getName();

        User user = userRepo.findByUsername(username).orElseThrow();

        job.setUser(user); // 🔥 link job to logged user

        if (job.getAppliedDate() == null) {
            job.setAppliedDate(LocalDate.now());
        }

        if (job.getStatus() == JobStatus.INTERVIEW && job.getInterviewDate() == null) {
            job.setInterviewDate(LocalDate.now());
        }

        jobRepo.save(job); // ✅ FIXED

        return "redirect:/jobs";
    }

    // 👉 Delete
    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobRepo.deleteById(id);
        return "redirect:/jobs";
    }

    // 👉 Edit Form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        JobApplication job = jobRepo.findById(id).orElseThrow();
        model.addAttribute("job", job);
        model.addAttribute("statuses", JobStatus.values());
        return "edit-job";
    }

    // 👉 Update
    @PostMapping("/update/{id}")
    public String updateJob(@PathVariable Long id,
                           @ModelAttribute JobApplication job,
                           Principal principal) {

        String username = principal.getName();
        User user = userRepo.findByUsername(username).orElseThrow();

        job.setId(id);
        job.setUser(user);

        if (job.getStatus() == JobStatus.INTERVIEW && job.getInterviewDate() == null) {
            job.setInterviewDate(LocalDate.now());
        }

        jobRepo.save(job);

        return "redirect:/jobs";
    }

    // 👉 LIST (USER-SPECIFIC 🔥)
    @GetMapping
    public String listJobs(
            @RequestParam(required = false) String company,
            @RequestParam(required = false) JobStatus status,
            Model model,
            Principal principal) {

        String username = principal.getName();
        List<JobApplication> jobs;

        if (company != null && !company.isBlank() && status != null) {
            jobs = jobRepo.findByUserUsernameAndCompanyNameContainingIgnoreCaseAndStatus(username, company, status);
        } else if (company != null && !company.isBlank()) {
            jobs = jobRepo.findByUserUsernameAndCompanyNameContainingIgnoreCase(username, company);
        } else if (status != null) {
            jobs = jobRepo.findByUserUsernameAndStatus(username, status);
        } else {
            jobs = jobRepo.findByUserUsername(username);
        }

        model.addAttribute("jobs", jobs);
        model.addAttribute("company", company);
        model.addAttribute("statuses", JobStatus.values());
        model.addAttribute("selectedStatus", status);

        return "jobs";
    }
}