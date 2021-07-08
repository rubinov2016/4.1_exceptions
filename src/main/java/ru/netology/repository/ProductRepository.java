package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        //В методе удаления removeById сначала проверяйте, есть ли элемент (для этого прямо из метода removeById
        // вызывайте метод findById: если результат - null, тогда выкидывайте исключение NotFoundException*)
        //Ловить на выхода за пределы массива это умно,
        //но так не делают, сделайте через условный оператор (как в условии)
        if (findById(id)!=null) {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        } else {
            //e.printStackTrace();
            String s = "Element with id: " + id + " not found";
            System.out.print(s);
            throw new NotFoundException(s);
        }
    }
}
