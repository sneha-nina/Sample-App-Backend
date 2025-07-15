package com.silicon.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silicon.management.model.Staff;
import com.silicon.management.service.StaffService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Staff API", description = "Operations related to staff management")
@RestController
@RequestMapping("/staffs")
public class StaffController {

    @Autowired // dependency injection
    StaffService staffService;

    public StaffController() {
        System.out.println("StaffController initialized");
    }

    /**
     * This method is for adding a staff member
     * 
     * @param staff
     * @return
     */
    @PostMapping("/addStaff")
    public String addStaff(@RequestBody Staff staff) {
        try {
            System.out.println("Received: " + staff);
            staffService.addStaff(staff);
            return "Staff Added Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }

    /**
     * This method is for fetching all staff members
     * 
     * @return
     */
    @GetMapping("/getAllStaff")
    public List<Staff> getStaffs() {
        return staffService.fetchStaff();
    }

    /**
     * This method is for updating a staff member by ID
     * 
     * @param id
     * @param staff
     * @return
     */
    @PutMapping("/updateStaff/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable Long id, @Valid @RequestBody Staff staff) {
        staffService.updateStaff(id, staff);
        return ResponseEntity.ok("Staff updated successfully!");
    }

    /**
     * This method is for deleting a staff member by ID
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/deleteStaff/{id}")
    public String deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return "Staff Deleted Successfully!!!";
    }
}
