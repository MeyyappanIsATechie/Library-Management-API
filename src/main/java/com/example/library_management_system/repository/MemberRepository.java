package com.example.library_management_system.repository;

import com.example.library_management_system.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
