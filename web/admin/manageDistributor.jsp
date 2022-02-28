<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="../Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Product Section Begin -->
    <section class="product spad">
        <div class="container">

            <div style="align-items: center">
                <div class="pc-table-container">
                    <div class="section-title">
                        <h4>MANAGE DISTRIBUTOR</h4>
                    </div>  

                    <table class="table table-striped table-dark" style="border-radius: 10px">
                        <thead>
                            <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Option</td>
                            </tr>
                        </thead>

                        <tbody>
                        <c:forEach items="${listAllDistributor}" var="o">
                            <tr>
                                <td>${o.idDistributor}</td>
                                <td>${o.nameDistributor}</td>
                                <td><a href="updatedistributorload?distributorID=${o.idDistributor}"><img style="width: 25px" src="img/edit.png"/></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="adddistributorload"  class="site-btn " ><span>Add Distributor</span></a>

        </div>

    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>
