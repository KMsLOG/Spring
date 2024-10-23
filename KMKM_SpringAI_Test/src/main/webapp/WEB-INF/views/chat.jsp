<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>AI Chatbot</title>
    <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
    <style>
        #chatbox {
            width: 400px;
            height: 400px;
            border: 1px solid #ccc;
            overflow-y: scroll;
            padding: 10px;
            margin-bottom: 10px;
        }
        #userInput {
            width: 300px;
        }
    </style>
</head>
<body>
    <h1>AI Chatbot</h1>
    <div id="chatbox"></div>
    <input type="text" id="userInput" placeholder="메시지를 입력하세요...">
    <button onclick="sendMessage()">전송</button>

    <script>
        function sendMessage() {
            var userInput = document.getElementById('userInput');
            var message = userInput.value;
            if (message.trim() === '') return;

            appendMessage('You: ' + message);
            userInput.value = '';

            fetch('/ai/generate?message=' + encodeURIComponent(message))
                .then(response => response.json())
                .then(data => {
                    if (data.generation) {
                        appendMessage('AI: ' + marked.parse(data.generation));
                    } else if (data.error) {
                        appendMessage('Error: ' + data.error);
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    appendMessage('AI: 죄송합니다. 오류가 발생했습니다.');
                });
        }

        function appendMessage(message) {
            var chatbox = document.getElementById('chatbox');
            var messageElement = document.createElement('div');
            messageElement.innerHTML = message;
            chatbox.appendChild(messageElement);
            chatbox.scrollTop = chatbox.scrollHeight;
        }
    </script>
</body>
</html>