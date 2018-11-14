package uk.co.ybs.App.service.accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import uk.co.ybs.App.domain.in_memory_entities.Account;

@Service
public class AccountService {

  Map<Long, Account> database = new HashMap<Long, Account>();

  public Account findById(Long id) {
    return database.get(id);
  }

  public List<Account> getAll() {
    return new ArrayList<Account>(database.values());
  }

  public void createAccount(Account account) {
    database.put(account.getId(), account);
  }

  public void updateAccount(Account updatedAccount) {
    Account accountToBeUpdated = database.get(updatedAccount.getId());
    accountToBeUpdated.setName(updatedAccount.getName());
    accountToBeUpdated.setEmail(updatedAccount.getEmail());
  }

  /**
   * Delete operation.
   */
  public void deleteAccount(Long id) {
    database.remove(id);
  }
}
