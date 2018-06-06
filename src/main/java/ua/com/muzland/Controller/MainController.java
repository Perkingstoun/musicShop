package ua.com.muzland.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.IOP.ServiceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.muzland.Entity.*;
import ua.com.muzland.Service.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@Transactional
@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private  CompanyService companyService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {

        return "main";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("aboutUs", companyService.find(1).getAboutUs());
        return "main";
    }

    @GetMapping("/userPage")
    public String userPage(HttpServletRequest request, ModelMap model) {

        return "userPage";
    }



    @PostMapping("/main")
    public String logIn() {

        return "main";
    }

    @GetMapping("/logReg")
    public String logreg() {

        return "logReg";
    }


    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("password") String password,
                       @RequestParam("email") String email) {
        userService.save(new User(username, password, email));

        return "main";
    }

    @PostMapping("/saveProfile")
    public String saveProfile(@RequestParam("age") int age, @RequestParam("userAvatar") MultipartFile userAvatar,
                              Principal principal, ModelMap model) {
        String path = System.getProperty("user.home") + File.separator + "multipart\\";

        try {
            userAvatar.transferTo(new File(path + userAvatar.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserProfile userProfile = new UserProfile();
        userProfile.setUserAvatar("\\userAvatar\\" + userAvatar.getOriginalFilename());
        userProfile.setAge(age);
        userProfileService.save(userProfile);
        User user = userService.findUserByUserName(principal.getName());


        user.setUserProfile(userProfile);

        return "/main";
    }

    @GetMapping("/store")
    public String store() {
        return "store";
    }

    @GetMapping("/basket")
    public String basket() {
        return "userCart";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "contacts";
    }

    @GetMapping("/admin/products")
    public String products(Model model) {
        List<Product> products = productService.findAll();

        return "products";
    }

    @GetMapping("/admin/users")
    public String users() {
        return "users";
    }

//    @GetMapping("/saveProduct")
//        public String saveProduct(@RequestParam("img") MultipartFile pPhoto,
//                                  @RequestParam("productName") String pName,
//                                  @RequestParam("categoryName") String cName,
//                                  @RequestParam("subCategoryName") String  scName,
//                                  @RequestParam("productPrice") int price,
//                                  @RequestParam("aboutProduct") String  pDescr){
//
//        Product product = new Product();
//        Category category = new Category();
//        SubCategory subCategory = new SubCategory();
//        ProductInformation productInformation = new ProductInformation();
//        String path = System.getProperty("user.home") + File.separator + "multipart\\";
//
//        try {
//            pPhoto.transferTo(new File(path + pPhoto.getOriginalFilename()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        productInformation.setImg("\\userAvatar\\"+pPhoto.getOriginalFilename());
//        productInformation.setAboutProduct(pDescr);
//        // Заповню категорію і субкатегорію
//        category.setCategoryName(cName);
//        subCategory.setSubCategoryName(scName);
//        //// product
//        product.setProductName(pName);
//        product.setProductPrice(price);
//        product.setProductInformation(productInformation);
//        subCategory.setCategory(category);
//        product.setSubCategory(subCategory);
//        productService.save(product);
//
//            return "redirect:/admin/products";
//        }

    @GetMapping("/addProductForm")
    public String addProductForm() {
        return "addProductForm";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id) {
        productService.delete(id);

        return "redirect:/admin/products";
    }

    @GetMapping("/refactor")
        public String productRefactor(@RequestParam int id, Model model){

        Product byId = productService.findById(id);
        model.addAttribute("pName", byId.getProductName());
        model.addAttribute("pPrice", byId.getProductPrice());
        model.addAttribute("pSCat",byId.getSubCategory().getSubCategoryName());
        model.addAttribute("pCat", byId.getSubCategory().getCategory().getCategoryName());
        model.addAttribute("pPhoto", byId.getProductInformation().getImg());
        model.addAttribute("pDescr",byId.getProductInformation().getAboutProduct());
        model.addAttribute("pBrand", byId.getBrand().getBrandName());
        model.addAttribute("id", byId.getId());


        return "productRefactor";
        }

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestParam("productPhoto") MultipartFile photo,
                              @RequestParam("productBrand") String pbrand,
                              @RequestParam("productName") String name,
                              @RequestParam("productPrice") int price,
                              @RequestParam("productCategory") String categoryN,
                              @RequestParam("productSubCategory") String subCategoryN,
                              @RequestParam("productDescription") String description
    ) {
        Product product = new Product();
        SubCategory subCategory = subCategoryService.findByName(subCategoryN);
        Category category = subCategory.getCategory();

        Brand brand;
        if (brandService.findByName(pbrand)!=null) brand = brandService.findByName(pbrand);
        else brand = new Brand();
        brand.setBrandName(pbrand);
        ProductInformation productInformation = new ProductInformation();
        String path = System.getProperty("user.home") + File.separator + "multipart\\";

        try {
            photo.transferTo(new File(path + photo.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        category.setCategoryName(categoryN);
        subCategory.setSubCategoryName(subCategoryN);
        subCategory.setCategory(category);
        productInformation.setAboutProduct(description);
        productInformation.setImg("\\userAvatar\\" + photo.getOriginalFilename());
        product.setSubCategory(subCategory);
        product.setProductInformation(productInformation);
        product.setProductPrice(price);
        product.setBrand(brand);
        product.setProductName(name);
        productService.save(product);
        return "redirect:/admin/products";
    }

@PostMapping("/refactProduct")
public  String  refactProduct(@RequestParam("productPhoto") MultipartFile photo,
                              @RequestParam("productBrand") String pbrand,
                              @RequestParam("productName") String name,
                              @RequestParam("productPrice") int price,
                              @RequestParam("productCategory") String categoryN,
                              @RequestParam("productSubCategory") String subCategoryN,
                              @RequestParam("productDescription") String description,
                              @RequestParam("id") int id){
    Product product = productService.findById(id);
    SubCategory subCategory = subCategoryService.findByName(subCategoryN);
    Category category = subCategory.getCategory();

    Brand brand;
    if (brandService.findByName(pbrand)!=null) brand = brandService.findByName(pbrand);
    else brand = new Brand();
    brand.setBrandName(pbrand);
    ProductInformation productInformation = new ProductInformation();
    String path = System.getProperty("user.home") + File.separator + "multipart\\";

    try {
        photo.transferTo(new File(path + photo.getOriginalFilename()));
    } catch (IOException e) {
        e.printStackTrace();
    }

    category.setCategoryName(categoryN);
    subCategory.setSubCategoryName(subCategoryN);
    subCategory.setCategory(category);
    productInformation.setAboutProduct(description);
    productInformation.setImg("\\userAvatar\\" + photo.getOriginalFilename());
    product.setSubCategory(subCategory);
    product.setProductInformation(productInformation);
    product.setProductPrice(price);
    product.setBrand(brand);
    product.setProductName(name);

    return "redirect:/admin/products";

}
    @GetMapping("/test")
    public String test(Model model) {
        Product byId = productService.findById(1);
        SubCategory subCategory = byId.getSubCategory();
        System.out.println("sc " + subCategory.getSubCategoryName());
        System.out.println("about " + byId.getProductInformation().getAboutProduct());
        System.out.println("c: " + subCategory.getCategory().getCategoryName());

        return "redirect:/admin/products";
    }

    @GetMapping("/productPage")
    public String productPage(@RequestParam int id, Model model){
        Product product = productService.findById(id);
        Instruments instrument = new Instruments();
        ProductOnPage productOnPage = new ProductOnPage();
        productOnPage.setId(id);
        productOnPage.setImage(product.getProductInformation().getImg());
        productOnPage.setName(product.getProductName());
        productOnPage.setPrice(product.getProductPrice());
        productOnPage.setBrand(product.getBrand().getBrandName());
        productOnPage.setCategory(product.getSubCategory().getCategory().getCategoryName());
        productOnPage.setSubCategory(product.getSubCategory().getSubCategoryName());
        productOnPage.setDetails(instrument.escape(product.getProductInformation().getAboutProduct()));
        model.addAttribute("prod", productOnPage);
        return "productPage";
    }

    @GetMapping("/store/allProducts")
        public String allProducts(@RequestParam("category") String category, Model model){
            model.addAttribute("category" , category);



            return "allProducts";
        }


}
