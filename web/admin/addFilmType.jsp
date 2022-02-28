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
                        <h4>ADD TYPE</h4>
                    </div>  
                    <form class="pc-form" action="addfilmtype">
                        <div class="pc-form-item">
                            <label class="pc-form-label" for="typeName">Type Name *</label>
                            <input type="text" name="typeName" class="pc-form-text-field" placeholder="Tên thể loại ..." required />
                        </div>
                        <br><br>
                        <button type="submit" class="site-btn">Add</button>
                    </form>
                </div>
            </div>
            <a href="managefilmtype">Manage Type</a>
        </div>
    </section>
    <!-- Product Section End -->


    <!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


