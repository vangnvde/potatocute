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
                        <h4>ADD DIRECTOR</h4>
                    </div>  

                    <form class="pc-form" action="adddirector">
                        <div class="pc-form-item">
                            <label class="pc-form-label" for="nameDirector">Director Name *</label>
                            <input type="text" name="nameDirector" class="pc-form-text-field" placeholder="Director Name ..." required />
                        </div>
                        <br><br>
                        <button type="submit" class="site-btn">Add New</button>
                    </form>
                </div>
            </div>
            <br>
            <a href="managedirector">Manage Director</a>
        </div>
    </section>
    <!-- Product Section End -->


    <!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


