package com.farukdegerli.kfkProjesi.SearchPackage;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SearchSpec<Customer> implements Specification<Customer> {

    private List<SearchCriteria> list;

    public SearchSpec() {
        this.list = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {

        list.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : list) {
            predicates.add(builder.like(
                    builder.lower(root.get(criteria.getKey())),
                    "%" + criteria.getValue().toString().toLowerCase() + "%"));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}
