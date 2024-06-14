/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import requests.Request;
import requests.Response;

/**
 *
 * @author Gazi
 */
@FunctionalInterface
interface RequestHandler {
    void handle(Request request, Response response) throws Exception;
}