package ism.inscriptions.repositories;

import ism.inscriptions.entities.User;

public interface IUserRepository {
    public User findLoginAndPassword(String login,String password);
}
