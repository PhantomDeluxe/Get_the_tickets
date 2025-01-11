<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Advanced Login Page</title>
    <link rel="stylesheet" href="style.css">
    <script>
        function showForm(formType) {
            document.getElementById('login-box').style.display = formType === 'login' ? 'block' : 'none';
            document.getElementById('signup-box').style.display = formType === 'signup' ? 'block' : 'none';
        }

        // Show login form by default
        window.onload = () => showForm('login');
    </script>
</head>
<body>
<!-- Top Section with Logo and Website Name -->
<header>
    <div class="logo-section">
        <img src="TrainLogo.jpg" alt="Website Logo" class="logo">
        <div class="site-name">Get the Tickets</div>
    </div>
</header>

<!-- Main Container -->
<div class="container">
    <!-- Login Form Section -->
    <div id="login-box" class="form-box">
        <div class="avatar">
            <img src="avatar 2.jpg" alt="User Avatar">
        </div>
        <h2>Login</h2>
        <form action="helloservlet" method="post">
            <div class="input-box">
                <input type="text" name="name" required>
                <label>Username</label>
            </div>
            <div class="input-box">
                <input type="password" name="password" required>
                <label>Password</label>
            </div>

                <button type="submit" class="login-btn">Login</button>

            <!-- Links Section -->
            <div class="links-section">
                <a href="#">Forgot your password?</a>
                <p>Don't have an account? <a href="#" onclick="showForm('signup')">Sign Up</a></p>
            </div>
        </form>
    </div>

    <!-- Sign Up Form Section -->
    <div id="signup-box" class="form-box" style="display: none;">
        <div class="avatar">
            <img src="avatar 2.jpg" alt="User Avatar">
        </div>
        <h2>Sign Up</h2>
        <form action="signup" method="post">
            <div class="input-box">
                <input type="text" name="username" required>
                <label>Username</label>
            </div>
            <div class="input-box">
                <input type="email" name="email" required>
                <label>Email</label>
            </div>
            <div class="input-box">
                <input type="password" name="password" required>
                <label>Password</label>
            </div>
            <div class="input-box">
                <input type="password" name="confirm_password" required>
                <label>Confirm Password</label>
            </div>
            <button type="submit" class="login-btn" >Sign Up</button>

            <!-- Links Section -->
            <div class="links-section">
                <p>Already have an account? <a href="#" onclick="showForm('login')">Login</a></p>
            </div>
        </form>
    </div>
</div>
</body>
</html>

