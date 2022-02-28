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
                        <h4>UPDATE: ${detailFilmType.getTypeName()}</h4>
                </div>   

                <c:if test="${updateStatus}">
                    <p>Update Successful. Go back  <a href='managefilmtype'>Manage Page</a></p>
                </c:if>

                <form class="pc-form" action="updatefilmtype" method="post">
                    <div class="pc-form-item">
                        <label class="pc-form-label" for="nameFilmType">ID</label>
                        <input type="text" name="idFilmTypeDisable" value="${detailFilmType.getIdType()}" class="pc-form-text-field" disabled />
                        <input type="hidden" name="idFilmType" value="${detailFilmType.getIdType()}" class="pc-form-text-field" />
                    </div>

                    <div class="pc-form-item">
                        <label class="pc-form-label" for="nameFilmType">Name *</label>
                        <input type="text" name="nameFilmType" value="${detailFilmType.getTypeName()}" class="pc-form-text-field" placeholder="Nhà sản xuất ..." required />
                    </div>

                    <br><br>
                    <button type="submit" class="site-btn">Update</button>
                </form>
            </div>

            <a href="managefilmtype">Manage FilmType</a>
        </div>

    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


