<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Train Ticket Booking</title>
    <style>
        body {
            margin: 0;
            font-family: 'Roboto', Arial, sans-serif;
            background-color: #f5f5f5;
        }

        header {
            background-color: #d23c3c;
            padding: 15px 30px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        header h2 {
            display: flex;
            align-items: center;
        }

        header img {
            width: 60px;
            height: 60px;
            margin-right: 10px;
            border-radius: 50%;
        }

        header a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-weight: bold;
        }

        header a:hover {
            text-decoration: underline;
        }

        .hero {
            position: relative;
            text-align: center;
            color: white;
            height: 350px;
            background-image: url('background.jpg');
            background-size: cover; /* Scale the image to cover the entire area */
            background-position: top; /* Center the image */
            background-repeat: no-repeat; /* Prevent the image from repeating */
            background-color: rgb(255, 255, 255);
        }


        .hero-overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
        }

        .hero h1 {
            position: relative;
            top: 50%;
            transform: translateY(-50%);
            font-size: 3em;
            z-index: 2;
        }

        .search-box {
            background-color: rgba(250, 250, 250, 0.95);
            padding: 40px;
            border-radius: 12px;
            position: absolute;
            top: 51%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 100%;
            max-width: 1210px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;
            gap: 20px;
            z-index: 3;
        }

        .search-box form {
            display: grid;
            grid-template-columns: repeat(6, 1fr);
            gap: 15px;
            align-items: center;
        }

        .search-box input,
        .search-box select,
        .search-box button {
            padding: 15px;
            font-size: 1em;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        .search-box input:focus,
        .search-box select:focus,
        .search-box button:focus {
            outline: none;
            border-color: #d23c3c;
        }

        .search-box button {
            background-color: #d23c3c;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .search-box button:hover {
            background-color: #b53030;
        }

        .features {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            gap: 30px;
            background-color: #fff;
            padding: 50px;
            margin: 40px auto;
            width: 90%;
            max-width: 1100px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .features div {
            text-align: center;
            padding: 20px;
            border-radius: 8px;
            background-color: #f9f9f9;
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .features div:hover {
            transform: translateY(-10px);
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
        }

        .features div img {
            width: 60px;
            height: 60px;
            margin-bottom: 15px;
        }

        footer {
            background-color: #d23c3c;
            color: white;
            padding: 30px 0;
            text-align: center;
            margin-top: 40px;
        }

        footer a {
            color: #ffdbdb;
            text-decoration: none;
            margin: 0 10px;
        }

        footer a:hover {
            text-decoration: underline;
        }

        @media (max-width: 768px) {
            .search-box form {
                grid-template-columns: 1fr;
            }

            .features {
                grid-template-columns: repeat(2, 1fr);
            }
        }

        @media (max-width: 480px) {
            .features {
                grid-template-columns: 1fr;
            }

            .hero h1 {
                font-size: 2em;
            }
        }
    </style>
</head>
<body>
<header>
    <div>
        <h2>
            <img src="TrainLogo.jpg" alt="Logo"> Get Your Tickets
        </h2>
    </div>
    <div>
        <a href="#">Help</a>
        <a href="#">Print/SMS Ticket</a>
        <a href="http://localhost:8080/Get_the_tickets_war_exploded/cancel">Cancel Ticket</a>
        <a href="http://localhost:8080/Get_the_tickets_war_exploded/previhaan">RailXplor</a>
    </div>
</header>

<div class="hero">
    <div class="hero-overlay"></div>
    <h1>Train Ticket Booking</h1>
</div>

<div class="search-box">
    <form action="hiservlet" method="post">
        <select>
            <option>From(City/Station)</option>
            <option>Chennai</option>
        </select>
        <select>
            <option>From(City/Station)</option>
            <option>Coimbatore</option>
            <option>Hyderabad</option>
            <option>Bengaluru</option>
        </select>
        <input type="date">
        <select>
            <option>Class</option>
            <option>AC First Class</option>
            <option>Sleeper Class</option>
            <option>Second Class</option>
        </select>
        <input type="number" placeholder="Passengers" min="1">
        <button type="submit">Search Trains</button>
    </form>
</div>

<div class="features">
    <div>
        <img src="Special logo.png" alt="Feature 1">
        <p>3X refund for waitlisted tickets</p>
    </div>
    <div>
        <img src="Special logo.png" alt="Feature 2">
        <p>Free cancellation policy</p>
    </div>
    <div>
        <img src="Special logo.png" alt="Feature 3">
        <p>redRail Confirm feature</p>
    </div>
    <div>
        <img src="Special logo.png" alt="Feature 4">
        <p>Exclusive discounts and offers</p>
    </div>
</div>

<footer>
    <p>&copy; 2024 redBus. All rights reserved. | <a href="#">Terms of Service</a> | <a href="#">Privacy Policy</a></p>
</footer>
</body>
</html>
