$(document).ready(() => {
    $('#searchForm').on('submit', (e) => {
        let searchText = $('#searchText').val();
        getMovies(searchText);
        e.preventDefault();
    });
});

$(document).ready(() => {
    $('#searchForm2').on('submit', (f) => {
        let searchZip = $('#searchZip').val();
        let searchDate = $('#searchDate').val();
        getTheaters(searchZip, searchDate);
        f.preventDefault();
    });
});

$('#toggle').click(function(){
    $('.page-header').slideToggle(500);
});

$('.page-header').hide();


function getTheaters(searchZip, searchDate) {
    axios.get('http://data.tmsapi.com/v1.1/movies/showings?startDate=' + searchDate + '&zip=' + searchZip + '&radius=25&api_key=6gypawk2vqkakzfyyd3s5pqj')
        .then((response) => {
            console.log(response);
            let movies2 = response.data;
            let output = '';
            $.each(movies2, (index, movie1) => {
                let movietitle = movie1.title;
                axios.get('http://www.omdbapi.com/?apikey=a85b3fc2&t=' + movietitle)
                    .then((response) => {
                        console.log(response);
                        let thePoster = response.data;
                        let posterUrl = thePoster.Poster;
                        sessionStorage.setItem('pUrl', posterUrl);
                    });
                $.each(movie1.showtimes, (c, times) => {
                    let finalUrl = sessionStorage.getItem('pUrl');
                    output +=` 
                        <div class="col-md-3">
                            <div class="container text-center">
                                <img src="${finalUrl}" alt="No poster found!"/>
                                <h5>${movie1.title}</h5>                        
                                <h6>${times.dateTime}</h6>
                                <h6>${times.theatre.name}</h6>
                            </div>
                        </div>
                    `;
                });
            });

            $('#showtimes').html(output);
        });
}

//Credit to Traversy Media on YouTube for help with this section
function getMovies(searchText) {
    axios.get('http://www.omdbapi.com/?apikey=a85b3fc2&s=' + searchText)
        .then((response) => {
           console.log(response);
           let movies = response.data.Search;
           let output = '';
           $.each(movies, (index, movie) => {
               console.log(movie);
                output +=`
                <div class="col-md-3">
                    <div class="well text-center">
                        <img src="${movie.Poster}"/>
                        <h5>${movie.Title}</h5>
                        <a onclick="movieSelected('${movie.imdbID}')" class="btn btn-primary" href="#">Movie Details</a>
                    </div>
                </div>
                `;
           });
           
           $('#movies').html(output);
        });
        
}

function movieSelected(id) {
    sessionStorage.setItem('movieId', id);
    window.location = 'movie.html';
    return false;
}

function getMovie() {
    let movieId = sessionStorage.getItem('movieId');

    axios.get('http://www.omdbapi.com/?apikey=a85b3fc2&i=' + movieId)
    .then((response) => {
        console.log(response);
        let movie = response.data;
        let output =`
            <div class="row">
                <div class="col-md-4">
                    <img src="${movie.Poster}" class="thumbnail"/>
                </div>
                <div class="col-md-8">
                    <h2>${movie.Title}</h2>
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Genre:</strong> ${movie.Genre}</li>
                        <li class="list-group-item"><strong>Released:</strong> ${movie.Released}</li>
                        <li class="list-group-item"><strong>Rating:</strong> ${movie.Rated}</li>
                        <li class="list-group-item"><strong>Runtime:</strong> ${movie.Runtime}</li>
                        <li class="list-group-item"><strong>Director(s):</strong> ${movie.Director}</li>
                        <li class="list-group-item"><strong>Writer(s):</strong> ${movie.Writer}</li>
                        <li class="list-group-item"><strong>Production Studio:</strong> ${movie.Production}</li>
                        <li class="list-group-item"><strong>IMDB Rating:</strong> ${movie.imdbRating}</li>
                        <li class="list-group-item"><strong>Metacritic Score:</strong> ${movie.Metascore}</li>
                    </ul>
                </div>
            </div>
            <br>
            <br>
            <div class="row">
                <div class="well">
                    <h4>Plot Synopsis</h4>
                    <p id="plot">${movie.Plot}</p>
                    <hr>
                    <a href="https://www.imdb.com/title/${movie.imdbID}" target="_blank" class="btn btn-primary">IMDB Page</a>
                    <a href="index.html" class="btn btn-default">Back to Search</a>
                </div>
            </div>
        `;

        $('#movie').html(output);
    
    });
       
    
}

document.getElementById('reviewForm').addEventListener('submit', saveReview);

function saveReview() {

    let title = $('#titleInput').val();
    let score = $('#scoreInput').val();
    let review = $('#reviewInput').val();

    let fullReview = {
    title: title,
    score: score,
    review: review,
    }
//Credit to CodingTheSmartWay on YouTube for this section
    if (localStorage.getItem('reviews') == null) {
        var reviews = [];
        reviews.push(fullReview);
        localStorage.setItem('reviews', JSON.stringify(reviews));
    } else {
        var reviews = JSON.parse(localStorage.getItem('reviews'));
        reviews.push(fullReview);
        localStorage.setItem('reviews', JSON.stringify(reviews));
    }

        document.getElementById('reviewForm').reset();

        fetchReviews();

}

fetchReviews();

function fetchReviews() {
    let reviews = JSON.parse(localStorage.getItem('reviews'));
    let reviewList = document.getElementById('reviewList');

    reviewList.innerHTML = '';

    for (i = 0; i < reviews.length; i++) {
        let title = reviews[i].title;
        let score = reviews[i].score;
        let review = reviews[i].review;

    reviewList.innerHTML += '<div class="container text-center" id="reviewItems">'+
                            '<h2>' + title + '</h2>'+
                            '<h4>' + score + '</h4>'+
                            '<h5>' + review + '</h5>'+
                            '</div>';
    }
}