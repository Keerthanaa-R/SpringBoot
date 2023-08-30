
package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Account;

public interface IAccount extends JpaRepository<Account, Long> {

	Account findByAccountid(Long accountid);

}
