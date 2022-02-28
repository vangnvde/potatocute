<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">

            <div class="row">
                <div class="pc-form-container">
                    <div class="section-title">
                        <h4>ADD FILM</h4>
                    </div> 

                    <form class="pc-form" action="addfilm">
                        <div class="pc-form-item">
                            <label class="pc-form-label" for="nameFilm">Film Name*</label>
                            <input type="text" name="nameFilm" class="pc-form-text-field" placeholder="Tên phim ..." required />
                        </div>

                        <div class="pc-form-item">
                            <label class="pc-form-label" for="descriptionFilm">Description *</label>
                            <textarea name="descriptionFilm" class="pc-form-textarea" required></textarea>
                        </div>

                        <div class="pc-form-item">
                            <label class="pc-form-label" for="poster">Poster *</label>
                            <input type="text" name="poster" class="pc-form-text-field" placeholder="Poster ..." required />
                        </div>

                        <div class="pc-form-item">
                            <label class="pc-form-label" for="time">Time *</label>
                            <input type="text" name="time" class="pc-form-text-field" placeholder="Thời gian ..." required />
                        </div>

                        <div class="pc-form-item ">
                            <label class="pc-form-label" for="time">Year *</label>
                            <input type="text" name="year" class="pc-form-text-field" placeholder="Năm sản xuất ..." required />
                        </div>   
                        <br>
                        <div class="pc-form-item row">                                  
                            <label class="pc-form-label col-md-2" for="time">Type</label>
                            <select name="idType" class="pc-form-selection col-md-2">
                            <c:forEach items="${listFilmType}" var="o">
                                <option value="${o.idType}">${o.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="pc-form-item row">
                        <label class="pc-form-label col-md-2" for="time">Director</label>
                        <select name="idDirector" class="pc-form-selection">
                            <c:forEach items="${listDirector}" var="o">
                                <option value="${o.idDirector}">${o.nameDirector}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="pc-form-item row">
                        <label class="pc-form-label col-md-2" for="time">Distributor</label>
                        <select name="idDistributor" class="pc-form-selection">                                        
                            <c:forEach items="${listDistributor}" var="o">
                                <option value="${o.idDistributor}">${o.nameDistributor}</option>
                            </c:forEach>
                        </select>
                    </div>
                        <br>
                    <button type="submit" class="site-btn">Thêm mới</button>
                </form>
            </div>
        </div>
        <a href="managefilm">Quản lý Film</a>
        <a href="managefilmtype">Quản lý Thể loại</a>
    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


