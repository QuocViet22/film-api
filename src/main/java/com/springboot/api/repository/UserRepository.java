package com.springboot.api.repository;

import com.springboot.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends
        PagingAndSortingRepository<User, Long>,
        JpaRepository<User, Long> {
    // all crud database methods
    List<User> findByType(String type);

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

//    List<User> pagination(int offset,int pageSize);
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
//        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }
}
