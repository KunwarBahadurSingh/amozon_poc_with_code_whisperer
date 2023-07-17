package com.persistent.leavesystem.repository;
//create Repository interface for EmployeePlannedLeaves
import com.persistent.leavesystem.entity.EmployeePlannedLeaves;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EmployeePlannedLeavesRepository extends JpaRepository<EmployeePlannedLeaves,Integer> {
    // fetch planned leaves of employee by employee email id
    List<EmployeePlannedLeaves> findByEmployeeEmailId(String findByEmployeeEmailId);
}
