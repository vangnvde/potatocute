    <!-- Header Section Begin -->
    <jsp:include page="Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>Login</h2>
                        <p>Welcome to the PotatoesCute</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Login</h3>
                        <p class="text-success">${MESSAGESINGUP}</p>
                        <form action="LoginControll" method="post">
                            <div class="input__item">
                                <input type="text" name="user" required placeholder="Username"
                                        oninvalid="this.setCustomValidity('Enter username here')"
                                        oninput="this.setCustomValidity('')" style="color:#000" />                              
                                <span class="icon_mail"></span>                             
                            </div>                           
                            <div class="input__item">
                                <input type="password" placeholder="Password" name="pass" required
                                       oninvalid="this.setCustomValidity('Enter password here')"
                                        oninput="this.setCustomValidity('')" style="color:#000" />
                                <span class="icon_lock"></span>
                            </div>
                            <p class="text-danger">${MESSAGE}</p>
                            
                            <button type="submit" class="site-btn">Login Now</button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="login__register">
                        <h3>Don't Have An Account?</h3>
                        <a href="LoadSignupPage" class="primary-btn">Register Now</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Login Section End -->

    <!-- Footer Section Begin -->
    <jsp:include page="Footer.jsp"></jsp:include>

    <!-- Search model end -->

