package com.silicon.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicon.management.model.Staff;
import com.silicon.management.repository.StaffRepo;
import com.silicon.management.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffRepo staffRepository;

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public List<Staff> fetchStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public void updateStaff(Long id, Staff updatedStaff) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) {
            Staff existingStaff = optionalStaff.get();
            existingStaff.setName(updatedStaff.getName());
            existingStaff.setAge(updatedStaff.getAge());
            existingStaff.setEmail(updatedStaff.getEmail());
            staffRepository.save(existingStaff);
        } else {
            throw new RuntimeException("Staff not found with id: " + id);
        }
    }

    @Override
    public void deleteStaff(Long id) {
        if (staffRepository.existsById(id)) {
            staffRepository.deleteById(id);
        } else {
            throw new RuntimeException("Staff not found with id: " + id);
        }
    }

    // Additional methods from interface - stubs or implementations

//    @Override
//    public int getAgeByName(String name) {
//        Staff staff = staffRepository.findByName(name);
//        if (staff != null) {
//            return staff.getAge();
//        } else {
//            throw new RuntimeException("Staff not found with name: " + name);
//        }
//    }
//
//    @Override
//    public Staff updateEmailById(Long id, String newEmail) {
//        Optional<Staff> optionalStaff = staffRepository.findById(id);
//        if (optionalStaff.isPresent()) {
//            Staff existingStaff = optionalStaff.get();
//            existingStaff.setEmail(newEmail);
//            return staffRepository.save(existingStaff);
//        } else {
//            throw new RuntimeException("Staff not found with id: " + id);
//        }
//    }
//
//    @Override
//    public long countStaff() {
//        return staffRepository.count();
//    }
//
//    @Override
//    public boolean existsByName(String name) {
//        return staffRepository.existsByName(name);
//    }
//
//    @Override
//    public List<Staff> getStaffByAge(int age) {
//        return staffRepository.findByAge(age);
//    }
//
//    @Override
//    public List<Staff> getStaffByEmailDomain(String domain) {
//        return staffRepository.findByEmailEndingWith(domain);
//    }

    @Override
    public Staff updateNameById(Long id, String newName) {
        Optional<Staff> optionalStaff = staffRepository.findById(id);
        if (optionalStaff.isPresent()) {
            Staff existingStaff = optionalStaff.get();
            existingStaff.setName(newName);
            return staffRepository.save(existingStaff);
        } else {
            throw new RuntimeException("Staff not found with id: " + id);
        }
    }

    @Override
    public void deleteAllStaff() {
        staffRepository.deleteAll();
    }

	@Override
	public int getAgeByName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Staff updateEmailById(Long id, String newEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countStaff() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Staff> getStaffByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Staff> getStaffByEmailDomain(String domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllStaffNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
