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
                        <h4>UPDATE: ${detailFilm.getNameFilm()}</h4>
                </div>   

                <c:if test="${updateStatus}">
                    <p>Update Successful. Go back  <a href='managefilm'>Manage Page</a></p>
                </c:if>

                <form class="pc-form" action="updatefilm" method="post">
                    <div class="pc-form-item">
                        <label class="pc-form-label" for="nameFilm">ID</label>
                        <input type="text" name="idFilmDisable" value="${detailFilm.getId()}" class="pc-form-text-field" disabled />
                        <input type="hidden" name="idFilm" value="${detailFilm.getId()}" class="pc-form-text-field" />
                    </div>

                    <div class="pc-form-item">
                        <label class="pc-form-label" for="nameFilm">Name *</label>
                        <input type="text" name="nameFilm" value="${detailFilm.getNameFilm()}" class="pc-form-text-field" placeholder="Tên phim ..." required />
                    </div>

                    <div class="pc-form-item">
                        <label class="pc-form-label" for="Film">Description *</label>
                        <textarea name="descriptionFilm" class="pc-form-textarea" required>${detailFilm.getDescriptionFilm()}</textarea>
                    </div>

                    <div class="pc-form-item">
                        <label class="pc-form-label" for="poster">Poster *</label>
                        <input type="text" name="poster" value="${detailFilm.getPoster()}" class="pc-form-text-field" placeholder="Poster ..." required />
                    </div>

                    <div class="pc-form-item">
                        <label class="pc-form-label" for="time">Time*</label>
                        <input type="text" name="time" value="${detailFilm.getTime()}" class="pc-form-text-field" placeholder="Thời gian ..." required />
                    </div>

                    <div class="pc-form-item">
                        <label class="pc-form-label" for="time">Year *</label>
                        <input type="text" name="year" value="${detailFilm.getYear()}" class="pc-form-text-field" placeholder="Năm sản xuất ..." required />
                    </div>
                    <br>
                    <div class="pc-form-item row">
                        <label class="pc-form-label col-md-2" for="time">Type</label>
                        <select name="idType" class="pc-form-selection ">
                            <c:forEach items="${listFilmType}" var="o">
                                <option value="${o.idType}" <c:if test="${o.idType == detailFilm.getId()}">selected</c:if>>${o.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="pc-form-item row">
                        <label class="pc-form-label col-md-2" for="time">Director</label>
                        <select name="idDirector" class="pc-form-selection ">
                            <c:forEach items="${listDirector}" var="o">
                                <option value="${o.idDirector}" <c:if test="${o.nameDirector == detailFilm.getDirector()}">selected</c:if>>${o.nameDirector}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="pc-form-item row">
                        <label class="pc-form-label col-md-2" for="time">Distributor</label>
                        <select name="idDistributor" class="pc-form-selection ">
                            <c:forEach items="${listDistributor}" var="o">
                                <option value="${o.idDistributor}" <c:if test="${o.nameDistributor == detailFilm.getDistributor()}">selected</c:if>>${o.nameDistributor}</option>
                            </c:forEach>
                        </select>
                    </div>


                    <br><br>
                    <button type="submit" class="site-btn">Update</button>
                </form>
            </div>
            <br>
            <a href="managefilm">Manage Film</a>
        </div>

    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


