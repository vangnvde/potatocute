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
                        <h4>MANAGE DIRECTOR</h4>
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
                        <c:forEach items="${listAllDirector}" var="o">
                            <tr>
                                <td>${o.idDirector}</td>
                                <td>${o.nameDirector}</td>
                                <td><a href="updatedirectorload?directorID=${o.idDirector}"><img style="width: 25px" src="img/edit.png"/></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <a href="adddirectorload"  class="site-btn " ><span>Add Director</span></a>

        </div>

    </div>
</section>
<!-- Product Section End -->


<!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>
