
package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Admin;

public interface IAdmin extends JpaRepository<Admin, String> {

}