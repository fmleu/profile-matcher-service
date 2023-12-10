package com.profile.matcher.service.repository;

import com.profile.matcher.service.model.Profile;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Long> {

    @NonNull
    @Override
    Optional<Profile> findById(@NonNull Long id);
}
