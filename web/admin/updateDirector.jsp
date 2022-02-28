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
                            <h4>UPDATE: ${detailDirector.getNameDirector()} </h4>
                        </div>  
                        
                            <c:if test="${updateStatus}">
                                <p>Update Successful. Go back <a href='managedirector'>Manager Page.</a></p>
                            </c:if>

                            <form class="pc-form" action="updatedirector" method="post">
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="nameDirector">ID</label>
                                    <input type="text" name="idDirectorDisable" value="${detailDirector.getIdDirector()}" class="pc-form-text-field" disabled />
                                    <input type="hidden" name="idDirector" value="${detailDirector.getIdDirector()}" class="pc-form-text-field" />
                                </div>
                                
                                <div class="pc-form-item">
                                    <label class="pc-form-label" for="nameDirector">Name *</label>
                                    <input type="text" name="nameDirector" value="${detailDirector.getNameDirector()}" class="pc-form-text-field" placeholder="Tên phim ..." required />
                                </div>


                                <button type="submit" class="site-btn">Update</button>
                            </form>
                        </div>
                                
                        <a href="managedirector">Manage Director</a>
                    </div>
                    
                </div>
            </section>
        <!-- Product Section End -->

        
        <!-- Footer Section Begin -->
<jsp:include page="../Footer.jsp"></jsp:include>


