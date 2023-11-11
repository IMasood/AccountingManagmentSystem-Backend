package com.example.accountingmanagementsystem.repos;

import com.example.accountingmanagementsystem.entities.ChartOfAccount;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class ChartOfAccountFilterSpecification {
        public static Specification<ChartOfAccount> withFilters(Long masterAccount, Long creditCode) {
            return (root, query, criteriaBuilder) -> {
                // Initialize a predicate with a true condition (no filtering)
                Predicate predicate = criteriaBuilder.conjunction();

                // Add conditions based on the provided parameters
                if (masterAccount != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("masterAccount"), masterAccount));
                }

                if (creditCode != null) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("creditCode"), creditCode));
                }

                // Add more conditions for additional fields as needed

                return predicate;
            };
    }
}
