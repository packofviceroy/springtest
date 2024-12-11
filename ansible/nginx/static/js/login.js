document.addEventListener('DOMContentLoaded', function () {
    const loginForm = document.forms['login'];

    loginForm.addEventListener('submit', async function (event) {
        event.preventDefault(); // Предотвращает отправку формы по умолчанию

        // Получение данных из формы
        const username = loginForm.t_username.value;
        const password = loginForm.t_password.value;
        const rememberMe = loginForm.remember_me.checked;

        try {
            // Подготовка параметров URL
            const queryParams = new URLSearchParams({
                username: username,
                password: password,
                rememberMe: rememberMe
            }).toString();

            // Отправка GET-запроса с параметрами в URL
            const response = await fetch(`/api/rest/security/signin?${queryParams}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (response.ok) {
                // Обработка успешного ответа
                const token = await response.text(); // Ответ в виде строки

                // Сохранение токена в localStorage (или другом месте)
                localStorage.setItem('jwtToken', token);
                alert('Login successful! Token saved.');

                // Перенаправление пользователя
                window.location.href = '/main_page';
            } else {
                // Обработка ошибок
                const errorText = await response.text();
                alert(`Login failed: ${errorText || 'Unknown error'}`);
            }
        } catch (error) {
            console.error('Error during login:', error);
            alert('An error occurred. Please try again later.');
        }
    });
});
