package org.example.traveler.controllers;

import org.example.traveler.dtos.destinationDtos.DestinationCreateDto;
import org.example.traveler.dtos.destinationDtos.DestinationDto;
import org.example.traveler.dtos.guideDtos.GuideCreateDto;
import org.example.traveler.dtos.guideDtos.GuideDto;
import org.example.traveler.dtos.guideDtos.GuideUpdateDto;
import org.example.traveler.dtos.roleDtos.RoleDto;
import org.example.traveler.dtos.testimonialDtos.TestimonialCreateDto;
import org.example.traveler.dtos.testimonialDtos.TestimonialDto;
import org.example.traveler.dtos.tourDtos.TourCreateDto;
import org.example.traveler.dtos.tourDtos.TourDto;
import org.example.traveler.dtos.userDtos.UserAddRoleDto;
import org.example.traveler.dtos.userDtos.UserDashboardListDto;
import org.example.traveler.dtos.userDtos.UserDto;
import org.example.traveler.repositories.DestinationRepository;
import org.example.traveler.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashboardController {
    @Autowired
    private DestinationService destinationService;

    @Autowired
    private TourService tourService;

    @Autowired
    private GuideService guideService;

    @Autowired
    private TestimonialService testimonialService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/admin")
    public String admin(){
        return "/dashboard/home";
    }


    @GetMapping("/admin/tour")
    public String tour(Model model){
        List<TourDto> tours = tourService.getTours();
        model.addAttribute("tours",tours);
        return "/dashboard/tour/tour";
    }
    @GetMapping("/admin/tour/create")
    public String tourCreate(Model model){
        List<DestinationDto> destinations = destinationService.getAllDestinations();
        List<GuideDto> guides = guideService.getAllActiveGuides();
        model.addAttribute("destinations",destinations);
        model.addAttribute("guides",guides);
        return "/dashboard/tour/tour-create";
    }
    @PostMapping("/admin/tour/create")
    public String tourCreate(@ModelAttribute TourCreateDto tourCreateDto){
        tourService.addTour(tourCreateDto);
        return "redirect:/admin/tour";
    }


    @GetMapping("/admin/destination")
    public String destination(Model model){
        List<DestinationDto> destinations = destinationService.getAllDestinations();
        model.addAttribute("destinations",destinations);
        return "/dashboard/destination/destination";
    }
    @GetMapping("/admin/destination/create")
    public String destinationCreate(){
        return "/dashboard/destination/destination-create";
    }
    @PostMapping("/admin/destination/create")
    public String destinationCreate(@ModelAttribute DestinationCreateDto destinationCreateDto){
        destinationService.add(destinationCreateDto);
        return "redirect:/admin/destination";
    }

    @GetMapping("/admin/guide/update/{id}")
    public String updateGuide(@PathVariable Long id, Model model){
        GuideUpdateDto guideUpdateDto = guideService.findUpdateGuide(id);
        model.addAttribute("guide",guideUpdateDto);
        return "/dashboard/guide/update";

    }
    @PostMapping("/admin/guide/update")
    public String updateGuide(@ModelAttribute GuideUpdateDto guideUpdateDto){
        guideService.updateGuide(guideUpdateDto);
        return "redirect:/admin/guide";
    }



    @GetMapping("/admin/guide")
    public String guide(Model model){
        List<GuideDto> guides = guideService.getAllGuides();
        model.addAttribute("guides",guides);
        return "/dashboard/guide/guides";
    }
    @GetMapping("/admin/guide/create")
    public String guideCreate(){
        return "/dashboard/guide/guide-create";
    }
    @PostMapping("/admin/guide/create")
    public String guideCreate(@ModelAttribute GuideCreateDto guideCreateDto){
        guideService.addGuide(guideCreateDto);
        return "redirect:/admin/guide";
    }
    @GetMapping("/admin/guide/remove/{id}")
    public String removeGuide(@PathVariable Long id){
        guideService.removeGuide(id);
        return "redirect:/admin/guide";
    }




    @GetMapping("/admin/testimonial")
    public String testimonial(Model model){
        List<TestimonialDto> testimonials = testimonialService.getAllEnableTestimonials();
        model.addAttribute("testimonials",testimonials);
        return "/dashboard/testimonial/testimonials";
    }
    @GetMapping("/admin/testimonial/create")
    public String testimonialCreate(){
        return "/dashboard/testimonial/testimonial-create";
    }
    @PostMapping("/admin/testimonial/create")
    public String testimonialCreate(@ModelAttribute TestimonialCreateDto testimonialCreateDto){
        testimonialService.createTestimonial(testimonialCreateDto);
        return "redirect:/admin/testimonial";
    }

    @GetMapping("/admin/users")
    public String getUsers(Model model){
        List<UserDashboardListDto> userList = userService.getDashboardUsers();
        model.addAttribute("users",userList);
        return "/dashboard/auth/user-list";
    }
    @GetMapping("/admin/users/role/{id}")
    public String addRole(@PathVariable Long id, Model model){
        List<RoleDto> roles = roleService.getRoles();
        UserDto user = userService.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("roles",roles);
        return "/dashboard/auth/user-role";
    }
    @PostMapping("/admin/users/addrole")
    public String addRole(UserAddRoleDto userAddRoleDto){
        userService.addRole(userAddRoleDto);
//        return "/dashboard/auth/user-list";
        return "redirect:/admin/users";
    }

}
