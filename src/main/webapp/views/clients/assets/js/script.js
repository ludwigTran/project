(function(a) {

    "use strict";

    var searchPopup = function() {
      // open search box
      a('#header-nav').on('click', '.search-button', function(e) {
        a('.search-popup').toggleClass('is-visible');
      });

      a('#header-nav').on('click', '.btn-close-search', function(e) {
        a('.search-popup').toggleClass('is-visible');
      });
      
      a(".search-popup-trigger").on("click", function(b) {
          b.preventDefault();
          a(".search-popup").addClass("is-visible"),
          setTimeout(function() {
              a(".search-popup").find("#search-popup").focus()
          }, 350)
      }),
      a(".search-popup").on("click", function(b) {
          (a(b.target).is(".search-popup-close") || a(b.target).is(".search-popup-close svg") || a(b.target).is(".search-popup-close path") || a(b.target).is(".search-popup")) && (b.preventDefault(),
          a(this).removeClass("is-visible"))
      }),
      a(document).keyup(function(b) {
          "27" === b.which && a(".search-popup").removeClass("is-visible")
      })
    }

    var initProductQty = function(){

      a('.product-qty').each(function(){

        var ael_product = a(this);
        var quantity = 0;

        ael_product.find('.quantity-right-plus').click(function(e){
            e.preventDefault();
            var quantity = parseInt(ael_product.find('#quantity').val());
            ael_product.find('#quantity').val(quantity + 1);
        });

        ael_product.find('.quantity-left-minus').click(function(e){
            e.preventDefault();
            var quantity = parseInt(ael_product.find('#quantity').val());
            if(quantity>0){
              ael_product.find('#quantity').val(quantity - 1);
            }
        });

      });

    }

    a(document).ready(function() {

      searchPopup();
      initProductQty();

      var swiper = new Swiper(".main-swiper", {
        speed: 500,
        navigation: {
          nextEl: ".swiper-arrow-prev",
          prevEl: ".swiper-arrow-next",
        },
      });         

      var swiper = new Swiper(".product-swiper", {
        slidesPerView: 4,
        spaceBetween: 10,
        pagination: {
          el: "#mobile-products .swiper-pagination",
          clickable: true,
        },
        breakpoints: {
          0: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
          980: {
            slidesPerView: 4,
            spaceBetween: 20,
          }
        },
      });      

      var swiper = new Swiper(".product-watch-swiper", {
        slidesPerView: 4,
        spaceBetween: 10,
        pagination: {
          el: "#smart-watches .swiper-pagination",
          clickable: true,
        },
        breakpoints: {
          0: {
            slidesPerView: 2,
            spaceBetween: 20,
          },
          980: {
            slidesPerView: 4,
            spaceBetween: 20,
          }
        },
      }); 

      var swiper = new Swiper(".testimonial-swiper", {
        loop: true,
        navigation: {
          nextEl: ".swiper-arrow-prev",
          prevEl: ".swiper-arrow-next",
        },
      }); 

    }); // End of a document ready

})(jQuery);