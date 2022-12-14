package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Person;
import com.example.springsecurityapplication.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Находим продукты по части наименования без учета регистра
    List<Product> findByTitleContainingIgnoreCase(String name);

    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2 and price <= ?3)", nativeQuery = true)
    List<Product> findByTitleAndPriceGreaterThanEqualAndPriceLessThanEqual(String title, float ot, float Do);

    // Поиск по наименованию, фильтрация по диапазону цены, сортировка по возрастанию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2 and price <= ?3) order by  price", nativeQuery = true)
    List<Product> findByTitleOrderByPriceAsc(String title, float ot, float Do);

    // Поиск по наименованию, фильтрация по диапазону цены, сортировка по убыванию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2 and price <= ?3) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleOrderByPriceDest(String title, float ot, float Do);

    // Поиск по наименованию,по категории,  фильтрация по диапазону цены, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?4 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2 and price <= ?3) order by  price", nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByOtDoPriceAsc(String title, float ot, float Do, int category);

    // Поиск по наименованию,по категории,  фильтрация по диапазону цены, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?4 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2 and price <= ?3) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByOtDoPriceDesc(String title, float ot, float Do, int category);

////////////////////////// мои
////////////////////////// мои
////////////////////////// мои

    // Поиск по наименованию,по категории, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?4 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) order by  price", nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByPriceAsc(String title, float ot, float Do, int category);

    // Поиск по наименованию,по категории, фильтрация по диапазону цены, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?4 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndCategoryOrderByPriceDesc(String title, float ot, float Do, int category);

    ///////////----------------------
    ///////////----------------------
    ///////////----------------------

    // Поиск по категории, фильтрация от цены, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?2 and (price >= ?1) order by price", nativeQuery = true)
    List<Product> findByCategoryAndOtOrderByPriceAsc(float ot, int category);

    // Поиск по категории, фильтрация от цены, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?2 and (price >= ?1) order by  price desc ", nativeQuery = true)
    List<Product> findByCategoryAndOtOrderByPriceDesc(float ot, int category);

    // фильтрация от цены, сортировка по возрастанию цены
    @Query(value = "select * from product where (price >= ?1) order by price", nativeQuery = true)
    List<Product> findOtOrderByPriceAsc(float ot);

    // фильтрация от цены, сортировка по убыванию цены
    @Query(value = "select * from product where (price >= ?1) order by  price desc ", nativeQuery = true)
    List<Product> findOtOrderByPriceDesc(float ot);

    ///////////----------------------

    // Поиск по категории, фильтрация До цены, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?2 and (price <= ?1) order by price", nativeQuery = true)
    List<Product> findByCategoryAndDoOrderByPriceAsc(float Do, int category);

    // Поиск по категории, фильтрация До цены, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?2 and (price <= ?1) order by  price desc ", nativeQuery = true)
    List<Product> findByCategoryAndDoOrderByPriceDesc(float Do, int category);

    // фильтрация До цены, сортировка по возрастанию цены
    @Query(value = "select * from product where (price <= ?1) order by price", nativeQuery = true)
    List<Product> findDoOrderByPriceAsc(float Do);

    // фильтрация До цены, сортировка по убыванию цены
    @Query(value = "select * from product where (price <= ?1) order by  price desc ", nativeQuery = true)
    List<Product> findDoOrderByPriceDesc(float Do);

    ///////////----------------------

    // Поиск по категории, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?1 order by  price", nativeQuery = true)
    List<Product> findByCategoryOrderByPriceAsc(int category);

    // Поиск по категории, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?1 order by  price desc", nativeQuery = true)
    List<Product> findByCategoryOrderByPriceDesc(int category);

    // только сортировка по возрастанию цены
    @Query(value = "select * from product order by price", nativeQuery = true)
    List<Product> findOrderByPriceAsc();

    // только сортировка по убыванию цены
    @Query(value = "select * from product order by  price desc ", nativeQuery = true)
    List<Product> findOrderByPriceDesc();

    ///////////----------------------
    ///////////----------------------
    ///////////----------------------

    // Поиск по категории, фильтрация от цены
    @Query(value = "select * from product where category_id=?2 and (price >= ?1) order by price", nativeQuery = true)
    List<Product> findByCategoryAndOt(float ot, int category);

    // фильтрация от цены
    @Query(value = "select * from product where (price >= ?1) order by price", nativeQuery = true)
    List<Product> findOt(float ot);

    ///////////----------------------

    // Поиск по категории, фильтрация До цены
    @Query(value = "select * from product where category_id=?2 and (price <= ?1)", nativeQuery = true)
    List<Product> findByCategoryAndDo(float Do, int category);

    // фильтрация До цены
    @Query(value = "select * from product where (price <= ?1)", nativeQuery = true)
    List<Product> findDo(float Do);

    ///////////----------------------

    // Поиск по категории
    @Query(value = "select * from product where category_id=?1", nativeQuery = true)
    List<Product> findByCategory(int category);

    // все товары
    @Query(value = "select * from product", nativeQuery = true)
    List<Product> find();

    ///////////----------------------
    ///////////----------------------
    ///////////----------------------

    ///////////----------------------
    ///////////----------------------
    ///////////----------------------

    // Поиск по категории, фильтрация от цены, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?3 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2) order by price", nativeQuery = true)
    List<Product> findByTitleAndByCategoryAndOtOrderByPriceAsc(String title, float ot, int category);

    // Поиск по категории, фильтрация от цены, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?3 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndByCategoryAndOtOrderByPriceDesc(String title, float ot, int category);

    // фильтрация от цены, сортировка по возрастанию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2) order by price", nativeQuery = true)
    List<Product> findByTitleAndOtOrderByPriceAsc(String title, float ot);

    // фильтрация от цены, сортировка по убыванию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndOtOrderByPriceDesc(String title, float ot);

    ///////////----------------------

    // Поиск по категории, фильтрация До цены, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?3 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price <= ?2) order by price", nativeQuery = true)
    List<Product> findByTitleAndByCategoryAndDoOrderByPriceAsc(String title, float Do, int category);

    // Поиск по категории, фильтрация До цены, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?3 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price <= ?2) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndByCategoryAndDoOrderByPriceDesc(String title, float Do, int category);

    // фильтрация До цены, сортировка по возрастанию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price <= ?2) order by price", nativeQuery = true)
    List<Product> findByTitleAndDoOrderByPriceAsc(String title, float Do);

    // фильтрация До цены, сортировка по убыванию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price <= ?2) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndDoOrderByPriceDesc(String title, float Do);

    ///////////----------------------

    // Поиск по категории, сортировка по возрастанию цены
    @Query(value = "select * from product where category_id=?2 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) order by  price", nativeQuery = true)
    List<Product> findByTitleAndByCategoryOrderByPriceAsc(String title, int category);

    // Поиск по категории, сортировка по убыванию цены
    @Query(value = "select * from product where category_id=?2 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) order by  price desc", nativeQuery = true)
    List<Product> findByTitleAndByCategoryOrderByPriceDesc(String title, int category);

    // только сортировка по возрастанию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) order by price", nativeQuery = true)
    List<Product> findByTitleAndOrderByPriceAsc(String title);

    // только сортировка по убыванию цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) order by  price desc ", nativeQuery = true)
    List<Product> findByTitleAndOrderByPriceDesc(String title);

    ///////////----------------------
    ///////////----------------------
    ///////////----------------------

    // Поиск по категории, фильтрация от цены
    @Query(value = "select * from product where category_id=?3 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2) order by price", nativeQuery = true)
    List<Product> findByTitleAndByCategoryAndOt(String title, float ot, int category);

    // фильтрация от цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price >= ?2) order by price", nativeQuery = true)
    List<Product> findByTitleAndOt(String title, float ot);

    ///////////----------------------

    // Поиск по категории, фильтрация До цены
    @Query(value = "select * from product where category_id=?3 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price <= ?2)", nativeQuery = true)
    List<Product> findByTitleAndByCategoryAndDo(String title, float Do, int category);

    // фильтрация До цены
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1')) and (price <= ?2)", nativeQuery = true)
    List<Product> findByTitleAndDo(String title, float Do);

    ///////////----------------------

    // Поиск по категории
    @Query(value = "select * from product where category_id=?2 and ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1'))", nativeQuery = true)
    List<Product> findByTitleAndByCategory(String title, int category);

    // все товары
    @Query(value = "select * from product where ((lower(title) LIKE %?1%) or (lower(title) LIKE '?1%') or (lower(title) LIKE '%?1'))", nativeQuery = true)
    List<Product> findByTitleAnd(String title);


    ///////////----------------------
    ///////////---------Dlya  API -------------
    ///////////----------------------


    // все товары в api
    @Query(value = "select id, title, description, seller, warehouse, date_time, price from product", nativeQuery = true)
    List findByAll_VibKolonki();

    @Query(value = "select id, title, description, seller, warehouse, date_time, price from product where id=?1", nativeQuery = true)
    List findiById_VibKolonk(int id);


}
