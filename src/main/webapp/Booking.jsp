<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Train Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        .header {
            background-image: url('background.jpg');
            background-size: cover; /* Scale the image to cover the entire area */
            background-position: top; /* Center the image */
            background-repeat: no-repeat; /* Prevent the image from repeating */
            background-color: rgb(255, 255, 255);
            padding: 20px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .header h1 {
            margin: 0;
        }

        .search-bar {
            background-color: #333;
            padding: 20px;
            color: white;
        }

        .search-bar form {
            display: flex;
            gap: 10px;
            align-items: center;
        }

        .search-bar select,
        .search-bar input,
        .search-bar button {
            padding: 10px;
            border: none;
            border-radius: 5px;
        }

        .search-bar button {
            background-color: #ff6b6b;
            color: white;
            cursor: pointer;
        }

        .train-list {
            margin: 20px;
        }

        .train-card {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 8px;
            margin-bottom: 20px;
            padding: 20px;
        }

        .train-card .train-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 10px;
        }

        .train-card .train-header h2 {
            margin: 0;
        }

        .train-card .train-details {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }

        .train-card .class-info {
            display: flex;
            gap: 20px;
            justify-content: space-evenly;
            margin-top: 20px;
        }

        .class-info button {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background-color: rgb(72, 102, 128);
            color: white;
            border: none;
            border-radius: 8px;
            padding: 10px 90px;
            font-size: 14px;
            cursor: pointer;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
            width: 120px; /* Fixed button width */
            height: 100px; /* Fixed button height */
        }

        .class-info button:hover {
            background-color: #ff6b6b;
            transform: scale(1.05);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .class-info button h4 {
            margin: 5px 0;
            font-size: 16px;
        }

        .class-info button p {
            margin: 0;
            font-size: 12px;
        }

        .free-cancellation {
            color: #d12b2b;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>Get Your Tickets</h1>
    <nav>
        <a href="#" style="color: white; text-decoration: none;">Help</a>
    </nav>
</div>

<div class="search-bar">
    <form>
        <input type="text" placeholder="From Station">
        <input type="text" placeholder="To Station">
        <input type="date">
        <button type="submit">Search</button>
    </form>
</div>

<div class="train-list">
    <div class="train-card">
        <p class="free-cancellation">Opt-in for Free Cancellation</p>
        <div class="train-header">
            <h2>22160 MAS CSMT SF Exp</h2>
            <p>01:15 PM to 10:47 AM</p>
        </div>
        <div class="train-details">
            <p>Duration: 21h 32m</p>
            <p>MAS to KYN</p>
        </div>
        <div class="class-info">
            <button>
                <h4>SL</h4>
                <p>Rs.580</p>
                <p>GNWL 7</p>
            </button>
            <button>
                <h4>3A</h4>
                <p>Rs.1525</p>
                <p>RAC 31</p>
            </button>
            <button>
                <h4>2A</h4>
                <p>Rs.2175</p>
                <p>RAC 3</p>
            </button>
        </div>
    </div>

    <div class="train-card">
        <p class="free-cancellation">Opt-in for Free Cancellation</p>
        <div class="train-header">
            <h2>12164 MAS LTT SF Exp</h2>
            <p>06:20 PM to 02:17 PM</p>
        </div>
        <div class="train-details">
            <p>Duration: 19h 57m</p>
            <p>MAS to KYN</p>
        </div>
        <div class="class-info">
            <button>
                <h4>SL</h4>
                <p>Rs.580</p>
                <p>GNWL 7</p>
            </button>
            <button>
                <h4>3A</h4>
                <p>Rs.1525</p>
                <p>RAC 31</p>
            </button>
            <button>
                <h4>2A</h4>
                <p>Rs.2175</p>
                <p>RAC 3</p>
            </button>
        </div>
    </div>
</div>

</body>
</html>
