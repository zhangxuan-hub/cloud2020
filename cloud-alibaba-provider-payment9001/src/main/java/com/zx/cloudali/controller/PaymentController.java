package com.zx.cloudali.controller;

<<<<<<< Updated upstream
=======
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> Stashed changes
/**
 * @ClassName PaymentController
 * @Author Administrator
 * @Description TODO
 * @Date 2020/4/28 0028 17:01
 * @Version 1.0
 */
<<<<<<< Updated upstream
public class PaymentController {
=======

@RestController
@RequestMapping("pay")
public class PaymentController {

    @PostMapping("/create")
    public String create(Long id) {
        return "/pay/create/" + id;
    }
>>>>>>> Stashed changes
}
