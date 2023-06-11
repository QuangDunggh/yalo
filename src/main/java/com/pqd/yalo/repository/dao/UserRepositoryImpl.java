package com.pqd.yalo.repository.dao;

import com.pqd.yalo.domain.request.UserRequest;
import com.pqd.yalo.domain.response.UserResponse;
import com.pqd.yalo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl {

    private final EntityManager em;

    public List<User> searchUserSimpleCriteria(UserRequest userRequest) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        // select * from table
        Root<User> root = criteriaQuery.from(User.class);

        // prepare clause
        Predicate fullNamePredicate = criteriaBuilder
                .like(root.get("fullName"), "%" + userRequest.getFullName() + "%");

        criteriaQuery.where(fullNamePredicate);
        TypedQuery<User> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
