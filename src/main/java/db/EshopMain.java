package db;

import meneger.CategoryManager;
import meneger.ProductManager;
import model.Category;
import model.Product;

import java.util.Scanner;

public class EshopMain {
    private static Scanner scanner = new Scanner(System.in);
    private static CategoryManager categoryManager = new CategoryManager();
    private static ProductManager productManager = new ProductManager();
    private static Category category = new Category();


    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            System.out.println("Please input 0 for exit");
            System.out.println("Please input 1 for add Category");
            System.out.println("Please input 2 for Edit Category by Id");
            System.out.println("Please input 3 for delete Category by ID");
            System.out.println("Please input 4 for add Product");
            System.out.println("Please input 5 for Edit Product by Id");
            System.out.println("Please input 6 for delete Product by Id");
            System.out.println("Please input 7 for Print Sum of products");
            System.out.println("Please input 8 for Print Max of price product");
            System.out.println("Please input 9 for Print Min of price product ");
            System.out.println("Please input 10 for Print Avg of price product");
            String command = scanner.nextLine();
            switch (command) {
                case "0":
                    isRun = false;
                    break;
                case "1":
                    addCategory();
                    break;
                case "2":
                    editCategoryId();
                    break;
                case "3":
                    deleteCategoryByID();
                    break;
                case "4":
                    addProduct();
                    break;
                case "5":
                    EditProductById();
                    break;
                case "6":
                    deleteProductById();
                    break;
                case "7":
                    productManager.printSumOfProducts();
                    break;
                case "8":
                    productManager.printMaxOfPriceProduct();
                    break;
                case "9":
                    productManager.printMinOfPriceProduct();
                    break;
                case "10":
                    productManager.printAvgOfPriceProduct();
                    break;
                default:
                    System.out.println("invalid command");


            }
        }
    }

    private static void deleteProductById() {
        System.out.println(productManager.getAll());
        System.out.println("Please input product id delete product");
        String str = scanner.nextLine();
        int productId = Integer.parseInt(str);
        productManager.removeById(productId);
        System.out.println("product delete");
    }

    private static void EditProductById() {
        System.out.println(productManager.getAll());
        System.out.println("Please choose product id for Edit Product");
        int productId = Integer.parseInt(scanner.nextLine());
        Product editProduct = productManager.getById(productId);

        if (editProduct != null) {
            System.out.println("Please input edit product name,Description,Price,Quantity");
            String input = scanner.nextLine();
            String[] productData = input.split(",");
            editProduct.setCategory(category);
            editProduct.setName(productData[0]);
            editProduct.setDescription(productData[1]);
            editProduct.setPrice(Double.parseDouble(productData[2]));
            editProduct.setQuantity(Integer.parseInt(productData[3]));
            productManager.editProductById(editProduct);
            System.out.println("the product has been edited");
        }
    }

    private static void addProduct() {
        System.out.println(categoryManager.getAll());
        System.out.println("Please choose category id");
        int id = Integer.parseInt(scanner.nextLine());
        Category category = categoryManager.getById(id);
        if (category != null) {
            System.out.println("Please input product name,Description,Price,Quantity");
            String Str = scanner.nextLine();
            String[] productData = Str.split(",");
            Product product = new Product();
            product.setCategory(category);
            product.setName(productData[0]);
            product.setDescription(productData[1]);
            product.setPrice(Double.parseDouble(productData[2]));
            product.setQuantity(Integer.parseInt(productData[3]));
            productManager.save(product);
            System.out.println("added product");
        }
    }

    private static void deleteCategoryByID() {
        System.out.println(categoryManager.getAll());
        System.out.println("Please input category id delete category");
        String str = scanner.nextLine();
        int categoryId = Integer.parseInt(str);
        categoryManager.removeById(categoryId);
        System.out.println("category delete");
    }

    private static void editCategoryId() {
        System.out.println(categoryManager.getAll());
        System.out.println("Please input category id update category data: << format name,id number >>");
        String categoryStr = scanner.nextLine();
        String[] categoryData = categoryStr.split(",");
        category.setName(categoryData[0]);
        category.setId(Integer.parseInt(categoryData[1]));
        categoryManager.editCategoryById(category);
        System.out.println("updated category data");
    }

    private static void addCategory() {
        System.out.println("Please input  for Category name");
        String str = scanner.nextLine();
        category.setName(str);
        categoryManager.save(category);
    }
}
