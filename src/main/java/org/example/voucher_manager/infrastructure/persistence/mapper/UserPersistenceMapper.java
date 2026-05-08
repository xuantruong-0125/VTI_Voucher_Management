package org.example.voucher_manager.infrastructure.persistence.mapper;

import org.example.voucher_manager.domain.entity.User;
import org.example.voucher_manager.infrastructure.persistence.entity.UserJpaEntity;

public class UserPersistenceMapper {

    private UserPersistenceMapper() {
    }

    public static User toDomain(UserJpaEntity entity) {

        User user = new User();

        user.setId(entity.getId());
        user.setFullName(entity.getFullName());
        user.setEmail(entity.getEmail());
        user.setPhone(entity.getPhone());
        user.setCreatedAt(entity.getCreatedAt());

        return user;
    }

    public static UserJpaEntity toPersistence(User user) {

        UserJpaEntity entity = new UserJpaEntity();

        entity.setId(user.getId());
        entity.setFullName(user.getFullName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setCreatedAt(user.getCreatedAt());

        return entity;
    }
}