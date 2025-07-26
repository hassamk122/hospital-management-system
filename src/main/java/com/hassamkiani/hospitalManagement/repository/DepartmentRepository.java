package com.hassamkiani.hospitalManagement.repository;

import com.hassamkiani.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
