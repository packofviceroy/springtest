document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.forms['login'];

    loginForm.addEventListener('submit', async function (event) {
        event.preventDefault(); // Предотвращает отправку формы по умолчанию

        // Получение данных из формы
        const username = loginForm.t_username.value;
        const password = loginForm.t_password.value;
        const rememberMe = loginForm.remember_me.checked;

        // Подготовка тела запроса
        const requestData = {
            username: username,
            password: password,
            rememberMe: rememberMe
        };

        try {
            // Отправка POST-запроса к API
            const response = await fetch('/api/rest/security/signin', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestData)
            });

            if (response.ok) {
                // Обработка успешного ответа
                const data = await response.text();
                // Сохранение токена в localStorage (или другом месте)
                localStorage.setItem('jwtToken', data);
                // Перенаправление пользователя
                window.location.href = '/main_page';
            } else {
                // Обработка ошибок
                const errorData = await response.json();
                alert(`Login failed: ${errorData.message || 'Unknown error'}`);
                window.location.href = '/loginError'
            }
        } catch (error) {
            console.error('Error during login:', error);
            alert('An error occurred. Please try again later.');
        }
    });
});
