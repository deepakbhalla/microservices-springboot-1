package uk.co.ybs.App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uk.co.ybs.App.domain.in_memory_entities.Account;
import uk.co.ybs.App.service.accounts.AccountService;

@RestController
public class AccountController {

  @Autowired
  AccountService accountService;

  /**
   * Test Operation.
   * 
   * @return Returns dummy account number.
   */
  @RequestMapping(value = "/test-account", method = RequestMethod.GET)
  public ResponseEntity<String> getTestAccountNumber() {
    return new ResponseEntity<String>("Dummy Test Account Number : " + 1234567890, HttpStatus.OK);
  }

  @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
  public ResponseEntity<Account> getAccountById(@PathVariable
  Long id) {
    return new ResponseEntity<Account>(accountService.findById(id), HttpStatus.OK);
  }

  @RequestMapping(value = "/accounts/", method = RequestMethod.GET)
  public ResponseEntity<List<Account>> getAccounts() {
    return new ResponseEntity<List<Account>>(accountService.getAll(), HttpStatus.OK);
  }

  @RequestMapping(value = "/accounts/", method = RequestMethod.POST)
  public ResponseEntity<String> createAccount(@RequestBody
  Account account) {
    accountService.createAccount(account);
    return new ResponseEntity<String>("Account created successfully for " + account.getName() + ", Id : " + account.getId(), HttpStatus.OK);
  }

  @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
  public ResponseEntity<String> updateAccount(@PathVariable
  Long id, @RequestBody
  Account updatedAccount) {
    if (accountService.findById(id) == null) {
      return new ResponseEntity<String>("Account not found", HttpStatus.NOT_FOUND);
    }
    else {
      accountService.updateAccount(updatedAccount);
      return new ResponseEntity<String>("Account updated successfully", HttpStatus.OK);
    }
  }

  @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteAccount(@PathVariable
  Long id) {
    if (accountService.findById(id) == null) {
      return new ResponseEntity<String>("Account not found", HttpStatus.NOT_FOUND);
    }
    else {
      accountService.deleteAccount(id);
      return new ResponseEntity<String>("Account deleted successfully", HttpStatus.OK);
    }
  }
}
