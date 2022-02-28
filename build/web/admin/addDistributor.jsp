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
                        <h4>ADD DISTRIBUTOR</h4>
                    </div>  

                    <form class="pc-form" action="adddistributor">
                        <div class="pc-form-item">
                            <label class="pc-form-label" for="nameDistributor">Distributor Name *</label>
                            <input type="text" name="nameDistributor" class="pc-form-text-field" placeholder="Distributor ..." required />
                        </div>
                        <br><br>
                        <button type="submit" class="site-btn">Add New</button>
                    </form>
                </div>
            </div>
            <br>
            <a href="managedistributor">Manage Distributor</a>
        </div>
    </section>
    <!-- Product Section End -->


    <!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


