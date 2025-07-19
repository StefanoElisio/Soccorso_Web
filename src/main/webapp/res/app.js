document.addEventListener('DOMContentLoaded', function () {
    const API_BASE_URL = 'http://localhost:8080/SoccorsoWebREST/rest';
    let authToken = null;

    const loginBtn = document.getElementById('login-btn');
    const requestBtn = document.getElementById('request-btn');
    const statusFilter = document.getElementById('status-filter');
    const loadOperatorsBtn = document.getElementById('load-operators-btn');
    const loadRequestsBtn = document.getElementById('load-requests-btn');
    const logoutBtn = document.getElementById('logout-btn');
    const loginSection = document.getElementById('login-section');
    const operationsSection = document.getElementById('operations-section');

    loginBtn.addEventListener('click', async function (e) {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        if (username == "") showMessage('login-message', 'Inserisci Username', 'error');
        else if (password == "") showMessage('login-message', 'Inserisci Password', 'error');
        else {
            try {
                const response = await fetch(`${API_BASE_URL}/auth/login`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ username, password })
                });

                if (response.ok) {
                    authToken = response.headers.get('Authorization');
                    showMessage('login-message', 'Login effettuato!', 'success');
                    loginSection.classList.add('d-none');
                    operationsSection.classList.remove('d-none');
                } else {
                    showMessage('login-message', 'Credenziali non valide', 'error');
                }
            } catch (error) {
                showMessage('login-message', 'Errore di connessione', 'error');
                console.error('Login error:', error);
            }
        }
    });

    requestBtn.addEventListener('click', async function (e) {
        e.preventDefault();

        const requestData = {
            name: document.getElementById('name').value,
            email: document.getElementById('email').value,
            location: document.getElementById('location').value,
            description: document.getElementById('description').value
        };
        if (requestData.name == "") document.getElementById("request-message").textContent = 'Inserisci nome'
        else if (requestData.email == "") showMessage('request-message', 'Inserisci email', 'error');
        else if (requestData.location == "") showMessage('request-message', 'Inserisci location', 'error');
        else if (requestData.description == "") showMessage('request-message', 'Inserisci description', 'error');
        else {

            try {
                const response = await fetch(`${API_BASE_URL}/requests`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(requestData)
                });

                if (response.ok) {
                    showMessage('request-message', 'Richiesta inviata con successo!', 'success');
                    document.getElementById('request-form').reset();
                } else {
                    const error = await response.text();
                    showMessage('request-message', `Errore: ${error}`, 'error');
                }
            } catch (error) {
                showMessage('request-message', 'Errore di connessione', 'error');
            } finally {
                requestBtn.disabled = false;
                requestBtn.textContent = 'Invia Richiesta';
            }
        }
    });


    loadOperatorsBtn.addEventListener('click', async function () {

        try {
            const response = await fetch(`${API_BASE_URL}/operators/free`, {
                headers: { 'Authorization': authToken }
            });
            if (response.ok) {
                const operators = await response.json();
                renderOperators(operators);
                showMessage('operators-message', `Trovati ${operators.length} operatori`, 'success');
            } else {
                showMessage('operators-message', 'Errore nel caricamento', 'error');
            }
        } catch (error) {
            showMessage('operators-message', 'Errore di connessione', 'error');
            console.error('Operators error:', error);
        }
    });

    loadRequestsBtn.addEventListener('click', async function () {

        try {
            const response = await fetch(`${API_BASE_URL}/requests?status=${statusFilter.value}`, {
                headers: { 'Authorization': authToken }
            });
            if (response.ok) {
                const requests = await response.json();
                renderRequests(requests);
                showMessage('requests-message', `Trovate ${requests.length} richieste`, 'success');
            }
        } catch (error) {
            showMessage('requests-message', 'Errore di connessione', 'error');
            console.error('Error loading requests:', error);
        }
    })

    function renderRequests(requests) {
        const container = document.getElementById('requests-list');
        container.innerHTML = '';

        if (!requests || requests.length === 0) {
            container.innerHTML = '<div class="alert alert-info">Nessuna richiesta trovata</div>';
            return;
        }

        requests.forEach(request => {
            const item = document.createElement('div');
            item.className = 'list-group-item mb-2';
            item.innerHTML = `
                <h5>${request.name || 'N/D'}</h5>
                <p><strong>Stato:</strong> ${request.status || 'N/D'}</p>
                <p><strong>Email:</strong> ${request.email || 'N/D'}</p>
                <p><strong>Località:</strong> ${request.location || 'N/D'}</p>
                <p>${request.description || ''}</p>
            `;
            container.appendChild(item);
        });
    }

    function renderOperators(operators) {
        const container = document.getElementById('operators-list');
        container.innerHTML = '';

        if (!operators || operators.length === 0) {
            container.innerHTML = '<div class="alert alert-info">Nessun operatore libero</div>';
            return;
        }

        operators.forEach(operator => {
            const item = document.createElement('div');
            item.className = 'list-group-item mb-2';
            item.innerHTML = `
                <h5>${operator.username || 'N/D'}</h5>
                <p><strong>Nome:</strong> ${operator.registry?.name || 'N/D'} ${operator.registry?.surname || ''}</p>
                <p><strong>Competenze:</strong> ${operator.skills?.join(', ') || 'Nessuna'}</p>
                <p><strong>Patentini:</strong> ${operator.patents?.join(', ') || 'Nessuno'}</p>
            `;
            container.appendChild(item);
        });
    }

    logoutBtn.addEventListener('click', async function () {
        try {
            const response = await fetch(`${API_BASE_URL}/auth/logout`, {
                method: 'DELETE',
                headers: { 'Authorization': authToken }
            });

            if (response.ok) {
                authToken = null;
                operationsSection.classList.add('d-none');
                loginSection.classList.remove('d-none');
                showMessage('login-message', 'Logout effettuato', 'success');
            }
        } catch (error) {
            console.error('Logout error:', error);
        }
    });

    function showMessage(elementId, message, type) {
        const element = document.getElementById(elementId);
        element.textContent = message;
        element.className = `alert alert-${type} mt-3`;
    }
});