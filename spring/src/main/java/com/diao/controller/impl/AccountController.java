package com.diao.controller.impl;

import com.diao.controller.IAccountController;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController implements IAccountController {

    @Override
    public void say() {
        System.out.println("this is controller instance!");
    }
}
