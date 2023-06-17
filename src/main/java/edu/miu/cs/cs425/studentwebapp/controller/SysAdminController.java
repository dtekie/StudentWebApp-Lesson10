package edu.miu.cs.cs425.studentwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SysAdminController {

    @GetMapping(value = {"/sysadmin"})
    public String displaySysAdminPage() {
        return "sysadmin/index";
    }
}
