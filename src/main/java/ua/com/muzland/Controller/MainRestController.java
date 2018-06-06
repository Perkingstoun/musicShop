package ua.com.muzland.Controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ua.com.muzland.Entity.*;
import ua.com.muzland.Service.*;

import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Transactional
public class MainRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;


    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CompanyService companyService;

    @PostMapping("/admin/saveCategory")
    public void saveCategory(@RequestBody String cName) {
        System.out.println("hellow");
        System.out.println(cName);

        categoryService.save(new Category(cName));
    }

    @PostMapping("/admin/saveSubCategory")
    public void saveSubCategory(@RequestBody SubCategory subCategory) {
        System.out.println("hellow");
        System.out.println(subCategory);

        Category category = subCategory.getCategory();
        Iterator<Category> categoryIterator = categoryService.findAll().iterator();

        while (categoryIterator.hasNext()) {

            Category next = categoryIterator.next();
            if (category.getCategoryName().equals(next.getCategoryName())) {
                category = next;
                System.out.println(category.getCategoryName());
                System.out.println(category.getSubCategory().toArray());
            } else System.out.println("error" + category);
        }
        subCategory.setCategory(category);
        System.out.println("setnuv");
        subCategoryService.save(subCategory);
//        System.out.println(subCategory.getCategory().getCategoryName());
        System.out.println("hellow");


    }

    @GetMapping("/admin/products/getProducts")
    public List<AdminTable> getProducts() {
        List<AdminTable> adminTable = new ArrayList<>();
        List<Product> allProducts = productService.findAll();
        Iterator<Product> productIterator = allProducts.iterator();

        while (productIterator.hasNext()) {
            AdminTable table = new AdminTable();
            Product product = productIterator.next();
            table.setId(product.getId());
            table.setPBrand(product.getBrand().getBrandName());
            table.setPName(product.getProductName());
            table.setPPrice(product.getProductPrice());
            table.setPPhoto(product.getProductInformation().getImg());
            table.setScName(product.getSubCategory().getSubCategoryName());
            table.setCName(product.getSubCategory().getCategory().getCategoryName());
            table.setDescriprion(product.getProductInformation().getAboutProduct());
            System.out.println(table);
            adminTable.add(table);

        }


        return adminTable;
    }

    @GetMapping("/admin/products/addProductForm/cat")
    public List<String> getCategory() {

        List<Category> categoryList = categoryService.findAll();

        List<String> categories = new ArrayList<>();
        Iterator<Category> categoryIterator = categoryList.iterator();
        while (categoryIterator.hasNext()) {


            Category next = categoryIterator.next();
            categories.add(next.getCategoryName());

        }

        return categories;
    }

    @PostMapping("/admin/products/addProductForm/sub")
    public List<String> getSubCategory(@RequestBody String category) {
        System.out.println(category);
        List<String> subCategories = new ArrayList<>();
        Category category1 = new Category();
        System.out.println("hello");
        Iterator<Category> categoryIterator = categoryService.findAll().iterator();

        while (categoryIterator.hasNext()) {

            Category next = categoryIterator.next();
            if (category.equals(next.getCategoryName())) category1 = next;
        }
        System.out.println(category1.getCategoryName());

        List<SubCategory> subCategoriesList = category1.getSubCategory();
//        if (categoryService.findByName(category)==null) System.out.println("suka");
//        System.out.println("huy");
        Iterator<SubCategory> subCategoryIterator = subCategoriesList.iterator();
        while (subCategoryIterator.hasNext()) {
            System.out.println("step");
            subCategories.add(subCategoryIterator.next().getSubCategoryName());
            System.out.println(subCategories);
        }
        System.out.println("ok");
        return subCategories;
    }

    @GetMapping("/shop/getNewProducts")
    public List<ProductOnPage> getNewProducts() {

        List<Product> products = productService.findAll();
        List<ProductOnPage> productsOnPage = new ArrayList<>();


        for (int i = 0; i < 9; i++) {
            ProductOnPage productOnPage = new ProductOnPage();
            System.out.println(products.size());
            productOnPage.setName(products.get(products.size() - i - 1).getProductName());
            System.out.println(productOnPage.getName());
            productOnPage.setId(products.get(products.size() - i - 1).getId());
            productOnPage.setBrand(products.get(products.size() - i - 1).getBrand().getBrandName());
            System.out.println(productOnPage.getBrand());
            productOnPage.setPrice(products.get(products.size() - i - 1).getProductPrice());
            System.out.println(productOnPage.getPrice());
            productOnPage.setImage(products.get(products.size() - i - 1).getProductInformation().getImg());
            productsOnPage.add(productOnPage);
            if ((products.size() < 9) && (products.size() - i - 1 == 0)) break;

        }

        System.out.println("giving");
        return productsOnPage;
    }

    @PostMapping("/shop/getAllProducts")
    public List<ProductOnPage> getAllProducts(@RequestBody Category category) {
        String categoryName = category.getCategoryName();
        int pageNumber = category.getId();

//        int pageNumber = Integer.parseInt(page);
//        System.out.println("st: "+page);
        List<Product> products = productService.findAll(categoryName);
        List<ProductOnPage> productsOnPage = new ArrayList<>();
        System.out.println("getting all prod");
        Iterator<Product> productIterator = products.iterator();
        int k = productService.findAll(categoryName).size();
        int pages;
        if (k % 5 == 0) pages = k / 5;
        else pages = k / 5 + 1;
        int i = 1;
        if (pageNumber > pages) return null;
        int start = (pageNumber - 1) * 5;
        while (productIterator.hasNext()) {
            if (i <= start) {
                productIterator.next();
                i++;
                continue;
            }
            if (i == start + 6) {
                break;
            }
            Product product = productIterator.next();
            ProductOnPage productOnPage = new ProductOnPage();
            System.out.println(products.size());
            productOnPage.setName(product.getProductName());
            System.out.println(productOnPage.getName());
            productOnPage.setId(product.getId());
            productOnPage.setBrand(product.getBrand().getBrandName());
            System.out.println(productOnPage.getBrand());
            productOnPage.setPrice(product.getProductPrice());
            System.out.println(productOnPage.getPrice());
            productOnPage.setImage(product.getProductInformation().getImg());
            productsOnPage.add(productOnPage);
            i++;

        }
        System.out.println("giving");
        return productsOnPage;

    }

    @GetMapping("/getPages")
    public int getPages(@RequestBody String categoryName) {
        int pages = productService.findAll(categoryName).size();

        return pages;
    }

    @PostMapping("/admin/saveAboutUs")
    public void saveAboutUs(@RequestBody String aboutUs) {
        Company company = new Company();
        Instruments instrument = new Instruments();
        String escape = instrument.escape(aboutUs);
        System.out.println(aboutUs);

        if (companyService.find(1) == null) {
            System.out.println("done");


            company.setAboutUs(escape);
            companyService.save(company);
        } else {
            System.out.println("done1");
            company = companyService.find(1);
            company.setAboutUs(escape);
        }
    }

    @PostMapping("/productPage/add-product-to-cart")
    public void addToCart(@RequestBody String id, Principal principal) {
        System.out.println("hello");
        int prodId = Integer.parseInt(id);

        User user = userService.findUserByUserName(principal.getName());
        Cart cart = new Cart();
        Cart same = cartService.findSame(prodId, principal.getName());
        System.out.println("get same");
        System.out.println(same);
        if(same==null) {
            System.out.println("null21ee");
            cart.setUser(user);
            cart.setProdId(prodId);
            cart.setAmount(1);
            System.out.println("seted");
            cartService.save(cart);
            System.out.println("saved");
        }
        else
        {
            System.out.println("not null");
            int amount = same.getAmount();
            amount++;
            same.setAmount(amount);
            System.out.println("set amount");
        }

        System.out.println(productService.findById(prodId).getProductName());
    }

    @GetMapping("/getUserCart")
    public List<CartTable> getUserCart(Principal principal){
        List<CartTable> cartTables = new ArrayList<>();
        System.out.println("get user cart: start");

        List<Cart> carts = cartService.findByUserName(principal.getName());
        Iterator<Cart> cartIterator = carts.iterator();
        Cart cart;
        CartTable cartTable;
        Product product;
        while(cartIterator.hasNext()){
            cart = cartIterator.next();
            cartTable = new CartTable();
            product = productService.findById(cart.getProdId());
            cartTable.setBrand(product.getBrand().getBrandName());
            System.out.println(cartTable.getBrand());
            cartTable.setImg(product.getProductInformation().getImg());
            cartTable.setName(product.getProductName());
            cartTable.setPrice(product.getProductPrice());
            cartTable.setAmount(cart.getAmount());
            cartTable.setSumPrice(cart.getAmount()*product.getProductPrice());
            System.out.println(cartTable);
            cartTables.add(cartTable);

        }
        System.out.println("get user cart: end");
        System.out.println(cartTables);
        return  cartTables;
    }

}
