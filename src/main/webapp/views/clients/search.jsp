<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Ministore</title>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="format-detection" content="telephone=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="author" content="">
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css"
	href="/ProjectShop/views/clients/assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/ProjectShop/views/clients/assets/css/style.css">


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Jost:wght@300;400;500&family=Lato:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<!-- script
    ================================================== -->
<script src="/ProjectShop/views/clients/assets/js/modernizr.js"></script>
</head>
<body data-bs-spy="scroll" data-bs-target="#navbar"
	data-bs-root-margin="0px 0px -40%" data-bs-smooth-scroll="true"
	tabindex="0">

	<!-- Start - Header -->
	<%@include file="/layout/Header.jsp"%>
	<!-- End - Header -->

<!-- //Search section -->
<section id="mobile-products"
		class="product-store position-relative padding-large">
		<c:set value="${requestSCope.cl }" var="cl"></c:set>
		<div class="container">

			<div class="row">
				<div class="display-header d-flex justify-content-between pb-3">
					<h2 class="display-7 text-dark text-uppercase">Search Results: ${requestScope.x} results </h2>

				</div>

				<div class="swiper product-swiper">
		
					<div class="swiper-wrapper">
						<c:forEach items="${requestScope.listSearch}" var="sp">

							<div class="swiper-slide">
								<div class="product-card position-relative">
									<div class="image-holder">
										<a href="/ProjectShop/home?page=detail&id=${sp.id}"> <img
											src="/ProjectShop/views/clients/assets/images/${sp.image }"
											alt="product-item" class="img-fluid">
										</a>

									</div>
									<div class="cart-concern position-absolute">

										<div class="cart-button d-flex">
											<a href="#" onclick="cartDetail('${sp.id }')"
												class="btn btn-medium btn-black">Add to cart<svg
													class="cart-outline">
														<use xlink:href="#cart-outline"></use></svg></a>
										</div>

									</div>

									<div
										class="card-detail d-flex justify-content-between align-items-baseline pt-3">

										<h3 class="card-title text-uppercase">
											<a href="/ProjectShop/home?page=detail&id=${sp.id}">${sp.name }</a>
										</h3>


										<span class="item-price text-primary">$ ${sp.price}</span>
									</div>

								</div>


							</div>
						</c:forEach>
					</div>

				</div>

			</div>
		</div>
		<div class="swiper-pagination position-absolute text-center"></div>

	</section>
