package com.deceptiveb.workie.specification;

import com.deceptiveb.workie.model.Industry;
import org.springframework.data.jpa.domain.Specification;

public class IndustrySpecification {
    public static Specification<Industry> filterByName(String name) {
        return (root, query, cb) -> {
            if (name == null || name.isBlank()) {
                return cb.conjunction();
            }

            return cb.like(
                    cb.lower(root.get("name")),
                    "%" + name.toLowerCase() + "%"
            );
        };
    }
}
