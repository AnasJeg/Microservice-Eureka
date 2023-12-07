package com.voitureclient.proxy;

import com.voitureclient.beans.Clientbeans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
@FeignClient(name="SERVICE-CLIENT", url="http://localhost:8080")
public interface MicroserviceClientProxy {
    @GetMapping("/clients")
    List<Clientbeans> find();
    @GetMapping("/clients/{id}")
    Clientbeans chercherUnClient(@PathVariable Long id);
    @GetMapping("clientInfo/{id}")
    Clientbeans getInfoClient(@PathVariable Long id) ;

}
