import http from 'k6/http';
import { check } from 'k6';

export let options = {
  stages: [
    { duration: '10s', target: 10 }, // Ramp-up to 1000 requests per second in 10 seconds
    { duration: '10s', target: 10 }, // Sustain 1000 requests per second for 30 seconds
    { duration: '5s', target: 0 },    // Ramp-down to 0 requests
  ],
};

export default function () {
  // Replace this URL with the actual endpoint you want to test
  const url = 'http://localhost:5000/movies/search/blade';

  // Include authentication token if needed
  // const headers = { Authorization: 'Bearer ...' };

  const payload = JSON.stringify({
    titulo: 'Test Task',
    descricao: 'This is a task created during load testing',
    status: 'Pendente',
  });

  const res = http.get(url);

  // Validate response
  check(res, {
    'status is 201': (r) => r.status === 201, // Check for HTTP 201 (Created)
    'response time < 200ms': (r) => r.timings.duration < 200, // Check response time
  });
}
