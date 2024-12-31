document.getElementById('search-button').addEventListener('click', function () {
  const query = document.getElementById('search-input').value;
  if (query) {
    searchMovies(query);
  }
});

function searchMovies(query) {
  fetch(`/movies/search/${query}`)
    .then(response => response.json())
    .then(data => {
      const moviesContainer = document.getElementById('movies-container');
      // moviesContainer.innerHTML = ' ';
      data.results.forEach(movie => {
        const movieElement = document.createElement('div');
        movieElement.className = 'movie';
        movieElement.innerHTML = `
          <h2>${movie.title}</h2>
           <p><strong>Título Original:</strong> ${movie.original_title}</p>
                    <p>${movie.overview}</p>
                    <p><strong>Data de Lançamento:</strong> ${movie.release_date}</p>
                    <p><strong>Média de Votos:</strong> ${movie.vote_average}</p>
                `;
        moviesContainer.appendChild(movieElement);
      });
    })
    .catch(error => console.error('Error searching movies:', error));
}