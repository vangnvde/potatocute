<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Breadcrumb Begin -->

    <!-- Breadcrumb End -->

    <!-- Anime Section Begin -->
    <section class="anime-details spad">
        <div class="container">
            <div class="anime__details__content">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="anime__details__pic set-bg" data-setbg=${o.getPoster()}>

                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="anime__details__text row">
                        <div class="anime__details__title col-md-9">
                            <h3>${o.getNameFilm()}</h3>                             
                        </div>
                        <div class="anime__details__rating col-md-3">
                            <a style=" font-size:30px ; color:greenyellow;  font-weight: bold;">${o.getTotalReview()}% </a><img style="width: 50px;" src="img/potato.png"></div>                           
                    </div>
                    <p>${o.getDescriptionFilm()}</p>
                    <div class="anime__details__widget">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <ul>
                                    <li><span>Type:</span>${o.getType()}</li>
                                    <li><span>Studios:</span>${o.getDistributor()}</li>
                                    <li><span>Director:</span>${o.getDirector()}</li>
                                    <li><span>Year:</span>${o.getYear()}</li>

                                </ul>
                            </div>
                            <div class="col-lg-6 col-md-6">
                                <ul>
                                    <li><span>Duration:</span>${o.getTime()}</li> 
                                    <li><span>Quality:</span>4K</li>
                                    <li><span>Like Review:</span>${o.getLikeReview()}</li>
                                    <li><span>Unlike Review:</span>${o.getUnlikeReview()}</li>                                                                                                                                
                                </ul>
                            </div>
                        </div>
                    </div>
                    
                    <c:if test="${sessionScope.User == null}">
                        <p class="pc-login-recommend">Bạn muốn review phim này ? <a href="LoadLoginPage">Đăng nhập ngay !</a></p>
                    </c:if>
                                
                    <c:if test="${sessionScope.User != null}">
                        <c:if test="${r == null}">
                            <div class="anime__details__btn">
                                <a href="ReviewFilmControll?idF=${o.getId()}&idU=${sessionScope.User.getId()}&review=1" class="follow-btn"><i class="fa fa-heart-o"></i>Like</a>
                                <a href="ReviewFilmControll?idF=${o.getId()}&idU=${sessionScope.User.getId()}&review=0" class="follow-btn"><i class="fa fa-heart-o"></i>Dislike</a>                                 
                            </div>
                        </c:if>
                        <c:if test="${r != null}">
                            <div class="anime__details__btn">
                                <a href="removereview?idF=${o.getId()}&idU=${sessionScope.User.getId()}&isLike=${r.isLike}" class="follow-btn"><i class="fa fa-heart-o"></i> <c:if test="${r.isLike==1}">Unliked</c:if><c:if test="${r.isLike==0}">Undisliked</c:if></a>                               
                            </div>
                        </c:if>

                    </c:if>  
                </div>
            </div>
        </div>
                                
    </div>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-lg-8 col-md-8">
            
            <div class="anime__details__review">
                <div class="section-title">
                    <h5>Official Trailer</h5>
                </div>
                <c:if test="${e != null}">
                    <center>
                        <iframe width="720" height="405 " src="${e.getLinkTrailer()}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                    </center>
                </c:if>
                <c:if test="${e == null}">
                    <center>
                        <p>Phim hiện chưa có Trailer. Chúng tôi sẽ cố gắng cập nhật sớm nhất có thể để phục vụ các bạn.</p>
                    </center>
                    <c:if test="${sessionScope.User.isIsAdmin() == true}">
                        <div class="anime__details__form">
                            <div class="section-title">
                                <h5>Add Link Trailer (Only for Admin)</h5>
                            </div>
                            <form action="TrailerControll" method="post">
                                <textarea  name="fullTrailer" placeholder="Trailer's Link"></textarea>
                                <input type="hidden" name="idF" value="${o.getId()}">
                                <button type="submit"><i class="fa fa-location-arrow"></i> Add</button>
                            </form></div>

                    </c:if>
                </c:if>

            </div>
            
            <div class="anime__details__review">
                <div class="section-title">
                    <h5>Reviews</h5>
                </div>
                <c:forEach items="${listC}" var="e">
                    <div class="anime__review__item">
                        <div class="anime__review__item__pic">
                            <img src="https://d1nhio0ox7pgb.cloudfront.net/_img/o_collection_png/green_dark_grey/256x256/plain/user.png" alt="">
                        </div>
                        <div class="anime__review__item__text">
                            <h6>${e.getFullNameUser()} @${e.getUsername()} - <span>Chuyên gia</span></h6>
                            <p>${e.getFullComment()}</p>
                        </div>
                    </div>
                </c:forEach>


            </div>
            <c:if test="${sessionScope.User.isExpert == true}">
                <div class="anime__details__form">
                    <div class="section-title">
                        <h5>Your Comment</h5>
                    </div>
                    <form action="CommentControll" method="post">
                        <textarea  name="fullComment" placeholder="Your Comment"></textarea>
                        <input type="hidden" name="idF" value="${o.getId()}">
                        <input type="hidden" name="idUser" value="${sessionScope.User.id}">
                        <button type="submit"><i class="fa fa-location-arrow"></i> Review</button>
                    </form>
                </div>
            </c:if>
        </div>             
    </div>
</div>
</section>
<!-- Anime Section End -->

<!-- Footer Section Begin -->
<jsp:include page="Footer.jsp"></jsp:include>
<!-- Footer Section End -->

<!-- Search model Begin -->

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