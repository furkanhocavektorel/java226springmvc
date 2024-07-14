package com.vektorel.firstproject.service;

import com.vektorel.firstproject.entity.Customer;
import com.vektorel.firstproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
* service katmanları @Service ile işaretlenerek spring'e
* bunun bir service katmanı olduğu bilgisi geçilmeli.
* @Service anotasyonu ile spring bundan bir nesne oluşturur
* oluşturmuş olduğu nesneyi kendi yapısı içinde tutar.
* bu yapının adı da "ıoc container" dır
* */
@Service
public class CustomerService {

    // DI
    // Dependecny Injection

    /*
    * bir adet inject yöntemi ile inject edilmeli
    * burada ya @Autowired ile inject işlemini gerçekleştirin
    * ya da constractor inject ile inject işlemini gerçekleştiriniz
    * */

    // 2.yöntem
    //@Autowired
    CustomerRepository customerRepository;

    // 1.yöntem
    // constractor injection
    public CustomerService(CustomerRepository crepo) {
        customerRepository=crepo;
    }

    public void save(String name,
                     String surname,
                     String username,
                     String email,
                     String password){

        // yeni bir customer nesnesi oluşturuyorum
        Customer customer= new Customer();
        // customer nesnenin parametrelerini
        // metoda gelen parametreler ile dolduruyorum
        customer.setName(name);
        customer.setEmail(email);
        customer.setSurname(surname);
        customer.setUsername(username);
        customer.setPassword(password);

        // jpa repository içinde bulunan save metodu ile
        // customer imi kaydediyorum.
        customerRepository.save(customer);
    }

    public boolean login(String username, String password) {

        Optional<Customer> customer=customerRepository.findOptionalByUsername(username);

        if (customer.isEmpty()){
            return false;
        }
        if (customer.get().getPassword().equals(password)){
            return true;
        }else {
            return false;
        }


    }

}
