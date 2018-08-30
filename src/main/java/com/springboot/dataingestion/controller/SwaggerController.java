/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.dataingestion.controller;

import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author Kaushik Mani
 */
@RestController
@ApiIgnore
public class SwaggerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SwaggerController.class);

    @Value(("${gateway.ahead}"))
    boolean gatewayAhead;

    @Value(("${gateway.protocol}"))
    private String gatewayProtocol;

    @Value(("${server.context-path}"))
    private String contextPath;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    @ApiOperation(
            value = "Renders Swagger UI",
            notes = "Renders Swagger UI",
            tags = {"Swagger"}
    )
    public void swaggerUI(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String redirectPort = ":" + request.getServerPort();
        String redirectContextPath = this.contextPath;
        String redirectProtocol = request.getScheme() + "://";
        String redirectServerName = request.getServerName();

        String swaggerUIPath = "swagger-ui.html";

        if (this.gatewayAhead == true) {
            redirectPort = "";
            redirectProtocol = this.gatewayProtocol + "://";
        }

        if (!redirectContextPath.endsWith("/")) {
            swaggerUIPath = "/" + swaggerUIPath;
        }

        String redirectURL = response.encodeRedirectURL(redirectProtocol + redirectServerName + redirectPort + redirectContextPath + "swagger-ui.html");

        LOGGER.info("Redirect to swaggerUI: " + redirectURL);

        response.sendRedirect(redirectURL);
    }
}
