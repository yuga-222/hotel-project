package com.example.hotelproject.controller;

import java.util.List;

import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.entity.Review;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotel_id}/reviews")
public class ReviewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public String index(@PathVariable Long hotel_id, Model model) {
        List<Review> reviews = reviewRepository.findByHotelId(hotel_id);
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("reviews", reviews);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "レビュー一覧");
        return "review/index";
    }
    @GetMapping("new")
    public String newReview(@PathVariable Long hotel_id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "レビュー投稿");
        return "review/new";
    }

    @PostMapping
    public String create(@PathVariable Long hotel_id, @ModelAttribute Review review) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        review.setHotel(hotel);
        reviewRepository.save(review);
        return "redirect:/hotels/{hotel_id}/reviews";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long hotel_id,@PathVariable Long id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        Review review = reviewRepository.findById(id).orElse(null);
        model.addAttribute("review", review);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "レビュー");
        return "review/show";
    }

}