package com.springboot.api.repository;

import com.springboot.api.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film, Long>, JpaRepository<Film, Long> {
    // all crud database methods

//    List<User> pagination(int offset,int pageSize);
//    @GetMapping("/pagination/{offset}/{pageSize}")
//    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
//        Page<Product> productsWithPagination = service.findProductsWithPagination(offset, pageSize);
//        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
//    }
}