<!-- SALESOFF SECTION -->
	<section id="yearly-sale"
		class="bg-light-blue position-relative padding-large"
		style="background-image: url('/ProjectShop/views/clients/assets/images/salesoff.jpg'); background-repeat: no-repeat; background-size: 100% 100%">
		<div class="row d-flex flex-wrap align-items-center">
			<div class="col-md-6 col-sm-12">
				<div class="text-content offset-4 padding-medium">
					<a href="shop.html"
						class="btn btn-lg btn-danger text-uppercase btn-rounded-none">Shop
						Sale</a>
				</div>
			</div>
		</div>
	</section>
	<section id="latest-blog" class="padding-large">
		<div class="container">
			<div class="row">
				<div class="display-header d-flex justify-content-between pb-3">
					<h2 class="display-7 text-dark text-uppercase">Latest Posts</h2>
					<div class="btn-right">
						<a href="blog.html"
							class="btn btn-medium btn-normal text-uppercase">Read Blog</a>
					</div>
				</div>
				<div class="post-grid d-flex flex-wrap justify-content-between">
					<div class="col-lg-4 col-sm-12">
						<div class="card border-none me-3">
							<div class="card-image">
								<img
									src="/ProjectShop/views/clients/assets/images/post-item1.jpg"
									alt="" class="img-fluid">
							</div>
						</div>
						<div class="card-body text-uppercase">
							<div class="card-meta text-muted">
								<span class="meta-date">2024</span> <span class="meta-category">-
									Gadgets</span>
							</div>
							<h3 class="card-title">
								<a href="#">Get some cool gadgets in 2024</a>
							</h3>
						</div>
					</div>
					<div class="col-lg-4 col-sm-12">
						<div class="card border-none me-3">
							<div class="card-image">
								<img src="images/post-item2.jpg" alt="" class="img-fluid">
							</div>
						</div>
						<div class="card-body text-uppercase">
							<div class="card-meta text-muted">
								<span class="meta-date">Jan 11, 2024</span> <span
									class="meta-category">- Technology</span>
							</div>
							<h3 class="card-title">
								<a href="#">Technology Hack You Won't Get</a>
							</h3>
						</div>
					</div>
					<div class="col-lg-4 col-sm-12">
						<div class="card border-none me-3">
							<div class="card-image">
								<img
									src="/ProjectShop/views/clients/assets/images/post-item3.jpg"
									alt="" class="img-fluid">
							</div>
						</div>
						<div class="card-body text-uppercase">
							<div class="card-meta text-muted">
								<span class="meta-date">Jan 2, 2023</span> <span
									class="meta-category">- Camera</span>
							</div>
							<h3 class="card-title">
								<a href="#">Top 10 Small Camera In The World</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="testimonials" class="position-relative">
		<div class="container">
			<div class="row">
				<div class="review-content position-relative">
					<div
						class="swiper-icon swiper-arrow swiper-arrow-prev position-absolute d-flex align-items-center">
						<svg class="chevron-left">
                <use xlink:href="#chevron-left" />
              </svg>
					</div>
					<div class="swiper testimonial-swiper">
						<div class="quotation text-center">
							<svg class="quote">
                  <use xlink:href="#quote" />
                </svg>
						</div>
						<div class="swiper-wrapper">
							<div
								class="swiper-slide text-center d-flex justify-content-center">
								<div class="review-item col-md-10">
									<i class="icon icon-review"></i>
									<blockquote>“Thật không thể tin nổi, quá khủng
										khiếp, sản phẩm ối dồi ôi luôn, cám ơn rất .”</blockquote>
									<div class="rating">
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-empty">
                        <use xlink:href="#star-empty"></use>
                      </svg>
									</div>
									<div class="author-detail">
										<div class="name text-dark text-uppercase pt-2">Emma
											Chamberlin</div>
									</div>
								</div>
							</div>
							<div
								class="swiper-slide text-center d-flex justify-content-center">
								<div class="review-item col-md-10">
									<i class="icon icon-review"></i>
									<blockquote>“A blog is a digital publication that
										can complement a website or exist independently. A blog may
										include articles, short posts, listicles, infographics,
										videos, and other digital content.”</blockquote>
									<div class="rating">
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-fill">
                        <use xlink:href="#star-fill"></use>
                      </svg>
										<svg class="star star-half">
                        <use xlink:href="#star-half"></use>
                      </svg>
										<svg class="star star-empty">
                        <use xlink:href="#star-empty"></use>
                      </svg>
									</div>
									<div class="author-detail">
										<div class="name text-dark text-uppercase pt-2">Jennie
											Rose</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div
						class="swiper-icon swiper-arrow swiper-arrow-next position-absolute d-flex align-items-center">
						<svg class="chevron-right">
                <use xlink:href="#chevron-right" />
              </svg>
					</div>
				</div>
			</div>
		</div>
		<div class="swiper-pagination"></div>
	</section>
	<section id="subscribe"
		class="container-grid padding-large position-relative overflow-hidden">
		<div class="container">
			<div class="row">
				<div
					class="subscribe-content bg-dark d-flex flex-wrap justify-content-center align-items-center padding-medium">
					<div class="col-md-6 col-sm-12">
						<div class="display-header pe-3">
							<h2 class="display-7 text-uppercase text-light">Subscribe Us
								Now</h2>
							<p>Get latest news, updates and deals directly mailed to your
								inbox.</p>
						</div>
					</div>
					<div class="col-md-5 col-sm-12">
						<form class="subscription-form validate">
							<div class="input-group flex-wrap">
								<input class="form-control btn-rounded-none" type="email"
									name="EMAIL" placeholder="Your email address here" required="">
								<button
									class="btn btn-medium btn-primary text-uppercase btn-rounded-none"
									type="submit" name="subscribe">Subscribe</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="instagram"
		class="padding-large overflow-hidden no-padding-top mb-3">
		<div class="container">
			<div class="row">
				<div
					class="display-header text-uppercase text-dark text-center pb-3">
					<h2 class="display-7">Shop Our Insta</h2>
				</div>
				<div class="d-flex flex-wrap">
					<figure class="instagram-item pe-2">
						<a href="https://templatesjungle.com/"
							class="image-link position-relative"> <img
							src="/ProjectShop/views/clients/assets/images/insta-item1.jpg"
							alt="instagram" class="insta-image">
							<div
								class="icon-overlay position-absolute d-flex justify-content-center">
								<svg class="instagram">
                    <use xlink:href="#instagram"></use>
                  </svg>
							</div>
						</a>
					</figure>
					<figure class="instagram-item pe-2">
						<a href="https://templatesjungle.com/"
							class="image-link position-relative"> <img
							src="/ProjectShop/views/clients/assets/images/insta-item2.jpg"
							alt="instagram" class="insta-image">
							<div
								class="icon-overlay position-absolute d-flex justify-content-center">
								<svg class="instagram">
                    <use xlink:href="#instagram"></use>
                  </svg>
							</div>
						</a>
					</figure>
					<figure class="instagram-item pe-2">
						<a href="https://templatesjungle.com/"
							class="image-link position-relative"> <img
							src="/ProjectShop/views/clients/assets/images/insta-item3.jpg"
							alt="instagram" class="insta-image">
							<div
								class="icon-overlay position-absolute d-flex justify-content-center">
								<svg class="instagram">
                    <use xlink:href="#instagram"></use>
                  </svg>
							</div>
						</a>
					</figure>
					<figure class="instagram-item pe-2">
						<a href="https://templatesjungle.com/"
							class="image-link position-relative"> <img
							src="/ProjectShop/views/clients/assets/images/insta-item4.jpg"
							alt="instagram" class="insta-image">
							<div
								class="icon-overlay position-absolute d-flex justify-content-center">
								<svg class="instagram">
                    <use xlink:href="#instagram"></use>
                  </svg>
							</div>
						</a>
					</figure>
					<figure class="instagram-item pe-2">
						<a href="https://templatesjungle.com/"
							class="image-link position-relative"> <img
							src="/ProjectShop/views/clients/assets/images/insta-item5.jpg"
							alt="instagram" class="insta-image">
							<div
								class="icon-overlay position-absolute d-flex justify-content-center">
								<svg class="instagram">
                    <use xlink:href="#instagram"></use>
                  </svg>
							</div>
						</a>
					</figure>
				</div>
			</div>
		</div>
	</section>
	<!-- Start - Footer -->
	<%@include file="/layout/Footer.jsp"%>
	<!-- End - Footer -->


	<script src="/ProjectShop/views/clients/assets/js/jquery-1.11.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<script type="text/javascript"
		src="/ProjectShop/views/clients/assets/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		src="/ProjectShop/views/clients/assets/js/plugins.js"></script>
	<script type="text/javascript"
		src="/ProjectShop/views/clients/assets/js/script.js"></script>
	<script>
		function cartDetail(product_id) {
			/* alert("Product added in cart"); */
			window.location = "/ProjectShop/cartDetail?product_id="
					+ product_id;
		}
	</script>
</body>
</html>