//package tn.esprit.tradingback.Controlleurs;
//
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import tn.esprit.tradingback.Entities.Post;
//import tn.esprit.tradingback.Services.Interfaces.IPostService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/post")
//@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
//public class PostController {
//    private IPostService postService;
//    @PostMapping("/save")
//    public ResponseEntity<?> addPost(@RequestBody Post post){
//        return postService.addPost(post);
//    }
//    @PutMapping("/update")
//    public ResponseEntity<?> updatePost(@RequestBody Post post){
//        return postService.updatePost(post);
//    }
//    @PostMapping("/favorites")
//    public void favorites(@RequestParam("idpost") Long idpost,@RequestParam("iduser") Long iduser){
//        postService.favoritePost(idpost, iduser);
//    }
//    @GetMapping("/get/{idPost}")
//    public Post getPost(@PathVariable("idPost") long idPost){
//        return postService.findPostById(idPost);
//    }
//    @DeleteMapping("/delete/{id}")
//    public String deletePost(@PathVariable("id") Long id){
//        postService.deletePost(id);
//        return "Post deleted !";
//    }
//    @GetMapping("/all")
//    public List<Post> getAllPost(){
//        return postService.getAll();
//    }
//
//    @PostMapping("/{postId}/like")
//    public String likePost(@PathVariable Long postId) {
//        postService.likePost(postId);
//        return "Like added successfully!";
//    }
//
//    @PostMapping("/{postId}/dislike")
//    public String dislikePost(@PathVariable Long postId) {
//        postService.dislikePost(postId);
//        return "DisLike added successfully!";
//    }
//
//    @GetMapping("/calculatePercentagePerTitle/{title}")
//    public String calculatePercentagePerTitle(@PathVariable String title){
//        return postService.calculatePercentagePerTitle(title);
//    }
//}
