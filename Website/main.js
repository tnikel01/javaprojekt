const btn12 = document.getElementById('btn12');
const messageContainer = document.getElementById('addCard');

btn12.addEventListener('click', function() {
  const newMessage = document.createElement('p');

  newMessage.textContent = 'Hello! This is your new message!';

  messageContainer.appendChild(newMessage);
});