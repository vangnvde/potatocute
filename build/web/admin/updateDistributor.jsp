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
                            <h4>UPDATE: ${detailDistributor.getNameDistributor()}</h4>
                        </div>  
                        
                            <c:if test="${updateStatus}">
                                <p>Update Successful. Go back <a href='managedistributor'>Manage Page</a></p>
                            </c:if>

                            <form class="pc-form" action="updatedistributor" method="post">
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="nameDistributor">ID</label>
                                    <input type="text" name="idDistributorDisable" value="${detailDistributor.getIdDistributor()}" class="pc-form-text-field" disabled />
                                    <input type="hidden" name="idDistributor" value="${detailDistributor.getIdDistributor()}" class="pc-form-text-field" />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="nameDistributor">Name *</label>
                                    <input type="text" name="nameDistributor" value="${detailDistributor.getNameDistributor()}" class="pc-form-text-field" placeholder="Nhà sản xuất ..." required />
                                </div>


                                <button type="submit" class="site-btn">Cập nhật</button>
                            </form>
                        </div>
                                
                        <a href="managedistributor">Quản lý Distributor</a>
                    </div>
                    
                </div>
            </section>
        <!-- Product Section End -->

        
        <!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


