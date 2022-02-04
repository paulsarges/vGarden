package vgarden.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import vgarden.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{

}
