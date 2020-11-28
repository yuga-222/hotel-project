package com.example.hotelproject.controller;

import java.util.List;

import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.entity.Information;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.InformationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotel_id}/informations")
public class InformationController {
    @Autowired
    private InformationRepository informationRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public String index(@PathVariable Long hotel_id, Model model) {
        List<Information> informations = informationRepository.findByHotelId(hotel_id);
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("informations", informations);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Information Index");
        return "information/index";
    }
    @GetMapping("new")
    public String newInformation(@PathVariable Long hotel_id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "New Information");
        return "information/new";
    }

    @PostMapping
    public String create(@PathVariable Long hotel_id, @ModelAttribute Information information) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        information.setHotel(hotel);
        informationRepository.save(information);
        return "redirect:/hotels/{hotel_id}/informations";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long hotel_id,@PathVariable Long id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        Information information = informationRepository.findById(id).orElse(null);
        model.addAttribute("information", information);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Show Information");
        return "information/show";
    }

}
