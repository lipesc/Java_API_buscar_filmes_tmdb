let curretPage = 1;
document.addEventListener("DOMContentLoaded", () => {
  loadTopMovies(curretPage);


  document.getElementById('next-page-button').addEventListener('click', () => {
    curretPage++;
    loadTopMovies(curretPage);
  })
})
document.getElementById('search-input').addEventListener('keypress', function () {
  const query = document.getElementById('search-input').value;
  if (query) {
    searchMovies(query);
  }
});



function loadTopMovies(page) {
  fetch(`/movies/top/${page}`)
    .then(response => response.json())
    .then(data => {
      const moviesContainer = document.getElementById('movies-container');
      moviesContainer.innerHTML = ''; // Clear previous movies
      data.results.forEach(movie => {
        const movieElement = document.createElement('div');
        movieElement.className = 'movie';
        movieElement.innerHTML = `
        <img src="https://image.tmdb.org/t/p/original${movie.poster_path}" alt="poster movie"/>
        <h3>${movie.title}</h3>
        <p><strong>Título Original:</strong> ${movie.original_title}</p>
        <p>${movie.overview}</p>
        <p><strong>Data de Lançamento:</strong> ${movie.release_date}</p>
                    <p><strong>Média de Votos:</strong> ${movie.vote_average}</p>
                `;
        moviesContainer.appendChild(movieElement);
      });
    })
    .catch(error => console.error('Error fetching movies:', error));
}


function searchMovies(query) {
  fetch(`/movies/search/${query}`)
    .then(response => response.json())
    .then(data => {
      const search_movies_Container = document.getElementById('search-movies-container');
      search_movies_Container.innerHTML = '';
      data.results.forEach(movie => {
        const movieElement = document.createElement('div');
        movieElement.className = 'movie';
        movieElement.innerHTML = `
        <img src="https://image.tmdb.org/t/p/original${movie.poster_path}" alt="poster movie"/>
        <h2>${movie.title}</h2>
        <p><strong>Título Original:</strong> ${movie.original_title}</p>
        <p>${movie.overview}</p>
        <p><strong>Data de Lançamento:</strong> ${movie.release_date}</p>
                    <p><strong>Média de Votos:</strong> ${movie.vote_average}</p>
                `;
        search_movies_Container.appendChild(movieElement);
      });
    })
    .catch(error => console.error('Error searching movies:', error));
}