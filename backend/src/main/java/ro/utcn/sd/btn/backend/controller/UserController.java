package ro.utcn.sd.btn.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.btn.backend.model.User;
import ro.utcn.sd.btn.backend.service.AppUserDetailsService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final AppUserDetailsService service;

    @GetMapping("/me")
    public User readCurrent() {
        return service.loadCurrentUser();
    }
}