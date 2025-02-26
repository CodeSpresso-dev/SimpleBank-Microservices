package mehdi.sample.microservices.samplebank.accounts.mapper;

import mehdi.sample.microservices.samplebank.accounts.dto.AccountsDto;
import mehdi.sample.microservices.samplebank.accounts.entity.Accounts;
import org.springframework.beans.BeanUtils;

public class AccountsMapper {
    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
//        accountsDto.setAccountNumber(accounts.getAccountNumber());
//        accountsDto.setAccountType(accounts.getAccountType());
//        accountsDto.setBranchAddress(accounts.getBranchAddress());
        BeanUtils.copyProperties(accounts, accountsDto);
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
//        accounts.setAccountNumber(accountsDto.getAccountNumber());
//        accounts.setAccountType(accountsDto.getAccountType());
//        accounts.setBranchAddress(accountsDto.getBranchAddress());
        BeanUtils.copyProperties(accountsDto, accounts);
        return accounts;
    }
}
