

<!-- Header Section Begin -->
<jsp:include page="Header.jsp"></jsp:include>
    <!-- Header End -->

    <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>Sign Up</h2>
                        <p>Welcome to the PotatoesCute</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Signup Section Begin -->
    <section class="signup spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="login__form">
                        <h3>Sign Up</h3>
                        <form action="SignupControll" method="post">
                            <div class="input__item">
                                <input value="${username}" type="text" name="username" placeholder="Username" required
                                       oninvalid="this.setCustomValidity('Enter your Username here')"
                                       oninput="this.setCustomValidity('')" style="color:#000" />
                                <span class="icon_profile"></span>
                                <p class="text-danger">${MESSAGEU}</p>
                        </div>
                        <div class="input__item">
                            <input value="${fullname}" type="text" name="fullname" placeholder="Your Fullname"required
                                   oninvalid="this.setCustomValidity('Enter Your Fullname here')"
                                   oninput="this.setCustomValidity('')" style="color:#000"/>
                            <span class="icon_mail"></span>

                        </div>

                        <div class="input__item">
                            <input type="password" name="password" placeholder="Password"required
                                   oninvalid="this.setCustomValidity('Enter password here')"
                                   oninput="this.setCustomValidity('')" style="color:#000"/>
                            <span class="icon_lock"></span>
                        </div>
                        <div class="input__item">
                            <input type="password" name="rePassword" placeholder="Confirm Password"required
                                   oninvalid="this.setCustomValidity('Enter comfirm password here')"
                                   oninput="this.setCustomValidity('')" style="color:#000"/>
                            <span class="icon_lock"></span>
                            <p class="text-danger">${MESSAGEP}</p>
                        </div>
                        <button type="submit" class="site-btn">Login Now</button>
                    </form>
                    <h5>Already have an account? <a href="LoadLoginPage">Log In!</a></h5>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="login__social__links">
                    <h3>Thanks for your Registion!!!</h3>
                    <img src="https://pics.me.me/thank-you-so-much-troll-me-thanks-memes-52285154.png">
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Signup Section End -->

<!-- Footer Section Begin -->
<jsp:include page="Footer.jsp"></jsp:include>


