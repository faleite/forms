package faleite.xyz.back_form;

import org.springframework.stereotype.Service;

@Service
public class UserDataService {

    private final UserDataRepository repository;

    public UserDataService(UserDataRepository repository) {
        this.repository = repository;
    }

    public UserData saveUserData(UserData userData) {
        return repository.save(userData);
    }
}
