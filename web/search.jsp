<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
            <!-- Header End -->

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    <div class="row">
                        <!-- full film-->
                        <div class="col-lg-8">                   
                            <div class="popular__product">
                                <div class="row">
                                    <div class="col-lg-8 col-md-8 col-sm-8">
                                        <div class="section-title">
                                            <h4>Search Results</h4>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4">
                                    <c:if test="${searchFilmList == 0}">
                                        <div class="btn__all">
                                            <a href="home?viewAll=1" class="primary-btn">View All <span class="arrow_right"></span></a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <c:if test="${listFull == 1}">
                                    <c:forEach items="${listFilmPopular}" var="o">

                                        <div class="col-lg-4 col-md-6 col-sm-6">                          
                                            <div class="product__item">
                                                <div class="product__item__pic set-bg" data-setbg=${o.getPoster()}>                                 
                                                    <div class="ep" style="background-color: greenyellow;"><a style="color: black; font-weight: bold;">${o.getTotalReview()}% </a><img style="width: 30px;" src="img/potato.png"></div>
                                                    <div class="comment"><i class="fa fa-comments"></i> 11</div>
                                                    <div class="view"><i class="fa fa-eye"></i>${o.getUnlikeReview()+o.getLikeReview()}</div>
                                                </div>                                   
                                                <div class="product__item__text">
                                                    <ul>
                                                        <li>${o.getType()}</li>
                                                    </ul>
                                                    <h5><a href="LoadFilmDetail?idF=${o.getId()}">${o.getNameFilm()}</a></h5>
                                                </div>
                                            </div> 
                                        </div>
                                    </c:forEach>
                                </c:if> 
                                <c:forEach items="${listFilmPopular}" var="o" begin = "0" end = "20">
                                    <div class="col-lg-4 col-md-6 col-sm-6">                          
                                        <div class="product__item">
                                            <div class="product__item__pic set-bg" data-setbg=${o.getPoster()}>                                 
                                                <div class="ep" style="background-color: greenyellow;"><a style="color: black; font-weight: bold;">${o.getTotalReview()}% </a><img style="width: 25px;" src="img/potato.png"></div>
                                                <div class="comment"><i class="fa fa-comments"></i> 11</div>
                                                <div class="view"><i class="fa fa-eye"></i> ${o.getUnlikeReview()+o.getLikeReview()}</div>
                                            </div>                                   
                                            <div class="product__item__text">
                                                <ul>
                                                    <li>${o.getType()}</li>
                                                </ul>
                                                <h5><a href="LoadFilmDetail?idF=${o.getId()}">${o.getNameFilm()}</a></h5>
                                            </div>
                                        </div> 
                                    </div>
                                </c:forEach>
                            </div>
                        </div>                  
                    </div>

                    <!-- full film-->
                    <div class="col-lg-4 col-md-6 col-sm-8">
                        <div class="product__sidebar">
                            <div class="product__sidebar__view">
                                <div class="section-title">
                                    <h5>Top Rating</h5>
                                </div>
                                <ul class="filter__controls">
                                    <li class="active" data-filter=".rating">Rating</li>
                                </ul>
                                <c:forEach items="${listFilmTopRating}" var="o">
                                    <div class="filter__gallery">
                                        <div class="product__sidebar__view__item set-bg mix rating" data-setbg=${o.getPoster()}>
                                            <div class="ep" style="background-color: greenyellow;"><a style="color: black; font-weight: bold;">${o.getTotalReview()}% </a><img style="width: 25px;" src="img/potato.png"></div>
                                            <div class="view"><i class="fa fa-eye"></i> ${o.getUnlikeReview()+o.getLikeReview()}</div>
                                            <h5><a href="LoadFilmDetail?idF=${o.getId()}">${o.getNameFilm()}</a></h5>
                                        </div>
                                    </div>
                                </c:forEach> 
                            </div>
                            <div class="product__sidebar__view">
                                <div class="section-title">
                                    <h5>Top View</h5>
                                </div>
                                <ul class="filter__controls">
                                    <li class="active" data-filter=".rating">View</li>
                                </ul>
                                <c:forEach items="${listFilmTopView}" var="o">
                                    <div class="filter__gallery">
                                        <div class="product__sidebar__view__item set-bg mix view" data-setbg=${o.getPoster()}>
                                            <div class="ep" style="background-color: greenyellow;"><a style="color: black; font-weight: bold;">${o.getTotalReview()}% </a><img style="width: 25px;" src="img/potato.png"></div>
                                            <div class="view"><i class="fa fa-eye"></i> ${o.getUnlikeReview()+o.getLikeReview()}</div>
                                            <h5><a href="LoadFilmDetail?idF=${o.getId()}">${o.getNameFilm()}</a></h5>
                                        </div>
                                    </div>
                                </c:forEach>  
                            </div>
                            <div class="product__sidebar__comment">
                                <div class="section-title">
                                    <h5>New Comment</h5>
                                </div>
                                <c:forEach items="${listNewComment}" var="o" begin = "0" end = "4">
                                    <div class="product__sidebar__comment__item">
                                        <div class="product__sidebar__comment__item__pic">
                                            <img src="${o.getPoster()}" alt="" style="width: 90px; height: 130px">
                                        </div>
                                        <div class="product__sidebar__comment__item__text"x>
                                            <h5><a href="LoadFilmDetail?idF=${o.getIdFilm()}">${o.getNameFilm()}</a></h5>
                                            <span style="font-weight: bold;">${o.getFullNameUser()}</span>
                                            <span>${o.getFullComment()}</span>
                                        </div>
                                    </div>
                                </c:forEach>                           
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

        <!-- Footer Section Begin -->
        <jsp:include page="Footer.jsp"></jsp:include>

        <!-- Search model end -->

        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/player.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>

    
</body>

</html>